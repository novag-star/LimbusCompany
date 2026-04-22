package Co.edu.uniquindio.poo.Ryoshu;

import Co.edu.uniquindio.poo.Model.CategoriaEmpleado;
import Co.edu.uniquindio.poo.Model.EmpleadoPlantas;
import Co.edu.uniquindio.poo.Model.EmpleadoTemporal;
import Co.edu.uniquindio.poo.Model.EmpleadoVentas;
import Co.edu.uniquindio.poo.Model.Empresa;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class Ryoshu {
    private static Empresa empresa = new Empresa("Empresa X");

    public static void main(String[] args) {
        String menu = "Menu gestion\n1. Agregar empleado de planta\n2. Agregar empleado de venta\n3. Agregar empleado temporal\n4. Mostrar todos los empleados actuales\n5. Buscar un empleado por su documento\n6. Mostrar empleado con el mayor salario neto\n7. Mostrar nomina total\n8. Mostrar resumen de pagos\n9. Salir del programa\n\nSeleccione una opción:";
        int opcion = 0;

        do {
            try {
                String input = JOptionPane.showInputDialog((Component)null, menu, "Menú Principal", 3);
                if (input == null) {
                    break;
                }

                opcion = Integer.parseInt(input);
                switch (opcion) {
                    case 1:
                        agregarEmpleado(1);
                        break;
                    case 2:
                        agregarEmpleado(2);
                        break;
                    case 3:
                        agregarEmpleado(3);
                        break;
                    case 4:
                        JOptionPane.showMessageDialog((Component)null, empresa.obtenerTodosLosEmpleados(), "Lista de Empleados", 1);
                        break;
                    case 5:
                        String doc = JOptionPane.showInputDialog("Ingrese el documento a buscar:");
                        if (doc != null && !doc.trim().isEmpty()) {
                            JOptionPane.showMessageDialog((Component)null, empresa.buscarEmpleado(doc));
                        }
                        break;
                    case 6:
                        JOptionPane.showMessageDialog((Component)null, empresa.EmpleadoMayorSalario(), "Mayor Salario Neto", 1);
                        break;
                    case 7:
                        JOptionPane.showMessageDialog((Component)null, empresa.NominaTotal(), "Nómina Total", 1);
                        break;
                    case 8:
                        JOptionPane.showMessageDialog((Component)null, empresa.ResumenesPago(), "Resúmenes de Pago", 1);
                        break;
                    case 9:
                        JOptionPane.showMessageDialog((Component)null, "Saliendo del sistema...");
                        break;
                    default:
                        JOptionPane.showMessageDialog((Component)null, "Opción no válida.", "Error", 0);
                }
            } catch (NumberFormatException var5) {
                JOptionPane.showMessageDialog((Component)null, "Por favor ingrese un número válido.", "Error de entrada", 0);
            } catch (Exception e) {
                JOptionPane.showMessageDialog((Component)null, "Error: " + e.getMessage(), "Error", 0);
            }
        } while(opcion != 9);

    }

    private static void agregarEmpleado(int tipo) {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre:");
            if (nombre == null) {
                return;
            }

            String documento = JOptionPane.showInputDialog("Documento:");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
            float salarioBase = Float.parseFloat(JOptionPane.showInputDialog("Salario Base:"));
            String[] opcionesCat = new String[]{"JUNIOR", "SEMI_SENIOR", "SENIOR"};
            int catSeleccion = JOptionPane.showOptionDialog((Component)null, "Seleccione la categoría:", "Categoría", -1, 3, (Icon)null, opcionesCat, opcionesCat[0]);
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

            JOptionPane.showMessageDialog((Component)null, "Empleado registrado con éxito.");
        } catch (NumberFormatException var14) {
            JOptionPane.showMessageDialog((Component)null, "Error: Ingrese valores numéricos donde corresponda.", "Error de formato", 0);
        }

    }
}
