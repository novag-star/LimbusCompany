package Co.edu.uniquindio.poo.Model;
import java.util.*;
import java.util.stream.Collectors;

public class GestorNotificacion {
    private ArrayList<Noticia> listaNoticias;
    private ArrayList<MetodoNotificacion> listaMetodosNotificaciones;

    public GestorNotificacion() {
        this.listaNoticias = new ArrayList<>();
        this.listaMetodosNotificaciones = new ArrayList<>();
    }
    public void agregarNoticia(Noticia n) { listaNoticias.add(n); }
    public void agregarMetodo(MetodoNotificacion m) { listaMetodosNotificaciones.add(m); }

    public List<Noticia> consultarNoticiasPendientesPorKeyword(String keyword) {
        return listaNoticias.stream()
                .filter(n -> n.getEstado() == EstadoNoticia.PENDIENTE)
                .filter(n -> n.getTitulo().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public String obtenerEtiquetaMasUsada() {
        Map<String, Long> conteoEtiquetas = listaNoticias.stream()
                .flatMap(n -> n.getEtiquetas().stream())
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        return conteoEtiquetas.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No hay etiquetas");
    }

    public void enviarNoticiaEnComun(Noticia noticia) {
        for (MetodoNotificacion metodo : listaMetodosNotificaciones) {
            EstadoNoticia resultado = metodo.enviar(noticia.getTitulo());
            noticia.cambiarEstado(resultado);
        }
    }
}