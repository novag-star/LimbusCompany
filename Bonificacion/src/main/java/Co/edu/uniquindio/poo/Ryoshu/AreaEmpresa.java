package Co.edu.uniquindio.poo.Ryoshu;

import java.time.LocalDate;
import java.time.LocalTime;

public class AreaEmpresa {
    private String nombre;
    private int id;
    private CentroImpresion centroAsignado;

    public AreaEmpresa(String nombre, int id, CentroImpresion centro) {
        this.nombre = nombre;
        this.id = id;
        this.centroAsignado = centro;
    }
    public Documento generarDocumentoPrueba(LocalTime hora, String contenido) {
        return new Documento(LocalDate.now(), hora, contenido);
    }
    public void solicitarImpresion(Documento doc) {
        centroAsignado.recibirDocumento(doc);
    }
}