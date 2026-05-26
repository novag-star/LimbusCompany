package co.edu.uniquindio.poo.inmobilaria.model;

public class Whatsapp  implements Alerta{
    private String numero ;

    public Whatsapp(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }@Override
    public String  alerta(String mensaje,Usuario destinatario){
        String respuesta ="alerta envia\n"+"desde"+this.numero+"\n"+"para"+destinatario.getTelefono()+"\n"+"mensaje"+mensaje;
         return respuesta;
    }
}
