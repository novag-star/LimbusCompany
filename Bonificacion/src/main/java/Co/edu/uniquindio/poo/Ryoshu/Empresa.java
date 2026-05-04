package Co.edu.uniquindio.poo.Ryoshu;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombre;
    private List<AreaEmpresa> areas;
    private CentroImpresion centroImpresion;
    public Empresa(String nombre) {
        this.nombre = nombre;
        this.areas = new ArrayList<>();
        this.centroImpresion = new CentroImpresion();
    }
    public AreaEmpresa agregarArea(String nombreArea, int id) {
        AreaEmpresa nuevaArea = new AreaEmpresa(nombreArea, id, centroImpresion);
        areas.add(nuevaArea);
        return nuevaArea;
    }
    public CentroImpresion getCentroImpresion() {
        return centroImpresion;
    }
}