package model;

import java.util.ArrayList;

public class Cliente {

    private String nombreCliente;
    private String codigoCliente;
    private ArrayList<Bicicleta> listaBicicletas;

    public Cliente(String nombreCliente, String codigoCliente) {
        this.nombreCliente = nombreCliente;
        this.codigoCliente = codigoCliente;
        this.listaBicicletas = new ArrayList<>();
    }

    public void registrarBicicleta(String numero) {
        Bicicleta bici = new Bicicleta(numero);
        listaBicicletas.add(bici);
    }

    public String obtenerDetalles() {
        return "Codigo: " + codigoCliente +
                ", Nombre: " + nombreCliente;
    }
    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
}