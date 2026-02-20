package pt.estga.ti.rmi.utils;

public class MathUtils {

    public static long factorial(int n){
        if(n < 0) throw new IllegalArgumentException("Negative number is not possible");

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static boolean isPrime(int n){
        if(n <= 1) return false;
        if (n == 2) return true;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    public static int maxPrimeBoolean(int a, int b){
        int max = -1;
        for (int i = Math.min(a,b); i <= Math.max(a,b); i++) {
            if(isPrime(i)){
                max = i;
            }
        }
        return max;
    }

    public static int minPrimeBoolean(int a, int b){
        for (int i = Math.min(a,b); i <= Math.max(a,b); i++) {
            if(isPrime(i)){
                return i;
            }
        }
        return -1;
    }
}
