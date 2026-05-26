package co.edu.uniquindio.poo.inmobilaria.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas del sistema inmobiliario")
public class InmobiliariaTest {

    private static final Logger log = Logger.getLogger(InmobiliariaTest.class.getName());

    private Inmobilaria inmobiliaria;
    private Vendedor vendedor;
    private Comprador comprador;
    private Inmueble casa;

    @BeforeEach
    public void setup() {
        log.info("Iniciando configuración de pruebas...");


        inmobiliaria = new Inmobilaria("Inmobiliaria Universidad");

        vendedor = new Vendedor(1, "David Barrero", "123456", "passVendedor", "310111", "dav@email.com", 0);
        comprador = new Comprador(2, "Ana Pata", "876543", "passComprador", "320999", "ana@email.com", 0, "Casa");

        casa = new Inmueble("001", TipoInmueble.CASA, "Cerca aeropuerto", "Armenia", "150", 200000000.0, vendedor);

        log.info("Vendedor, comprador y casa configurados correctamente.");
    }

    @Test
    @DisplayName("Demostración: Registro de Usuarios")
    public void testRegistroUsuarios() {
        log.info("Ejecutando Test: Verificación del Registro de Usuarios");

        assertTrue(inmobiliaria.registrarusuario(vendedor), "El vendedor debería registrarse con éxito.");
        assertTrue(inmobiliaria.registrarusuario(comprador), "El comprador debería registrarse con éxito.");

        log.info("Validando duplicidad de identidad...");

        Vendedor vendedorDuplicado = new Vendedor(3, "El Hacker", "123456", "passHacker", "310000", "hacker@email.com", 0);
        assertFalse(inmobiliaria.registrarusuario(vendedorDuplicado), "Se debe rechazar usuarios con identificación duplicada.");
    }

    @Test
    @DisplayName("Demostración: Publicación de Propiedades")
    public void testPublicacionPropiedades() {
        vendedor.registrarinmueble(casa);
        assertEquals(1, vendedor.getCantidadpropiedad(), "El vendedor debería tener 1 propiedad registrada.");

        assertTrue(inmobiliaria.agregarinmueble(casa), "La inmobiliaria debe aceptar el inmueble.");

        vendedor.publicarinmueble(casa);
        assertEquals(Estado.DISPONIBLE, casa.getEstado(), "El inmueble debe estar marcado como disponible.");
    }

    @Test
    @DisplayName("Demostración: Realización de Ofertas")
    public void testRealizacionOfertas() {
        Oferta ofertaPropuesta = new Oferta("OFERTA-01", comprador, casa, 195000000.0);

        assertNotNull(ofertaPropuesta);
        assertEquals(195000000.0, ofertaPropuesta.getValoroferta(), 0.001);
        assertEquals(EstadoOferta.PENDIENTE, ofertaPropuesta.getEstado(), "La oferta debe iniciar como PENDIENTE.");
    }

    @Test
    @DisplayName("Demostración: Compra de Inmueble")
    public void testCompraInmueble() {
        inmobiliaria.registrarusuario(vendedor);
        inmobiliaria.registrarusuario(comprador);
        inmobiliaria.agregarinmueble(casa);

        Oferta oferta = new Oferta("OFERTA-01", comprador, casa, 195000000.0);
        oferta.aceptaroferta();
        casa.setEstado(Estado.VENDIDO);

        Transaccion negocioCerrado = new Transaccion(
                "TR-001", comprador, vendedor, casa,
                oferta.getValoroferta(), TipoOperacion.VENTA, LocalDateTime.now()
        );

        assertTrue(inmobiliaria.registrartransaccion(negocioCerrado));
        assertEquals(Estado.VENDIDO, casa.getEstado());
    }

    @Test
    @DisplayName("Demostración: Generación de Reportes")
    public void testGeneracionReportes() {

        inmobiliaria.agregarinmueble(casa);
        vendedor.registrarinmueble(casa);
        casa.setEstado(Estado.VENDIDO);


        assertEquals(200000000.0, vendedor.calcularbeneficio(), 0.001);


        List<Inmueble> reporteInmueblesVendidos = inmobiliaria.reporteInmueblesMasVendidos();

        assertNotNull(reporteInmueblesVendidos);
        assertFalse(reporteInmueblesVendidos.isEmpty(), "El reporte debe contener inmuebles si hay ventas.");
        assertEquals("001", reporteInmueblesVendidos.get(0).getCodigo(), "El código del inmueble en el reporte debe coincidir.");
    }
}