package Co.edu.uniquindio.poo.Model;

public class Push implements MetodoNotificacion {
    private String idDispositivo;

    public Push(String idDispositivo) { this.idDispositivo = idDispositivo; }

    @Override
    public EstadoNoticia enviar(String mensaje) {
        System.out.println("Enviando Push ID " + idDispositivo + ": " + mensaje);
        return EstadoNoticia.ENVIADA;
    }
}