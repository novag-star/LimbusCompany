package model;

import java.util.ArrayList;

public class Taller {

    private String nombre;
    private String direccion;
    private ArrayList<Cliente> clientes;

    public Taller(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        clientes = new ArrayList<>();
    }

    // CREATE
    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    // READ
    public String mostrarClientes() {

        String lista = "";

        for (Cliente c : clientes) {
            lista += c.obtenerDetalles() + "\n";
        }

        return lista;
    }

    // UPDATE
    public void actualizarCliente(String codigo, String nuevoNombre) {

        for (Cliente c : clientes) {

            if (c.getCodigoCliente().equals(codigo)) {
                c.setNombreCliente(nuevoNombre);
            }

        }

    }

    // DELETE
    public void eliminarCliente(String codigo) {

        for (int i = 0; i < clientes.size(); i++) {

            if (clientes.get(i).getCodigoCliente().equals(codigo)) {
                clientes.remove(i);
                break;
            }

        }

    }
    public Cliente buscarCliente(String codigo){

        for(Cliente c : clientes){

            if(c.getCodigoCliente().equals(codigo)){
                return c;
            }

        }

        return null;
    }

}