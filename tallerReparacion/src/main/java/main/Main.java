package main;

import model.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String nombreTaller = JOptionPane.showInputDialog("Nombre del taller:");
        String direccionTaller = JOptionPane.showInputDialog("Dirección del taller:");

        Taller taller = new Taller(nombreTaller, direccionTaller);

        ArrayList<Orden> ordenes = new ArrayList<>();

        int opcion = 0;

        while (opcion != 8) {

            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "MENU TALLER\n\n" +
                            "1. Crear cliente\n" +
                            "2. Ver clientes\n" +
                            "3. Actualizar cliente\n" +
                            "4. Eliminar cliente\n" +
                            "5. Registrar bicicleta\n" +
                            "6. Crear orden\n" +
                            "7. Ver ordenes\n" +
                            "8. Salir"
            ));

            switch (opcion) {

                case 1:

                    String nombreCliente = JOptionPane.showInputDialog("Nombre del cliente:");
                    String codigoCliente = JOptionPane.showInputDialog("Código del cliente:");

                    Cliente cliente = new Cliente(nombreCliente, codigoCliente);

                    taller.registrarCliente(cliente);

                    JOptionPane.showMessageDialog(null, "Cliente registrado");

                    break;

                case 2:

                    JOptionPane.showMessageDialog(null, taller.mostrarClientes());

                    break;

                case 3:

                    String codigoActualizar = JOptionPane.showInputDialog("Código del cliente:");
                    String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:");

                    taller.actualizarCliente(codigoActualizar, nuevoNombre);

                    JOptionPane.showMessageDialog(null, "Cliente actualizado");

                    break;

                case 4:

                    String codigoEliminar = JOptionPane.showInputDialog("Código del cliente a eliminar");

                    taller.eliminarCliente(codigoEliminar);

                    JOptionPane.showMessageDialog(null, "Cliente eliminado");

                    break;

                case 5:

                    String codigoClienteBici = JOptionPane.showInputDialog("Código del cliente:");
                    Cliente clienteBici = taller.buscarCliente(codigoClienteBici);

                    if (clienteBici != null) {

                        String numeroBicicleta = JOptionPane.showInputDialog("Número de bicicleta:");

                        clienteBici.registrarBicicleta(numeroBicicleta);

                        JOptionPane.showMessageDialog(null, "Bicicleta registrada");

                    } else {

                        JOptionPane.showMessageDialog(null, "Cliente no encontrado");

                    }

                    break;

                case 6:

                    String codigoClienteOrden = JOptionPane.showInputDialog("Código del cliente:");
                    Cliente clienteOrden = taller.buscarCliente(codigoClienteOrden);

                    if (clienteOrden != null) {

                        String numeroBici = JOptionPane.showInputDialog("Número de bicicleta:");
                        Bicicleta bicicleta = new Bicicleta(numeroBici);

                        String fecha = JOptionPane.showInputDialog("Fecha de la orden:");
                        String codigoOrden = JOptionPane.showInputDialog("Código de la orden:");
                        String problema = JOptionPane.showInputDialog("Problema:");
                        String numeroOrden = JOptionPane.showInputDialog("Número de orden:");

                        double costoManoObra = Double.parseDouble(
                                JOptionPane.showInputDialog("Costo de mano de obra")
                        );

                        Orden orden = new Orden(fecha, codigoOrden, problema, numeroOrden,
                                costoManoObra, bicicleta, clienteOrden);

                        ordenes.add(orden);

                        JOptionPane.showMessageDialog(null, "Orden creada");

                    } else {

                        JOptionPane.showMessageDialog(null, "Cliente no encontrado");

                    }

                    break;

                case 7:

                    String listaOrdenes = "";

                    for (Orden o : ordenes) {
                        listaOrdenes += o.obtenerDetalles() + "\n\n";
                    }

                    JOptionPane.showMessageDialog(null, listaOrdenes);

                    break;

                case 8:

                    JOptionPane.showMessageDialog(null, "Programa finalizado");

                    break;

                default:

                    JOptionPane.showMessageDialog(null, "Opción inválida");

            }

        }

    }

}