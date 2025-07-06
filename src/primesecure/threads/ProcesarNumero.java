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

        try {
            if (PrimeList.isPrime(numero)) {
                synchronized (listaNumeros) {
                    listaNumeros.add(numero);
                }
                System.out.println(numero + " es primo.");
            } else {
                throw new IllegalArgumentException(numero + " no es un número primo.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
