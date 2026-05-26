package co.edu.uniquindio.poo.inmobilaria.model;

import java.util.ArrayList;
import java.util.List;

public class Reporte {


    public List<Inmueble> obtenerInmueblesMasVendidos(List<Inmueble> listainmueble) {
        List<Inmueble> inmueblesVendidos = new ArrayList<>();
        for (int i = 0; i < listainmueble.size(); i++) {
            Inmueble inmueble = listainmueble.get(i);
            if (inmueble.getEstado() == Estado.VENDIDO) {
                inmueblesVendidos.add(inmueble);
            }
        }
        return inmueblesVendidos;
    }


    public List<String> obtenerCiudadesMayorDemanda(List<Transaccion> transacciones) {
        List<String> ciudades = new ArrayList<>();
        if (transacciones == null || transacciones.isEmpty()) {
            return ciudades;
        }

        String ciudadConMasTransacciones = null;
        int maximo = 0;

        for (int i = 0; i < transacciones.size(); i++) {
            Transaccion transaccionActual = transacciones.get(i);
            if (transaccionActual == null || transaccionActual.inmueble() == null || transaccionActual.inmueble().getCiudad() == null) {
                continue;
            }
            String ciudadActual = transaccionActual.inmueble().getCiudad();
            int contador = 0;

            for (int j = 0; j < transacciones.size(); j++) {
                Transaccion otraTransaccion = transacciones.get(j);
                if (otraTransaccion == null || otraTransaccion.inmueble() == null || otraTransaccion.inmueble().getCiudad() == null) {
                    continue;
                }
                if (ciudadActual.equals(otraTransaccion.inmueble().getCiudad())) {
                    contador++;
                }
            }

            if (contador > maximo) {
                maximo = contador;
                ciudadConMasTransacciones = ciudadActual;
            }
        }

        if (ciudadConMasTransacciones != null) {
            ciudades.add(ciudadConMasTransacciones);
        }
        return ciudades;
    }

    public List<Usuario> obtenerCompradoresActivos(List<Usuario> listausuario) {
        List<Usuario> compradoresActivos = new ArrayList<>();
        for (int i = 0; i < listausuario.size(); i++) {
            Usuario usuario = listausuario.get(i);

            if (usuario instanceof Comprador) {
                if (usuario.puntoreputacion > 100) {
                    compradoresActivos.add(usuario);
                }
            }
        }
        return compradoresActivos;
    }


    public List<Vendedor> obtenerVendedoresConMasPropiedades(List<Usuario> listausuario) {
        List<Vendedor> vendedores = new ArrayList<>();
        for (int i = 0; i < listausuario.size(); i++) {
            Usuario usuario = listausuario.get(i);
            if (usuario instanceof Vendedor) {
                Vendedor vendedor = (Vendedor) usuario;
                if (vendedor.getCantidadpropiedad() > 0) {
                    vendedores.add(vendedor);
                }
            }
        }
        return vendedores;
    }
}