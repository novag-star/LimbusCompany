package Co.edu.uniquindio.poo.Ryoshu;

public class Impresora3D implements Impresora {
    private int id;
    private boolean conectada;

    public Impresora3D(int id) {
        this.id = id;
        this.conectada = false;
    }
    @Override
    public void conectarImpresora() {
        this.conectada = true;
        System.out.println("Impresora 3D [" + id + "] CONECTADA.");
    }
    @Override
    public void desconectarImpresora() {
        this.conectada = false;
        System.out.println("Impresora 3D [" + id + "] DESCONECTADA.");
    }
    @Override
    public void verEstadoImpresora() {
        System.out.println("Estado 3D [" + id + "]: " + (conectada ? "Lista" : "Apagada"));
    }
    @Override
    public void imprimir(Documento doc) {
        if(conectada) {
            System.out.println("[3D] Modelando diseño de las " + doc.getHoraLlegada() + " -> Archivo: " + doc.getContenido());
        }
    }
}