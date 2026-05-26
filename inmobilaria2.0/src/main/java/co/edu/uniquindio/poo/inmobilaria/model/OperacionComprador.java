package co.edu.uniquindio.poo.inmobilaria.model;

public interface OperacionComprador {
  public  String realizaroferta(Inmueble inmueble,double valoroferta);
    public String comprarinmueble(Inmueble inmueble);
    public String aceptarorechazaroferta(Oferta oferta, boolean aceptar);

}
