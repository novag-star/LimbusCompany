package Model;
public class EmpleadoPlantas extends Empleado {

    //atributos

    private String cargo;
    private int horasExtra;
    private float valorHoraExtra;
    private float auxilioTransporte;

    //constructor

    public EmpleadoPlantas(String nombre, String documento, int edad, float salarioBase, CategoriaEmpleado categoria, float descuentoSalud, float descuentoPension, String cargo, int horasExtra, float valorHoraExtra, float auxilioTransporte) {
        super(nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension);

        if (horasExtra < 0) throw new IllegalArgumentException("Las horas extra no pueden ser negativas.");
        if (valorHoraExtra < 0) throw new IllegalArgumentException("El valor de la hora extra no puede ser negativo.");
        this.cargo = cargo;
        this.horasExtra = horasExtra;
        this.valorHoraExtra = valorHoraExtra;
        this.auxilioTransporte = auxilioTransporte;
    }

    @Override
    public float calcularSalarioBruto() {
        float pagoHorasExtra = horasExtra * valorHoraExtra;
        return salarioBase + calcularBonificacionCategoria() + pagoHorasExtra + auxilioTransporte;
    }
}