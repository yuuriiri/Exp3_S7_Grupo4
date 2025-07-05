package primesecure.main;

import java.util.ArrayList;
import java.util.Scanner;
import primesecure.model.PrimeList;
import primesecure.threads.ProcesarNumero;

public class Main {

    public static void main(String[] args) {
        Main app = new Main();
        app.programa();
    }

    private final Scanner sc = new Scanner(System.in);
    private final PrimeList lista = new PrimeList();
    private final ArrayList<Thread> hilos = new ArrayList<>();

    public void programa() {

        System.out.println("Ingrese un número (0 para salir y imprimir lista de numeros primos): ");

        while (true) {
            System.out.print("Numero: ");
            int opcion = sc.nextInt();

            if (opcion == 0) {
                break;
            }

            ProcesarNumero hilo = new ProcesarNumero(opcion, lista);
            hilo.start(); // Inicia el thread 
            hilos.add(hilo);
        }

        System.out.println("Esperando..");

        for (Thread hilo : hilos) {
            try {
                hilo.join(); // Espera real
            } catch (InterruptedException e) {
                System.out.println("Error esperando un hilo.");
            }
        }

        System.out.println("=== LISTA NUMEROS PRIMOS ===");

        if (lista.isEmpty()) {
            System.out.println("No se encontraron primos.");
        } else {
            for (int primos : lista) {
                System.out.println("> " + primos);
            }
        }
    }
}
