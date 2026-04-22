package Co.edu.uniquindio.poo.Model;

import org.junit.jupiter.api.Test;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;
public class EmpleadoTemporalTest {
    private static final Logger LOG = Logger.getLogger(EmpleadoTemporalTest.class.getName());

    @Test //#2
    public void SalarioNetoDiferenteDeCero() {
        LOG.info("Iniciando test: Salario Neto Diferente De Cero");
        EmpleadoTemporal emp = new EmpleadoTemporal("Ana", "222",
                28, 1000f, CategoriaEmpleado.SENIOR, 4f,
                4f, 15, 50f);
        assertNotEquals(0f, emp.calcularSalarioNeto());
        LOG.info("Finalizando test: Salario Neto Diferente De Cero");
    }


    @Test //#14
    public void salarioNetoTemporalMayorACeroConDatosValidos() {
        LOG.info("Iniciando test: salario Neto Temporal Mayor A Cero Con Datos Validos");
        EmpleadoTemporal emp = new EmpleadoTemporal("Luis", "333",
                30, 1000f,
                CategoriaEmpleado.JUNIOR, 4f,
                4f, 10, 50f);
        assertTrue(emp.calcularSalarioNeto() > 0f);
        LOG.info("Finalizando test: salario Neto Temporal Mayor A Cero Con Datos Validos");
    }

}