package co.edu.uniquindio.poo.inmobilaria.model;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record Transaccion(String codigotransaccion, Comprador comprador, Vendedor vendedor , Inmueble inmueble,double valorfinal, TipoOperacion tipooperacion,
                          LocalDateTime fechatransaccion) {
    public Transaccion{
        if (valorfinal<=0){
            throw new IllegalArgumentException("el valor de la transaccion mayor a cero ");
        }
        if(inmueble==null||comprador==null||vendedor==null){
            throw new IllegalArgumentException("los involucrado o el inmuble no puede ser nulo ");
        }
    }
}
