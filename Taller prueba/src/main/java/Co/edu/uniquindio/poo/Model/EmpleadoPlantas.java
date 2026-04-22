package Co.edu.uniquindio.poo.Model;

public class EmpleadoPlantas extends Empleado {
    private String cargo;
    private int horasExtra;
    private float valorHoraExtra;
    private float auxilioTransporte;

    public EmpleadoPlantas(String nombre, String documento, int edad, float salarioBase, CategoriaEmpleado categoria, float descuentoSalud, float descuentoPension, String cargo, int horasExtra, float valorHoraExtra, float auxilioTransporte) {
        super(nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension);
        if (horasExtra < 0) {
            throw new IllegalArgumentException("Las horas extra no pueden ser negativas.");
        } else if (valorHoraExtra < 0.0F) {
            throw new IllegalArgumentException("El valor de la hora extra no puede ser negativo.");
        } else {
            this.cargo = cargo;
            this.horasExtra = horasExtra;
            this.valorHoraExtra = valorHoraExtra;
            this.auxilioTransporte = auxilioTransporte;
        }
    }

    public float calcularSalarioBruto() {
        float pagoHorasExtra = (float)this.horasExtra * this.valorHoraExtra;
        return this.salarioBase + this.calcularBonificacionCategoria() + pagoHorasExtra + this.auxilioTransporte;
    }
}
