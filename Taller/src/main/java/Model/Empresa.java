package Model;
import java.util.ArrayList;
import java.util.Optional;

public class Empresa {

    //atributos

    private String nombre;
    private ArrayList<Empleado> listaEmpleados;

    //Constructor

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.listaEmpleados = new ArrayList<>();
    }

    //metodos

    public void agregarEmpleado(Empleado emp) {
        listaEmpleados.add(emp);
    }
    public String obtenerTodosLosEmpleados() {
        if (listaEmpleados.isEmpty()) return "No hay empleados registrados.";
        StringBuilder sb = new StringBuilder("LISTA DE EMPLEADOS\n");
        for (Empleado emp : listaEmpleados) {
            sb.append(emp.obtenerInformacion()).append("----------------------\n");
        }
        return sb.toString();
    }

    public Optional<Empleado> buscarEmpleado(String documento) {
        return listaEmpleados.stream()
                .filter(empleado -> empleado.getDocumento().equals(documento))
                .findAny(); // Más eficiente en procesos paralelos y semánticamente correcto para IDs únicos
    }

    public String EmpleadoMayorSalario() {
        if (listaEmpleados.isEmpty()) return "No hay empleados para comparar.";
        Empleado topEmpleado = listaEmpleados.get(0);
        for (Empleado emp : listaEmpleados) {
            if (emp.calcularSalarioNeto() > topEmpleado.calcularSalarioNeto()) {
                topEmpleado = emp;
            }
        }
        return "El empleado con mayor salario neto es:\n" + topEmpleado.generarResumenPago().toString();
    }

    public String NominaTotal() {
        if (listaEmpleados.isEmpty()) return "No hay nómina que calcular.";
        float nominaBruta = 0;
        float nominaNeta = 0;
        for (Empleado emp : listaEmpleados) {
            nominaBruta += emp.calcularSalarioBruto();
            nominaNeta += emp.calcularSalarioNeto();
        }
        return String.format("=== NÓMINA TOTAL ===\nTotal Salarios Brutos: $%.2f\nTotal Salarios Netos: $%.2f", nominaBruta, nominaNeta);
    }

    public String ResumenesPago() {
        if (listaEmpleados.isEmpty()) return "No hay empleados registrados.";
        StringBuilder sb = new StringBuilder("RESÚMENES DE PAGO\n");
        for (Empleado emp : listaEmpleados) {
            sb.append(emp.generarResumenPago().toString()).append("----------------------\n");
        }
        return sb.toString();
    }
}