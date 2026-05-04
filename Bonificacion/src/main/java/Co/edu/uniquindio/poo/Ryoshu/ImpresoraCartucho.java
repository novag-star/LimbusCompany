package Co.edu.uniquindio.poo.Ryoshu;

public class ImpresoraCartucho implements Impresora {
    private int id;
    private boolean conectada;

    public ImpresoraCartucho(int id) {
        this.id = id;
        this.conectada = false;
    }
    @Override
    public void conectarImpresora() {
        this.conectada = true;
        System.out.println("Cartucho [" + id + "] CONECTADA.");
    }
    @Override
    public void desconectarImpresora() {
        this.conectada = false;
        System.out.println("Cartucho [" + id + "] DESCONECTADA.");
    }
    @Override
    public void verEstadoImpresora() {
        System.out.println("Estado Cartucho [" + id + "]: " + (conectada ? "Lista" : "Apagada"));
    }
    @Override
    public void imprimir(Documento doc) {
        if(conectada) {
            System.out.println("[Cartucho] Imprimiendo doc de las " + doc.getHoraLlegada() + " -> " + doc.getContenido());
        }
    }
}