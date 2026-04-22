package Co.edu.uniquindio.poo.Model;

public abstract class Empleado {
    protected String nombre;
    protected String documento;
    protected int edad;
    protected float salarioBase;
    protected CategoriaEmpleado categoria;
    protected float descuentoSalud;
    protected float descuentoPension;

    public Empleado(String nombre, String documento, int edad, float salarioBase, CategoriaEmpleado categoria, float descuentoSalud, float descuentoPension) {
        if (salarioBase < 0.0F) {
            throw new IllegalArgumentException("El salario base no puede ser negativo.");
        } else if (!(descuentoSalud < 0.0F) && !(descuentoSalud > 100.0F) && !(descuentoPension < 0.0F) && !(descuentoPension > 100.0F)) {
            this.nombre = nombre;
            this.documento = documento;
            this.edad = edad;
            this.salarioBase = salarioBase;
            this.categoria = categoria;
            this.descuentoSalud = descuentoSalud;
            this.descuentoPension = descuentoPension;
        } else {
            throw new IllegalArgumentException("Los descuentos deben estar entre 0 y 100.");
        }
    }

    public abstract float calcularSalarioBruto();

    public float calcularBonificacionCategoria() {
        return this.salarioBase * this.categoria.getPorcentajeBono();
    }

    public float calcularDescuentos() {
        float salarioBruto = this.calcularSalarioBruto();
        float calculoSalud = salarioBruto * (this.descuentoSalud / 100.0F);
        float calculoPension = salarioBruto * (this.descuentoPension / 100.0F);
        return calculoSalud + calculoPension;
    }

    public float calcularSalarioNeto() {
        return this.calcularSalarioBruto() - this.calcularDescuentos();
    }

    public ResumenPago generarResumenPago() {
        return new ResumenPago(this.documento, this.nombre, this.getClass().getSimpleName(), this.calcularSalarioBruto(), this.calcularDescuentos(), this.calcularSalarioNeto());
    }

    public String obtenerInformacion() {
        String var10000 = this.nombre;
        return "Nombre: " + var10000 + " | Documento: " + this.documento + "\nEdad: " + this.edad + " | Categoría: " + String.valueOf(this.categoria) + "\nSalario Base: $" + this.salarioBase + "\n";
    }

    public String getDocumento() {
        return this.documento;
    }
}
