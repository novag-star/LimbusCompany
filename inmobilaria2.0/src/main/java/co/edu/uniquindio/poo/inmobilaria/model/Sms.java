package co.edu.uniquindio.poo.inmobilaria.model;

public class Sms implements  Alerta{
    private String numerotelefono;

    public Sms(String numerotelefono) {
        this.numerotelefono = numerotelefono;
    }

    public String getNumerotelefono() {
        return numerotelefono;
    }

    public void setNumerotelefono(String numerotelefono) {
        this.numerotelefono = numerotelefono;
    }@Override
    public String alerta(String mensaje,Usuario destinatario){
        String repuesta ="alerta enviada\n"+"desde"+this.numerotelefono+"\n"+"para"+destinatario.getTelefono()+"\n"+"el mensaje fue"+mensaje;
         return repuesta;
    }
}
