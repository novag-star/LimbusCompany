package Co.edu.uniquindio.poo.Model;

public class CorreoElectronico implements MetodoNotificacion {

    private String email;

    public CorreoElectronico(String email) { this.email = email; }

    @Override
    public EstadoNoticia enviar(String mensaje) {
        System.out.println("Enviando Email a " + email + ": " + mensaje);
        return EstadoNoticia.ENVIADA;
    }
}