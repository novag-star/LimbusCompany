package co.edu.uniquindio.poo.inmobilaria.model;

public class Correo implements  Alerta {
    private String correoreminente;

    public Correo(String correoreminente) {
        this.correoreminente = correoreminente;
    }
    @Override
    public String alerta(String mensaje ,Usuario destinatario){
       String respueta="notificacion correo \n"+"para "+destinatario+"\n"+"mensaje"+mensaje+"\n";
       return respueta;
    }

    public String getCorreoreminente() {
        return correoreminente;
    }

    public void setCorreoreminente(String correoreminente) {
        this.correoreminente = correoreminente;
    }
}
