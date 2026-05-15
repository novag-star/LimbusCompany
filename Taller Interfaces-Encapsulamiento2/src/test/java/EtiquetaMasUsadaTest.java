import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Co.edu.uniquindio.poo.Model.*;
public class EtiquetaMasUsadaTest {

    private GestorNotificacion gestor;

    @BeforeEach
    public void setUp() {
        gestor = new GestorNotificacion();
    }

    @Test
    public void testObtenerEtiquetaGanadora() {
        Noticia n1 = new Noticia("Noticia 1", "Desc", EstadoNoticia.PENDIENTE);
        n1.agregarEtiqueta("Académico");
        n1.agregarEtiqueta("Urgente");

        Noticia n2 = new Noticia("Noticia 2", "Desc", EstadoNoticia.PENDIENTE);
        n2.agregarEtiqueta("Académico");
        n2.agregarEtiqueta("Deportes");

        Noticia n3 = new Noticia("Noticia 3", "Desc", EstadoNoticia.ENVIADA);
        n3.agregarEtiqueta("Deportes");
        n3.agregarEtiqueta("Académico");

        gestor.agregarNoticia(n1);
        gestor.agregarNoticia(n2);
        gestor.agregarNoticia(n3);

        String ganadora = gestor.obtenerEtiquetaMasUsada();

        assertEquals("Académico", ganadora);
    }

    @Test
    public void testObtenerEtiquetaSinNoticias() {
        String resultado = gestor.obtenerEtiquetaMasUsada();

        assertEquals("No hay noticias", resultado);
    }
}