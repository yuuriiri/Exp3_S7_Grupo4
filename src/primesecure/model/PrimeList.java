package primesecure.model;

import java.util.ArrayList;

public class PrimeList extends ArrayList<Integer> {
    
    @Override
    public synchronized boolean add(Integer n) {
        if (!isPrime(n)) {
            System.out.println(n + "No es primo.");
        } 
        return super.add(n);
    }
    
    @Override
    public synchronized Integer remove(int index) {
        return super.remove(index);   
    }

    public synchronized int getPrimeCount() {
        return this.size();
    }
    
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
