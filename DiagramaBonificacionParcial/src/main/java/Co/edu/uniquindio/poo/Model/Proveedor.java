package Co.edu.uniquindio.poo.Model;

import java.util.ArrayList;
import java.util.List;

public class Proveedor {
    private String nombre;
    // Asociación según diagrama (+listaProductos)
    public List<Producto> listaProductos;

    public Proveedor(String nombre) {
        this.nombre = nombre;
        this.listaProductos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarProducto(Producto p) {
        this.listaProductos.add(p);
    }
}