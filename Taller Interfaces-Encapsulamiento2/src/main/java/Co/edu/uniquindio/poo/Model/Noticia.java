package Co.edu.uniquindio.poo.Model;
import java.util.ArrayList;

public class Noticia {
    private String titulo;
    private String descripcion;
    private EstadoNoticia estado;
    private ArrayList<String> etiquetas; // En el UML aparece como etiqueta : ArrayList

    public Noticia(String titulo, String descripcion, EstadoNoticia estado) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.etiquetas = new ArrayList<>();
    }

    public void cambiarEstado(EstadoNoticia nuevoEstado) {
        this.estado = nuevoEstado;
    }

    // Getters necesarios para la lógica de búsqueda
    public String getTitulo() { return titulo; }
    public EstadoNoticia getEstado() { return estado; }
    public ArrayList<String> getEtiquetas() { return etiquetas; }
    public void agregarEtiqueta(String etiqueta) { this.etiquetas.add(etiqueta); }
}