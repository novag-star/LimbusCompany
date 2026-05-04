package Co.edu.uniquindio.poo.Ryoshu;
import java.util.PriorityQueue;
import java.util.Queue;


public class CentroImpresion {
    private Queue<Documento> colaDocumentos;
    private Impresora impresoraConectada;

    public CentroImpresion() {
        this.colaDocumentos = new PriorityQueue<>();
    }
    public void recibirDocumento(Documento doc) {
        colaDocumentos.add(doc);
        System.out.println(" Documento recibido. Total en espera: " + colaDocumentos.size());
    }
    public void elegirImpresora(Impresora nuevaImpresora) {
        if (this.impresoraConectada != null) {
            this.impresoraConectada.desconectarImpresora();
        }
        this.impresoraConectada = nuevaImpresora;
        this.impresoraConectada.conectarImpresora();
    }
    public void organizarOrdenLlegada() {
        if (impresoraConectada == null) {
            System.out.println("No hay impresora conectada.");
            return;
        }
        System.out.println("\nIniciando impresión en orden de llegada");

        while (!colaDocumentos.isEmpty()) {
            Documento doc = colaDocumentos.poll();
            impresoraConectada.imprimir(doc);
        }
        System.out.println("Bandeja vacía\n");
    }
}