package Model;
public abstract class Empleado {

    //atributos

    protected String nombre;
    protected String documento;
    protected int edad;
    protected float salarioBase;
    protected CategoriaEmpleado categoria;
    protected float descuentoSalud;
    protected float descuentoPension;

    //constructor

    public Empleado(String nombre, String documento, int edad, float salarioBase, CategoriaEmpleado categoria, float descuentoSalud, float descuentoPension) {
        if (salarioBase < 0) {
            throw new IllegalArgumentException("El salario base no puede ser negativo.");
        }
        if (descuentoSalud < 0 || descuentoSalud > 100 || descuentoPension < 0 || descuentoPension > 100) {
            throw new IllegalArgumentException("Los descuentos deben estar entre 0 y 100.");
        }
        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.salarioBase = salarioBase;
        this.categoria = categoria;
        this.descuentoSalud = descuentoSalud;
        this.descuentoPension = descuentoPension;
    }

    //metodos

    public abstract float calcularSalarioBruto();
    public float calcularBonificacionCategoria() {
        return salarioBase * categoria.getPorcentajeBono();
    }
    public float calcularDescuentos() {
        float salarioBruto = calcularSalarioBruto();
        float calculoSalud = salarioBruto * (descuentoSalud / 100);
        float calculoPension = salarioBruto * (descuentoPension / 100);
        return calculoSalud + calculoPension;
    }
    public float calcularSalarioNeto() {
        return calcularSalarioBruto() - calcularDescuentos();
    }
    public resumenPago generarResumenPago() {
        return new resumenPago(
                documento,
                nombre,
                this.getClass().getSimpleName(),
                calcularSalarioBruto(),
                calcularDescuentos(),
                calcularSalarioNeto()
        );
    }
    public String obtenerInformacion() {
        return "Nombre: " + nombre + " | Documento: " + documento +
                "\nEdad: " + edad + " | Categoría: " + categoria +
                "\nSalario Base: $" + salarioBase + "\n";
    }
    public String getDocumento() {
        return documento;
    }
}