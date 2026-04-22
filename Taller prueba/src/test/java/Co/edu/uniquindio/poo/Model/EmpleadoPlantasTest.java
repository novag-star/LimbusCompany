package Co.edu.uniquindio.poo.Model;
import org.junit.jupiter.api.Test;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoPlantasTest {
    private static final Logger LOG = Logger.getLogger(EmpleadoPlantasTest.class.getName());

    @Test //#13
    public void verificarNetoPlantaMayorASalarioBase() {
        LOG.info("Iniciando test: verificar Neto Planta Mayor A Salario Base");
        EmpleadoPlantas emp = new EmpleadoPlantas("Carlos", "333", 40,
                1000f, CategoriaEmpleado.JUNIOR, 4f, 4f,
                "Operario", 10, 50f, 200f);
        assertTrue(emp.calcularSalarioNeto() > 1000f);
        LOG.info("Finalizando test: verificar Neto Planta Mayor A Salario Base");
    }
}