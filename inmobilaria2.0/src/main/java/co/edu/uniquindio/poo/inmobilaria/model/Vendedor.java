package co.edu.uniquindio.poo.inmobilaria.model;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Usuario implements  OperacionVendedor{
   private int cantidadpropiedad;
    private List<Inmueble>listainmueble;
    public Vendedor(int id, String nombre, String identificacion, String contrasenia, String telefono, String correo, int puntoreputacion) {

        super(id, nombre, identificacion, contrasenia, telefono, correo, puntoreputacion);
        this.cantidadpropiedad=0;
        this.listainmueble=new ArrayList<>();

    }
    public String registrarinmueble(Inmueble inmueble){
        String respuesta="";
        if(inmueble!=null){
            this.listainmueble.add(inmueble);
            this.cantidadpropiedad=this.cantidadpropiedad+1;
           respuesta="exitp inmueble"+inmueble.getCodigo()+"\n"+"agregador a ala lista vendedor"+this.cantidadpropiedad;
        }
        return respuesta;
    }
    @Override

    public String  publicarinmueble(Inmueble inmueble){
        String respuesta="";
        if(inmueble!=null){
            inmueble.setEstado(Estado.DISPONIBLE);
            respuesta="EXITO codigo"+inmueble.getCodigo()+"ha publicado exitosamente";
        }
        return  respuesta;
    }
    @Override
    public double calcularbeneficio(){
        double beneficiototal=0.0;
        for(int i =0;i<listainmueble.size();i++){
            Inmueble temporar =listainmueble.get(i);

            if(temporar.getEstado()==Estado.VENDIDO){
                beneficiototal=beneficiototal+temporar.getPrecio();
            }
        }
        return beneficiototal;
    }
    @Override
    public String generarreporte(){
        String reporte="reporte\n"+"id"+id+"\n"+"vendedor"+nombre+"\n"+"propiedad a cargo"+cantidadpropiedad+"\n"+"beneficio"+calcularbeneficio();

   return reporte ;
    }

    public int getCantidadpropiedad() {
        return cantidadpropiedad;
    }

    public List<Inmueble> getListainmueble() {
        return listainmueble;
    }

    public void setCantidadpropiedad(int cantidadpropiedad) {
        this.cantidadpropiedad = cantidadpropiedad;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "cantidadpropiedad=" + cantidadpropiedad +
                ", listainmueble=" + listainmueble +
                '}';
    }

    public void setListainmueble(List<Inmueble> listainmueble) {
       this.listainmueble=listainmueble;
       if(listainmueble!=null){
           this.cantidadpropiedad=listainmueble.size();
       }else{
           this.cantidadpropiedad=0;
       }

    }
}
