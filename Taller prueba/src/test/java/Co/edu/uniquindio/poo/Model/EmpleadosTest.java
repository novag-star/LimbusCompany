package Co.edu.uniquindio.poo.Model;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class EmpleadosTest {
    private static final Logger LOG = Logger.getLogger(EmpleadosTest.class.getName());
    @Test //#4
    public void verificarBonificacionJunior() {
        LOG.info("Iniciando test: verificar Bonificacion Junior");
        EmpleadoVentas emp = new EmpleadoVentas("Juan", "111",
                25, 1000f, CategoriaEmpleado.JUNIOR, 4f,
                4f, 1000f, 10f);
        assertTrue(emp.calcularBonificacionCategoria() > 0);
        LOG.info("Finalizando test: verificar Bonificacion Junior");
    }



    @Test //#5
    public void SalarioNetoNoNegativo() {
        LOG.info("Iniciando test: Salario Neto No Negativo");
        EmpleadoVentas emp = new EmpleadoVentas("Juan", "111", 25,
                1000f, CategoriaEmpleado.JUNIOR, 50f, 50f,
                0f, 0f);
        assertTrue(emp.calcularSalarioNeto() >= 0);
        LOG.info("Finalizando test: Salario Neto No Negativo");
    }


    @Test //#6
    public void verificarBusquedaRetornaVacio() {
        LOG.info("Iniciando test: verificar Busqueda Retorna Vacio (Null)");
        Empresa empresa = new Empresa("Tech");
        Optional<Empleado> resultado = empresa.buscarEmpleado("666");
        assertTrue(resultado.isEmpty());
        LOG.info("Finalizando test: verificar que Busqueda Retorna Vacio");
    }


    @Test //#7
    public void ExcepcionSalarioBaseNegativo() {
        LOG.info("Iniciando test: Excepcion de Salario Base Negativo");
        assertThrows(IllegalArgumentException.class, () -> {
            new EmpleadoVentas("Juan", "111", 25, -500f,
                    CategoriaEmpleado.JUNIOR, 4f, 4f,
                    1000f,
                    10f);
        });
        LOG.info("Finalizando test: Excepcion de Salario Base Negativo");
    }

}