package Co.edu.uniquindio.poo.Model;

public enum CategoriaEmpleado {
    JUNIOR(0.05F),
    SEMI_SENIOR(0.1F),
    SENIOR(0.15F);

    private final float porcentajeBono;

    private CategoriaEmpleado(float porcentajeBono) {
        this.porcentajeBono = porcentajeBono;
    }

    public float getPorcentajeBono() {
        return this.porcentajeBono;
    }
}
