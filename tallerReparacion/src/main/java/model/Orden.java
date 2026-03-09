package model;

import java.util.ArrayList;

public class Orden {

    private String fechaOrden;
    private String codigoOrden;
    private String problemaOrden;
    private String numeroOrden;
    private double costoManoObra;

    private estadoOrden estado;

    private Mecanico mecanico;
    private Bicicleta bicicleta;
    private Cliente cliente;

    private ArrayList<Tarea> listaTareas;
    private ArrayList<Repuesto> listaRepuestos;

    public Orden(String fechaOrden, String codigoOrden, String problemaOrden,
                 String numeroOrden, double costoManoObra,
                 Bicicleta bicicleta, Cliente cliente) {

        this.fechaOrden = fechaOrden;
        this.codigoOrden = codigoOrden;
        this.problemaOrden = problemaOrden;
        this.numeroOrden = numeroOrden;
        this.costoManoObra = costoManoObra;

        this.bicicleta = bicicleta;
        this.cliente = cliente;

        this.estado = estadoOrden.RECIBIDA;

        listaTareas = new ArrayList<>();
        listaRepuestos = new ArrayList<>();
    }

    public void registrarMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public void registrarTarea(Tarea tarea) {
        listaTareas.add(tarea);
    }

    public void registrarRepuesto(Repuesto repuesto) {
        listaRepuestos.add(repuesto);
    }

    public void actualizarOrden(estadoOrden nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public double calcularCosto() {

        double totalRepuestos = 0;

        for (Repuesto r : listaRepuestos) {
            totalRepuestos += r.getCosto() * r.getCantidad();
        }

        return costoManoObra + totalRepuestos;
    }

    public String obtenerDetalles() {

        String detalles = "Numero Orden: " + numeroOrden +
                "\nFecha: " + fechaOrden +
                "\nProblema: " + problemaOrden +
                "\nEstado: " + estado +
                "\nCosto total: " + calcularCosto();

        if (mecanico != null) {
            detalles += "\nMecanico: " + mecanico.obtenerDetalles();
        }

        return detalles;
    }

}