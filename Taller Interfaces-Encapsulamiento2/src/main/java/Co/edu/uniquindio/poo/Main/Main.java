package Co.edu.uniquindio.poo.Main;
import Co.edu.uniquindio.poo.Model.*;
public class Main {
    public static void main(String[] args) {
        Universidad uniquindio = new Universidad("Universidad del Quindío");
        GestorNotificacion gestor = uniquindio.getGestor();


        gestor.agregarMetodo(new CorreoElectronico("estudiantes@uniquindio.edu.co"));
        gestor.agregarMetodo(new Sms("3000000000"));
        gestor.agregarMetodo(new Push("DISP-998877"));


        Noticia noticiaPrincipal = new Noticia(
                "Cierre de Campus por Elecciones",
                "El campus estará cerrado el día viernes.",
                EstadoNoticia.PENDIENTE
        );
        noticiaPrincipal.agregarEtiqueta("Informativo");
        noticiaPrincipal.agregarEtiqueta("Urgente");

        gestor.agregarNoticia(noticiaPrincipal);


        System.out.println("Iniciando sistema de notificaciones de la Universidad...");
        gestor.enviarNoticiaEnComun(noticiaPrincipal);

        System.out.println("Ejecución finalizada. Estado actual de la noticia: "
                + noticiaPrincipal.getEstado());
    }
}