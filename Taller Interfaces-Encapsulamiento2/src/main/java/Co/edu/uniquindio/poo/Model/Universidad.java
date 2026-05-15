package Co.edu.uniquindio.poo.Model;

public class Universidad {
    private String nombre;
    private GestorNotificacion gestorNotificacion;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.gestorNotificacion = new GestorNotificacion();
    }

    public GestorNotificacion getGestor() {
        return gestorNotificacion;
    }
}