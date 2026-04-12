package Main;

import Model.Empleado;
import Model.Empresa;
import javax.swing.JOptionPane;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class mains {
    public static void main(String[] args) {
        // 1. Creamos una nueva empresa
        Empresa miEmpresa = new Empresa("Mi empresa");

        // 2. Creamos y agregamos empleados
        miEmpresa.agregarEmpleado(new Empleado("Ana Gómez", "1001", LocalTime.of(7, 45), LocalTime.of(17, 0)));
        miEmpresa.agregarEmpleado(new Empleado("Carlos Ruiz", "1002", LocalTime.of(8, 0), LocalTime.of(17, 0)));
        miEmpresa.agregarEmpleado(new Empleado("María Pérez", "1003", LocalTime.of(8, 15), LocalTime.of(17, 0)));
        miEmpresa.agregarEmpleado(new Empleado("Juan López", "1004", LocalTime.of(9, 30), LocalTime.of(17, 0)));

        // 3. Pedimos la hora de entrada a la empresa
        String inputHora = JOptionPane.showInputDialog(null,
                "Ingrese la hora de entrada (formato HH:MM, ej. 08:00):",
                "Control de Entrada",
                JOptionPane.QUESTION_MESSAGE);
        if (inputHora == null || inputHora.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cerrando.");
            return;
        }
        LocalTime horaEntradaOficial;
        try {
            horaEntradaOficial = LocalTime.parse(inputHora);
        } catch (DateTimeParseException e) {
            // Si el usuario escribe algo que no es una hora válida (ej: "hola"), mostramos error
            JOptionPane.showMessageDialog(null,
                    "Oiga. Por favor use el formato HH:MM (ej. 08:00).",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 4. Consultamos qué empleados llegaron tarde
        ArrayList<Empleado> llegaronTarde = miEmpresa.consultarEmpleadosTarde(horaEntradaOficial);

        // 5. Construimos el mensaje usando concatenación simple de Strings
        String mensajeSalida = "Hora de entrada oficial: " + horaEntradaOficial + "\n" +
                "--\n" +
                "Lista de empleados que llegaron tarde:\n\n";
        if (llegaronTarde.isEmpty()) {
            mensajeSalida += "Todos llegaron a tiempo.\n";
        } else {
            for (Empleado empleado : llegaronTarde) {
                // Usamos += para ir agregando cada empleado al texto final
                mensajeSalida += "• " + empleado.getNombre() +
                        " (Llegó a las " + empleado.getHoraEntrada() + ")\n";
            }
        }

        // 6. Mostramos el resultado final en un cuadro de diálogo
        // Nota: Ahora pasamos "mensajeSalida" directamente sin el .toString()
        JOptionPane.showMessageDialog(null,
                mensajeSalida,
                "Reporte de Tardanzas",
                JOptionPane.INFORMATION_MESSAGE);
    }
}