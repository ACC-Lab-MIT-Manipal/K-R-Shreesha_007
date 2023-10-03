import java.util.Random;
import java.util.Scanner;

public class MillerRabin{

    // Miller-Rabin primality test
    public static boolean isPrime(long n, int k) {
        if (n <= 1 || n == 4) {
            return false;
        }
        if (n <= 3) {
            return true;
        }

        // Find d such that n-1 = 2^r * d
        long d = n - 1;
        while (d % 2 == 0) {
            d /= 2;
        }

        // Witness loop
        for (int i = 0; i < k; i++) {
            if (!witness(n, d)) {
                return false;
            }
        }

        return true;
    }

    // Helper function to perform the Miller-Rabin test
    private static boolean witness(long n, long d) {
        Random rand = new Random();
        long a = 2 + rand.nextLong() % (n - 4);
        long x = power(a, d, n);

        if (x == 1 || x == n - 1) {
            return true;
        }

        while (d != n - 1) {
            x = (x * x) % n;
            d *= 2;

            if (x == 1) {
                return false;
            }
            if (x == n - 1) {
                return true;
            }
        }

        return false;
    }

    // Helper function to calculate (a^b) % c efficiently
    private static long power(long a, long b, long c) {
        long result = 1;
        a = a % c;

        while (b > 0) {
            if (b % 2 == 1) {
                result = (result * a) % c;
            }
            b /= 2;
            a = (a * a) % c;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to check for primality: ");
        long number = scanner.nextLong();
        System.out.print("Enter the number of iterations (k): ");
        int k = scanner.nextInt();
        scanner.close();

        if (isPrime(number, k)) {
            System.out.println(number + " is likely a prime number.");
        } else {
            System.out.println(number + " is not prime.");
        }
    }
}
