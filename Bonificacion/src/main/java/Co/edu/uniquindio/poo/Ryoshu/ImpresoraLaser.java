package Co.edu.uniquindio.poo.Ryoshu;

public class ImpresoraLaser implements Impresora {
    private int id;
    private boolean conectada;

    public ImpresoraLaser(int id) {
        this.id = id;
        this.conectada = false;
    }
    @Override
    public void conectarImpresora() {
        this.conectada = true;
        System.out.println("Láser [" + id + "] CONECTADA.");
    }
    @Override
    public void desconectarImpresora() {
        this.conectada = false;
        System.out.println("Láser [" + id + "] DESCONECTADA.");
    }
    @Override
    public void verEstadoImpresora() {
        System.out.println("Estado Láser [" + id + "]: " + (conectada ? "Lista" : "Apagada"));
    }
    @Override
    public void imprimir(Documento doc) {
        if(conectada) {
            System.out.println("[Láser] Imprimiendo doc de las " + doc.getHoraLlegada() + " -> " + doc.getContenido());
        }
    }
}
