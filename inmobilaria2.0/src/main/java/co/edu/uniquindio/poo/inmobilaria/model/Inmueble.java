package co.edu.uniquindio.poo.inmobilaria.model;

public class Inmueble {
    private String codigo;
    private TipoInmueble tipoInmueble;
    private String direccion;
    private String ciudad;
    private String area;
    private double precio;
    private Estado estado;
    private Vendedor vendedor;

    public Inmueble(String codigo, TipoInmueble tipoInmueble, String direccion, String ciudad, String area, double precio, Vendedor vendedor) {
        this.codigo = codigo;
        this.tipoInmueble = tipoInmueble;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.area = area;
        this.precio = precio;
        this.vendedor = vendedor;
        this.estado=Estado.DISPONIBLE;
    }

    public String getCodigo() {
        return codigo;
    }

    public TipoInmueble getTipoInmueble() {
        return tipoInmueble;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getArea() {
        return area;
    }

    public String getCiudad() {
        return ciudad;
    }

    public double getPrecio() {
        return precio;
    }

    public Estado getEstado() {
        return estado;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setPrecio(double precio) {
        if (precio > 0) {
            this.precio=precio;
        }else{
           throw new IllegalArgumentException("el precio mayor a cero ");
        }
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTipoInmueble(TipoInmueble tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    @Override
    public String toString() {
        return "Inmueble{" +
                "codigo='" + codigo + '\'' +
                ", tipoInmueble=" + tipoInmueble +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", area='" + area + '\'' +
                ", precio=" + precio +
                ", estado=" + estado +
                ", vendedor=" + vendedor +
                '}';
    }
}
