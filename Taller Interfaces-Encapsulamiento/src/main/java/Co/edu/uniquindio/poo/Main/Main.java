package Co.edu.uniquindio.poo.Main;
import java.util.List;
import Co.edu.uniquindio.poo.Model.*;
public class Main {
    public static void main(String[] args) {
        ejecutarPruebaCalculoPeaje();
        System.out.println("-");
        ejecutarPruebaObtenerCamiones();
    }

    public static void ejecutarPruebaCalculoPeaje() {

        Carro cp01 = new Carro("AAA111", 0, false, false);
        Carro cp02 = new Carro("BBB222", 0, true, true);
        Moto cp03 = new Moto("CCC333", 0, 150);
        Moto cp04 = new Moto("DDD444", 0, 250);
        Camion cp05 = new Camion("EEE555", 0, 8, 2);
        Camion cp06 = new Camion("FFF666", 0, 12, 3);

        System.out.println("CP-01 (Carro Normal) Esperado $10000 -> Obtenido: $" + cp01.calcularPeaje());
        System.out.println("CP-02 (Carro Elec+Pub) Esperado $9500 -> Obtenido: $" + cp02.calcularPeaje());
        System.out.println("CP-03 (Moto 150cc) Esperado $5000 -> Obtenido: $" + cp03.calcularPeaje());
        System.out.println("CP-04 (Moto 250cc) Esperado $7000 -> Obtenido: $" + cp04.calcularPeaje());
        System.out.println("CP-05 (Camión 8T, 2E) Esperado $14000 -> Obtenido: $" + cp05.calcularPeaje());
        System.out.println("CP-06 (Camión 12T, 3E) Esperado $23100 -> Obtenido: $" + cp06.calcularPeaje());
    }

    public static void ejecutarPruebaObtenerCamiones() {

        EmpresaPeaje empresa = new EmpresaPeaje("Peajes del Quindío");

        Camion oc01 = new Camion("CAM-001", 6, 12, 3);
        Camion oc02 = new Camion("CAM-002", 6, 8, 2);
        Camion oc03 = new Camion("CAM-003", 3, 15, 4);
        Carro oc04 = new Carro("CAR-004", 10, false, false);

        empresa.agregarVehiculo(oc01);
        empresa.agregarVehiculo(oc02);
        empresa.agregarVehiculo(oc03);
        empresa.agregarVehiculo(oc04);

        List<Camion> resultado = empresa.obtenerCamionesEspecificos();

        System.out.println("Cantidad de camiones filtrados (Esperado: 1) -> Obtenido: " + resultado.size());
        if (!resultado.isEmpty()) {
            System.out.println("Placa del camión filtrado (Esperado: CAM-001) -> Obtenido: " + resultado.get(0).getPlaca());
        }
    }
}