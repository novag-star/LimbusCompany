package co.edu.uniquindio.poo.inmobilaria.model;

import java.util.ArrayList;
import java.util.List;

public class Inmobilaria {
    private List<Usuario> listausuario;
    private List<Inmueble> listainmueble;
    private List<Transaccion> listatransaccion;
    private String nombre;
    private Reporte reporte;

    public Inmobilaria(String nombre) {
        this.nombre = nombre;
        this.listainmueble = new ArrayList<>();
        this.listausuario = new ArrayList<>();
        this.listatransaccion = new ArrayList<>();
        this.reporte = new Reporte();
    }

    public boolean registrarusuario(Usuario nuevousuario) {
        if (nuevousuario == null) {
            return false;
        }

        for (int i = 0; i < listausuario.size(); i++) {
            if (listausuario.get(i).getIdentificacion().equals(nuevousuario.getIdentificacion())) {
                return false;
            }
        }
        listausuario.add(nuevousuario);
        return true;
    }

    public boolean actualizarusuario(String identificacion, String nuevotelefono, String nuevocorreo, int nuevareputacion) {
        for (int i = 0; i < listausuario.size(); i++) {
            Usuario usuario = listausuario.get(i);
            if (usuario.getIdentificacion().equals(identificacion)) {
                usuario.setTelefono(nuevotelefono);
                usuario.setCorreo(nuevocorreo);
                usuario.puntoreputacion = nuevareputacion;
                return true;
            }
        }
        return false;
    }

    public boolean eliminarusuario(String identificacion) {
        for (int i = 0; i < listausuario.size(); i++) {
            if (listausuario.get(i).getIdentificacion().equals(identificacion)) {
                listausuario.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Usuario> filtrarCompradores() {
        List<Usuario> compradoresFiltrados = new ArrayList<>();
        for (int i = 0; i < listausuario.size(); i++) {
            Usuario usuario = listausuario.get(i);
            if (usuario instanceof Comprador) {
                compradoresFiltrados.add(usuario);
            }
        }
        return compradoresFiltrados;
    }

    public boolean agregarinmueble(Inmueble nuevoinmueble) {
        if (nuevoinmueble == null) {
            return false;
        }

        for (int i = 0; i < listainmueble.size(); i++) {
            if (listainmueble.get(i).getCodigo().equalsIgnoreCase(nuevoinmueble.getCodigo())) {
                return false;
            }
        }
        listainmueble.add(nuevoinmueble);
        nuevoinmueble.getVendedor().puntoreputacion = nuevoinmueble.getVendedor().puntoreputacion + 10;
        return true;
    }

    public boolean actualizarinmueble(String codigo, double nuevoprecio, Estado nuevoestado) {
        for (int i = 0; i < listainmueble.size(); i++) {
            Inmueble inmueble = listainmueble.get(i);
            if (inmueble.getCodigo().equalsIgnoreCase(codigo)) {
                inmueble.setPrecio(nuevoprecio);
                inmueble.setEstado(nuevoestado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarinmueble(String codigo) {
        for (int i = 0; i < listainmueble.size(); i++) {
            if (listainmueble.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                listainmueble.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean registrartransaccion(Transaccion nuevatransaccion) {
        if (nuevatransaccion == null) {
            return false;
        }
        listatransaccion.add(nuevatransaccion);

        nuevatransaccion.vendedor().puntoreputacion = nuevatransaccion.vendedor().puntoreputacion + 100;
        nuevatransaccion.comprador().puntoreputacion = nuevatransaccion.comprador().puntoreputacion + 50;
        return true;
    }



    public List<Inmueble> reporteInmueblesMasVendidos() {
        return reporte.obtenerInmueblesMasVendidos(listainmueble);
    }

    public List<String> reporteCiudadesMayorDemanda() {
        return reporte.obtenerCiudadesMayorDemanda(listatransaccion);
    }

    public List<Usuario> reporteCompradoresActivos() {
        return reporte.obtenerCompradoresActivos(listausuario);
    }

    public List<Vendedor> reporteVendedoresConMasPropiedades() {
        return reporte.obtenerVendedoresConMasPropiedades(listausuario);
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Usuario> getListausuario() {
        return listausuario;
    }

    public List<Inmueble> getListainmueble() {
        return listainmueble;
    }

    public List<Transaccion> getListatransaccion() {
        return listatransaccion;
    }
}