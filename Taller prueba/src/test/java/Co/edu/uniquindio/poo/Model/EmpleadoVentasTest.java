package Co.edu.uniquindio.poo.Model;

import org.junit.jupiter.api.Test;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;
public class EmpleadoVentasTest {
    private static final Logger LOG = Logger.getLogger(EmpleadoVentasTest.class.getName());

    @Test //#1
    public void verificarSalarioBruto() {
        LOG.info("Iniciando test: verificar Salario Bruto");
        EmpleadoVentas emp = new EmpleadoVentas("Juan", "111", 25,
                1000f, CategoriaEmpleado.JUNIOR, 4f, 4f,
                1000f, 10f);
        assertEquals(1150f, emp.calcularSalarioBruto());
        LOG.info("Finalizando test: verificar Salario Bruto");
    }
}