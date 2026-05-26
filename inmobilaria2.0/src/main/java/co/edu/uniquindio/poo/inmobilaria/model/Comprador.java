package co.edu.uniquindio.poo.inmobilaria.model;

import java.util.List;

public class Comprador extends Usuario implements  OperacionComprador{
    private String preferenciabusqueda;

    public Comprador(int id, String nombre, String identificacion, String contrasenia, String telefono, String correo, int puntoreputacion, String preferenciabusqueda){

        super(id, nombre, identificacion, contrasenia, telefono, correo, puntoreputacion);
        this.preferenciabusqueda = preferenciabusqueda;
    }
    public String buscarpropiedad(List<Inmueble> listainmuebles){
        String resultado="resultado de busqueda"+preferenciabusqueda.toUpperCase();
        int coincidencia=0;
        for(int i=0;i<listainmuebles.size();i++){
            Inmueble temporal=listainmuebles.get(i);
            if(temporal.getTipoInmueble().name().equalsIgnoreCase(preferenciabusqueda)){
                resultado= resultado+"codigo"+temporal.getCodigo()+"precio"+temporal.getPrecio()+"\n";
                coincidencia=coincidencia+1;
            }
        }resultado =resultado+"total coincidencias"+coincidencia;
        return resultado;
    }@Override
    public double calcularbeneficio(){
        return 0.0;
    }

    public String getPreferenciabusqueda() {
        return preferenciabusqueda;
    }

    public void setPreferenciabusqueda(String preferenciabusqueda) {
        this.preferenciabusqueda = preferenciabusqueda;
    }

    @Override
    public String toString() {
        return "Comprador{" +
                "preferenciabusqueda='" + preferenciabusqueda + '\'' +
                '}';
    }
    @Override
    public String  realizaroferta(Inmueble inmueble,double valoroferta){
        String respuesta;
        if(inmueble==null||valoroferta <=0){
            respuesta="los datos de la oferta no son validos";


        }else{
            this.puntoreputacion = this.puntoreputacion + 5;
            respuesta="alerta enviada\n"+" el comprador "+this.nombre+"\n"+"ha hecho una oferta de "+valoroferta+"\n"+"codigo"+inmueble.getCodigo();
        }
        return respuesta;

    }
    @Override
    public String comprarinmueble(Inmueble inmueble){
        String repuesta;
        if(inmueble==null){
            repuesta="el inmueble no es valido";
        }else{
            repuesta="proceso de compra generado\n"+"comprador"+this.nombre+"\n"+"inmueble aquiridado"+inmueble.getCodigo()+"\n"+"ubicacion"+inmueble.getCiudad();
        }
        return repuesta;
    }
    @Override
    public String aceptarorechazaroferta(Oferta oferta, boolean aceptar){
       String respuesta;
        if(oferta ==null){
            respuesta="la oferta esta vacia";


        }else{
            String estadofinal;
            if(aceptar){
                estadofinal="ACEPTATDA oferta";
            }else{
                estadofinal="RECHAZADA oferta";
            }
            respuesta="desicion de la oferta registrada\n"+"el comprador decidio"+estadofinal;
        }
            return respuesta;
    }
}
