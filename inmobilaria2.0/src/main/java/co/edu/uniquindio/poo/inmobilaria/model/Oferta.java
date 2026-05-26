package co.edu.uniquindio.poo.inmobilaria.model;

import java.time.LocalDateTime;

public class Oferta {
    private String codigooferta;
    private Comprador comprador;
    private Inmueble inmueble;
    private double valoroferta;
    private LocalDateTime fechaoferta;
    private EstadoOferta estado;

    public Oferta(String codigooferta, Comprador comprador, Inmueble inmueble, double valoroferta) {

        if (valoroferta < 0) {
            throw new IllegalArgumentException("El valor de la oferta debe ser mayor a cero");
        }

        this.codigooferta = codigooferta;
        this.comprador = comprador;
        this.inmueble = inmueble;
        this.valoroferta = valoroferta;
        this.fechaoferta = LocalDateTime.now();
        this.estado = EstadoOferta.PENDIENTE;
    }

    public void rechazaroferta() {
        this.estado = EstadoOferta.RECHAZADA;
    }

    public void aceptaroferta() {
        this.estado = EstadoOferta.ACEPTADA;
    }


    public String getCodigooferta() {
        return codigooferta;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public double getValoroferta() {
        return valoroferta;
    }

    public LocalDateTime getFechaoferta() {
        return fechaoferta;
    }

    public EstadoOferta getEstado() {
        return estado;
    }

    public void setCodigooferta(String codigooferta) {
        this.codigooferta = codigooferta;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public void setValoroferta(double valoroferta) {
        if (valoroferta < 0) {
            throw new IllegalArgumentException("El valor debe ser mayor a cero");
        }

        this.valoroferta = valoroferta;
    }

    public void setEstado(EstadoOferta estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Oferta{" +
                "codigooferta='" + codigooferta + '\'' +
                ", comprador=" + comprador +
                ", inmueble=" + inmueble +
                ", valoroferta=" + valoroferta +
                ", fechaoferta=" + fechaoferta +
                ", estado=" + estado +
                '}';
    }
}