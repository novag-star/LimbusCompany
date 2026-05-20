package Co.edu.uniquindio.poo.Model;

public class MedicamentoFarmologico implements Refrigerable {
    private String codigo;
    private String nombre;

    public MedicamentoFarmologico(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    @Override
    public void iniciarRefrigeracion() {
        System.out.println("Iniciando refrigeración del medicamento farmacológico: "
                + nombre);
    }
}