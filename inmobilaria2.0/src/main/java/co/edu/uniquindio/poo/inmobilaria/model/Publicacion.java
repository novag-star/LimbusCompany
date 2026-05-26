package co.edu.uniquindio.poo.inmobilaria.model;
import java.time.LocalDateTime;

public class Publicacion {
    private String codigopublicacion;
    private LocalDateTime fechapublicacion;
    private String descripcion;
    private Inmueble inmueble;
    public Publicacion(String codigopublicacion, String descripcion, Inmueble inmueble) {
        this.codigopublicacion = codigopublicacion;
        this.descripcion = descripcion;
        this.inmueble = inmueble;
        this.fechapublicacion=LocalDateTime.now();//
        //validaciones
        if(inmueble==null){
            throw  new IllegalArgumentException("cada publicacion debe estar asosiada a un inmueble");

        }if(descripcion==null){
            throw new IllegalArgumentException("la descripcion no puede estar vacia");
        }
    }

    public String getCodigopublicacion() {
        return codigopublicacion;
    }

    public LocalDateTime getFechapublicacion() {
        return fechapublicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setCodigopublicacion(String codigopublicacion) {
        this.codigopublicacion = codigopublicacion;
    }

    public void setDescripcion(String descripcion) {
        //si la descripcion no exsite y no es igual a un texto
        if(descripcion !=null&&!descripcion.equals("")){
            this.descripcion=descripcion;
        }else{
            throw  new IllegalArgumentException("la descripcion no puede ser null");
        }
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }


}
