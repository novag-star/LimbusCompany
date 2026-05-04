package Co.edu.uniquindio.poo.Ryoshu;

import java.time.LocalDate;
import java.time.LocalTime;

public class Documento implements Comparable<Documento> {
    private LocalDate fecha;
    private LocalTime horaLlegada;
    private String contenido;
    public Documento(LocalDate fecha, LocalTime horaLlegada, String contenido) {
        this.fecha = fecha;
        this.horaLlegada = horaLlegada;
        this.contenido = contenido;
    }
    public LocalTime getHoraLlegada() { return horaLlegada; }
    public String getContenido() { return contenido; }
    @Override
    public int compareTo(Documento otro) {
        int comparacionFecha = this.fecha.compareTo(otro.fecha);
        if (comparacionFecha == 0) {
            return this.horaLlegada.compareTo(otro.horaLlegada);
        }
        return comparacionFecha;
    }
}