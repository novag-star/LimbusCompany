package Co.edu.uniquindio.poo.Model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VehiculoTest {

    @Test
    public void testCalcularPeajeCarroElectrico() {
        Carro carroElectrico = new Carro("ABC-123", 0, true, false);
        double resultadoEsperado = 8000.0;
        double resultadoReal = carroElectrico.calcularPeaje();
        assertEquals(resultadoEsperado, resultadoReal, "El cálculo del peaje para el carro eléctrico es incorrecto.");
    }
}