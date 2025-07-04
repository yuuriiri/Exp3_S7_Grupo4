package primesecure.main;

import java.util.Scanner;
import primesecure.model.PrimeList;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    static String[] opcionesMenu = {
        "------------------------",
        "1) App",
        "2) Mostrar numeros primos",
        "3) Salir",
        "------------------------",};

    public static void main(String[] args) {
        Main app = new Main();
        app.ejecutarMenu();
    }

    public void ejecutarMenu() {
        int opcionMenu = -1;
        System.out.println("..::: ¡Bienvenido a PrimeSecure! :::..");
        do {
            mostrarMenu();
            if (scanner.hasNextInt()) {
                opcionMenu = scanner.nextInt();
                scanner.nextLine();
                switch (opcionMenu) {
                    case 1 ->
                        System.out.println("");
                    case 2 ->
                        System.out.println("====== MOSTRAR NUMEROS PRIMOS ======");
                    case 3 ->
                        System.out.println("Saliendo del sistema...");
                    default ->
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } else {
                System.out.println("Entrada no válida. Ingrese un número.");
                scanner.nextLine(); 
            }
        } while (opcionMenu != 3);
    }

    public void mostrarMenu() {
        System.out.println("\n====== MENU PRINCIPAL ======");
        for (String opcionesMenu1 : opcionesMenu) {
            System.out.println(opcionesMenu1);
        }
        System.out.println("Seleccione una opción: ");
    }
}

