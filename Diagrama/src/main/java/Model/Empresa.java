package Model;

import java.time.LocalTime;
import java.util.ArrayList;

public class Empresa {
    // Atributos
    private String nombre;
    private ArrayList<Empleado> listaEmpleados;

    // Constructor
    public Empresa(String nombre) {
        this.nombre = nombre;
        // Inicializamos la lista de empleados
        this.listaEmpleados = new ArrayList<>();
    }


    public void agregarEmpleado(Empleado empleado) {
        this.listaEmpleados.add(empleado);
    }


    public ArrayList<Empleado> consultarEmpleadosTarde(LocalTime horaEntradaEmpresa) {
        ArrayList<Empleado> resultado = new ArrayList<>();

        for (int i = 0; i < listaEmpleados.size(); i++) {
            Empleado empleadoAux = listaEmpleados.get(i);

            if (empleadoAux.llegoTarde(horaEntradaEmpresa)) {
                resultado.add(empleadoAux);
            }
        }

        return resultado;
    }
}