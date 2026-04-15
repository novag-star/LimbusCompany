package Main;
import Model.CategoriaEmpleado;
import Model.EmpleadoPlantas;
import Model.EmpleadoTemporal;
import Model.EmpleadoVentas;
import Model.Empresa;
import javax.swing.JOptionPane;

/*
    Documentacion:Juan camilo Nova garcia
    Licencia:GNU-GPL-V3
    Fecha Ultima actualizacion:13/04/26
 */

public class maiin {
    private static Empresa empresa = new Empresa("Empresa X");

    public static void main(String[] args) {
        String menu = "Menu gestion\n"
                + "1. Agregar empleado de planta\n"
                + "2. Agregar empleado de venta\n"
                + "3. Agregar empleado temporal\n"
                + "4. Mostrar todos los empleados actuales\n"
                + "5. Buscar un empleado por su documento\n"
                + "6. Mostrar empleado con el mayor salario neto\n"
                + "7. Mostrar nomina total\n"
                + "8. Mostrar resumen de pagos\n"
                + "9. Salir del programa\n\n"
                + "Seleccione una opción:";

        int opcion = 0;

        do {
            try {
                String input = JOptionPane.showInputDialog(null, menu, "Menú Principal", JOptionPane.QUESTION_MESSAGE);

                if (input == null) break;

                opcion = Integer.parseInt(input);

                switch (opcion) {
                    case 1: agregarEmpleado(1); break;
                    case 2: agregarEmpleado(2); break;
                    case 3: agregarEmpleado(3); break;
                    case 4:
                        JOptionPane.showMessageDialog(null,
                                empresa.obtenerTodosLosEmpleados(),
                                "Lista de Empleados",
                                JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 5:
                        String doc = JOptionPane.showInputDialog("Ingrese el documento a buscar:");
                        if (doc != null && !doc.trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, empresa.buscarEmpleado(doc));
                        }
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, empresa.EmpleadoMayorSalario(), "Mayor Salario Neto", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null, empresa.NominaTotal(), "Nómina Total", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 8:
                        JOptionPane.showMessageDialog(null, empresa.ResumenesPago(), "Resúmenes de Pago", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 9:
                        JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion != 9);
    }

    private static void agregarEmpleado(int tipo) {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre:");
            if(nombre == null) return;

            String documento = JOptionPane.showInputDialog("Documento:");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
            float salarioBase = Float.parseFloat(JOptionPane.showInputDialog("Salario Base:"));

            String[] opcionesCat = {"JUNIOR", "SEMI_SENIOR", "SENIOR"};
            int catSeleccion = JOptionPane.showOptionDialog(null, "Seleccione la categoría:", "Categoría",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesCat, opcionesCat[0]);

            CategoriaEmpleado categoria = CategoriaEmpleado.values()[catSeleccion];

            float descSalud = Float.parseFloat(JOptionPane.showInputDialog("Descuento Salud (%):"));
            float descPension = Float.parseFloat(JOptionPane.showInputDialog("Descuento Pensión (%):"));

            if (tipo == 1) {
                String cargo = JOptionPane.showInputDialog("Cargo:");
                int horasExtra = Integer.parseInt(JOptionPane.showInputDialog("Horas Extra:"));
                float valorHora = Float.parseFloat(JOptionPane.showInputDialog("Valor Hora Extra:"));
                float auxTransporte = Float.parseFloat(JOptionPane.showInputDialog("Auxilio de Transporte:"));

                empresa.agregarEmpleado(new EmpleadoPlantas(nombre, documento, edad, salarioBase, categoria, descSalud, descPension, cargo, horasExtra, valorHora, auxTransporte));

            } else if (tipo == 2) {
                float ventas = Float.parseFloat(JOptionPane.showInputDialog("Total Ventas del Mes:"));
                float comision = Float.parseFloat(JOptionPane.showInputDialog("Porcentaje de Comisión (%):"));

                empresa.agregarEmpleado(new EmpleadoVentas(nombre, documento, edad, salarioBase, categoria, descSalud, descPension, ventas, comision));

            } else if (tipo == 3) {
                int dias = Integer.parseInt(JOptionPane.showInputDialog("Días Trabajados:"));
                float valorDia = Float.parseFloat(JOptionPane.showInputDialog("Valor por Día:"));

                empresa.agregarEmpleado(new EmpleadoTemporal(nombre, documento, edad, salarioBase, categoria, descSalud, descPension, dias, valorDia));
            }

            JOptionPane.showMessageDialog(null, "Empleado registrado con éxito.");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Ingrese valores numéricos donde corresponda.", "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }
}