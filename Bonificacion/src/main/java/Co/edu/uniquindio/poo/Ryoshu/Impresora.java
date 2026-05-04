package Co.edu.uniquindio.poo.Ryoshu;

public interface Impresora {
    void verEstadoImpresora();
    void desconectarImpresora();
    void conectarImpresora();
    void imprimir(Documento doc);

}