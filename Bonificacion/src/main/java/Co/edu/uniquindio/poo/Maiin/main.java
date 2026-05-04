package Co.edu.uniquindio.poo.Maiin;
import Co.edu.uniquindio.poo.Ryoshu.*;

import java.time.LocalTime;

public class main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("Tech Solutions");
        CentroImpresion centro = empresa.getCentroImpresion();
        AreaEmpresa diseño = empresa.agregarArea("Diseño", 1);
        AreaEmpresa ventas = empresa.agregarArea("Ventas", 2);
        Impresora laser = new ImpresoraLaser(100);
        Impresora cartucho = new ImpresoraCartucho(200);
        Impresora impresora3d = new Impresora3D(300);
        Documento doc1 = ventas.generarDocumentoPrueba(LocalTime.of(15, 30), "Catálogo de productos");
        Documento doc2 = diseño.generarDocumentoPrueba(LocalTime.of(8, 00), "Boceto inicial");
        Documento doc3 = diseño.generarDocumentoPrueba(LocalTime.of(10, 15), "Planos en CAD");
        ventas.solicitarImpresion(doc1);
        diseño.solicitarImpresion(doc2);
        diseño.solicitarImpresion(doc3);
        System.out.println("-");
        centro.elegirImpresora(laser);
        centro.organizarOrdenLlegada();
        System.out.println("-");
        Documento pieza3D = diseño.generarDocumentoPrueba(LocalTime.of(16, 00), "Modelo 3D de Engranaje");
        diseño.solicitarImpresion(pieza3D);
        centro.elegirImpresora(impresora3d);
        centro.organizarOrdenLlegada();
    }
}