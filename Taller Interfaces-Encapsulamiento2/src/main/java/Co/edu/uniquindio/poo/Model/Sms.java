package Co.edu.uniquindio.poo.Model;

public class Sms implements MetodoNotificacion {
    private String numeroTelefono;

    public Sms(String numeroTelefono) { this.numeroTelefono = numeroTelefono; }

    @Override
    public EstadoNoticia enviar(String mensaje) {
        System.out.println("Enviando SMS al " + numeroTelefono + ": " + mensaje);
        return EstadoNoticia.ENVIADA;
    }
}