package Co.edu.uniquindio.poo.Model;
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;


public class Empresa {
    private String nombre;
    private ArrayList<Empleado> listaEmpleados;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.listaEmpleados = new ArrayList();
    }

    public void agregarEmpleado(Empleado emp) {
        boolean existe = this.listaEmpleados.stream()
                .anyMatch(e -> e.getDocumento().equals(emp.getDocumento()));
        if (existe) {
            throw new IllegalArgumentException("Ya existe un empleado con el documento: " + emp.getDocumento());
        }
        this.listaEmpleados.add(emp);
    }

    public String obtenerTodosLosEmpleados() {
        if (this.listaEmpleados.isEmpty()) {
            return "No hay empleados registrados.";
        } else {
            StringBuilder sb = new StringBuilder("LISTA DE EMPLEADOS\n");

            for(Empleado emp : this.listaEmpleados) {
                sb.append(emp.obtenerInformacion()).append("----------------------\n");
            }

            return sb.toString();
        }
    }

    public Optional<Empleado> buscarEmpleado(String documento) {
        return this.listaEmpleados.stream().filter((empleado) -> empleado.getDocumento().equals(documento)).findAny();
    }

    public String EmpleadoMayorSalario() {
        if (this.listaEmpleados.isEmpty()) {
            return "No hay empleados para comparar.";
        } else {
            Empleado topEmpleado = (Empleado)this.listaEmpleados.get(0);

            for(Empleado emp : this.listaEmpleados) {
                if (emp.calcularSalarioNeto() > topEmpleado.calcularSalarioNeto()) {
                    topEmpleado = emp;
                }
            }

            return "El empleado con mayor salario neto es:\n" + topEmpleado.generarResumenPago().toString();
        }
    }

    public String NominaTotal() {
        if (this.listaEmpleados.isEmpty()) {
            return "No hay nómina que calcular.";
        } else {
            float nominaBruta = 0.0F;
            float nominaNeta = 0.0F;

            for(Empleado emp : this.listaEmpleados) {
                nominaBruta += emp.calcularSalarioBruto();
                nominaNeta += emp.calcularSalarioNeto();
            }

            return String.format("=== NÓMINA TOTAL ===\nTotal Salarios Brutos: $%.2f\nTotal Salarios Netos: $%.2f", nominaBruta, nominaNeta);
        }
    }

    public String ResumenesPago() {
        if (this.listaEmpleados.isEmpty()) {
            return "No hay empleados registrados.";
        } else {
            StringBuilder sb = new StringBuilder("RESÚMENES DE PAGO\n");

            for(Empleado emp : this.listaEmpleados) {
                sb.append(emp.generarResumenPago().toString()).append("----------------------\n");
            }

            return sb.toString();
        }
    }


    public List<Empleado> empleadosConSalarioMayor(float valor) {
        return this.listaEmpleados.stream()
                .filter(emp -> emp.calcularSalarioNeto() > valor)
                .collect(Collectors.toList());
    }

}
