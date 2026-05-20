package Co.edu.uniquindio.poo.Model;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombre;
    // Asociación según diagrama (+listaProveedores)
    public List<Proveedor> listaProveedores;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.listaProveedores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarProveedor(Proveedor p) {
        this.listaProveedores.add(p);
    }
}