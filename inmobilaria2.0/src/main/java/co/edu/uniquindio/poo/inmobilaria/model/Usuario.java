package co.edu.uniquindio.poo.inmobilaria.model;

public abstract class Usuario {
    protected int id;
    protected String nombre;
    protected  String identificacion ;
    protected String telefono;
    protected  String correo;
    protected int puntoreputacion;
    protected String contrasenia;

    public Usuario(int id, String nombre, String identificacion, String contrasenia, String telefono, String correo, int puntoreputacion) {
        this.id = id;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
        this.correo = correo;
        this.puntoreputacion = 0;
    }
    public abstract double calcularbeneficio();
    public void agregarpuntos(int puntos){
        if (puntos>0){
            this.puntoreputacion +=puntos;
        }

    }public String obtenerclasificacion(){
        if(this.puntoreputacion>=0&&this.puntoreputacion<=100){
            return "Principiante";
        }else if(this.puntoreputacion>=101&&this.puntoreputacion<=500){
            return "inversionista";

        }else if(this.puntoreputacion>=501&&this.puntoreputacion<=2000){
            return "experto inmobilario";
        }else if(this.puntoreputacion>2000){
            return "magnate inmobilario";
        }

        return "sinclasificar";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getPuntoreputacion() {
        return puntoreputacion;
    }

    public void setPuntoreputacion(int puntoreputacion) {
        this.puntoreputacion = puntoreputacion;
    }
}
