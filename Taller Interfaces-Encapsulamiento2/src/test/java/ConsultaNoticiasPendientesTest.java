import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import Co.edu.uniquindio.poo.Model.*;

    public class ConsultaNoticiasPendientesTest {

        private GestorNotificacion gestor;
        private Noticia n1;
        private Noticia n2;
        private Noticia n3;

        @BeforeEach
        public void setUp() {
            gestor = new GestorNotificacion();

            n1 = new Noticia("Parcial de Programación", "Mañana", EstadoNoticia.PENDIENTE);
            n2 = new Noticia("Entrega parcial 2", "Viernes", EstadoNoticia.PENDIENTE);
            n3 = new Noticia("Parcial Final", "Cerrado", EstadoNoticia.ENVIADA);

            gestor.agregarNoticia(n1);
            gestor.agregarNoticia(n2);
            gestor.agregarNoticia(n3);
        }

        @Test
        public void testBuscarPalabraExistente() {
            List<Noticia> resultado = gestor.consultarNoticiasPendientesPorKeyword("Parcial");

            assertNotNull(resultado);
            assertEquals(2, resultado.size());
            assertTrue(resultado.contains(n1));
            assertTrue(resultado.contains(n2));
            assertFalse(resultado.contains(n3));
        }

        @Test
        public void testBuscarPalabraNoExistente() {
            List<Noticia> resultado = gestor.consultarNoticiasPendientesPorKeyword("Deportes");

            assertNotNull(resultado);
            assertTrue(resultado.isEmpty());
        }
    }