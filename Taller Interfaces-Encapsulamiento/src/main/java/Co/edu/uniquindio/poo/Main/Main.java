package Co.edu.uniquindio.poo.Main;
import Co.edu.uniquindio.poo.Model.*;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class Main {
    static void main(String[] args) {
        System.out.println("Iniciando Sistema de Peajes del Quindío");
        EmpresaPeaje empresa = new EmpresaPeaje("Peajes del Quindío");

        EstacionPeaje estacion = new EstacionPeaje("Estación Corozal", "Valle del Cauca");
        Recaudador recaudador = new Recaudador("Juan", "Pérez", 100200300, LocalDate.of(1995, 5, 20), 1500000);

        Carro carro = new Carro("1", 2, true, false);
        Moto moto = new Moto("2", 1, 250);

        Camion camionPesado = new Camion("3", 6, 12, 4);
        List<Vehiculo> vehiculosCarlos = new ArrayList<>();
        vehiculosCarlos.add(carro);
        vehiculosCarlos.add(camionPesado);

        Conductor conductor = new Conductor("Carlos", "Gómez", 1055666777, LocalDate.of(1980, 10, 15), vehiculosCarlos);
        System.out.println("\nBuscando camiones con carga > 10 toneladas y > 5 peajes pagados...");
        System.out.println("\nEstructura inicializada correctamente.");
    }
}