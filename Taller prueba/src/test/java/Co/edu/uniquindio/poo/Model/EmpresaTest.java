package Co.edu.uniquindio.poo.Model;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

public class EmpresaTest {
    private static final Logger LOG = Logger.getLogger(EmpresaTest.class.getName());

    @Test //#3
    public void EmpleadosAlmacenadosCorrectamente() {
        LOG.info("Iniciando test: Empleados Almacenados Correctamente");
        Empresa empresa = new Empresa("Tech");
        EmpleadoVentas emp = new EmpleadoVentas("Juan", "111",
                25, 1000f, CategoriaEmpleado.JUNIOR, 4f,
                4f, 1000f, 10f);
        empresa.agregarEmpleado(emp);
        String info = empresa.obtenerTodosLosEmpleados();
        assertTrue(info.contains("Juan") && info.contains("111"));
        LOG.info("Finalizando test: Empleados Almacenados Correctamente");
    }


    @Test //#11
    public void verificarEmpleadoMayorSalarioCorrecto() {
        LOG.info("Iniciando test: verificar Empleado Mayor Salario Correcto");
        Empresa empresa = new Empresa("Tech");
        EmpleadoVentas empPobre = new EmpleadoVentas("Juan", "111",
                25, 1000f, CategoriaEmpleado.JUNIOR, 0f,
                0f, 0f, 0f);
        EmpleadoVentas empRico = new EmpleadoVentas("Pedro", "222",
                30, 5000f, CategoriaEmpleado.SENIOR, 0f,
                0f, 0f, 0f);
        empresa.agregarEmpleado(empPobre);
        empresa.agregarEmpleado(empRico);
        String resultado = empresa.EmpleadoMayorSalario();
        assertTrue(resultado.contains("Pedro"));
        LOG.info("Finalizando test: verificar Empleado Mayor Salario Correcto");
    }



    @Test //#8
    public void verificarEmpleadosConSalarioMayorA() {
        LOG.info("Iniciando test: verificar Empleados ConSalario Mayor A");
        Empresa empresa = new Empresa("Tech");
        EmpleadoVentas emp1 = new EmpleadoVentas("Ana", "111", 25,
                1000f, CategoriaEmpleado.JUNIOR, 0f, 0f,
                0f, 0f);
        EmpleadoVentas emp2 = new EmpleadoVentas("Luis", "222",
                30, 2000f, CategoriaEmpleado.SENIOR, 0f,
                0f, 0f, 0f);
        EmpleadoVentas emp3 = new EmpleadoVentas("Marta", "333",
                28, 3000f, CategoriaEmpleado.SEMI_SENIOR, 0f,
                0f, 0f, 0f);
        empresa.agregarEmpleado(emp1);
        empresa.agregarEmpleado(emp2);
        empresa.agregarEmpleado(emp3);
        List<Empleado> resultado = empresa.empleadosConSalarioMayor(2000f);
        assertEquals(2, resultado.size());
        assertEquals("222", resultado.get(0).getDocumento());
        assertEquals("333", resultado.get(1).getDocumento());
        LOG.info("Finalizando test: verificar Empleados ConSalario Mayor A");
    }



    @Test //#10
    public void validarNoAgregarEmpleadosDuplicados() {
        LOG.info("Iniciando test: validar No Agregar Empleados Duplicados");
        Empresa empresa = new Empresa("Tech");
        EmpleadoVentas emp1 = new EmpleadoVentas("Juan", "111",
                25, 1000f, CategoriaEmpleado.JUNIOR, 4f,
                4f, 1000f, 10f);
        EmpleadoVentas emp2 = new EmpleadoVentas("Copia", "111", 30,
                1500f, CategoriaEmpleado.SENIOR, 4f, 4f,
                0f, 0f);
        empresa.agregarEmpleado(emp1);
        assertThrows(IllegalArgumentException.class, () -> {
            empresa.agregarEmpleado(emp2);
        });
        LOG.info("Finalizando test: validar No Agregar Empleados Duplicados");
    }
}