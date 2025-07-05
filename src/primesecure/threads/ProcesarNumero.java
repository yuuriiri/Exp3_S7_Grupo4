package primesecure.threads;

import primesecure.model.PrimeList;

public class ProcesarNumero extends Thread {

    private final int numero;
    private final PrimeList listaNumeros;

    public ProcesarNumero(int numero, PrimeList listaNumeros) {
        this.numero = numero;
        this.listaNumeros = listaNumeros;
    }

    @Override
    public void run() {

        if (PrimeList.isPrime(numero)) {
            synchronized (listaNumeros) {
                listaNumeros.add(numero);
            }
            System.out.println(numero + " es primo.");
        } else {
            System.out.println(numero + " no es primo.");
        }
    }

}