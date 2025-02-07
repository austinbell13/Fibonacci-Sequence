package fibonacci;

import java.math.BigInteger;
import static fibonacci.FibonacciSequence.*;

public class FibTime {

    public static void main(String[] args) {
        int n = 500000;
        timeFibFastest(n);
    }

    public static void timeFib(int n) {
        long startTime = System.nanoTime();
        runFib(n);
        long endTime = System.nanoTime();

        System.out.printf("fib(%d): %fs\n", n, (endTime - startTime) / 1e9);
    }

    public static void timeFibFast(int n) {
        long startTime = System.nanoTime();
        runFibFast(n);
        long endTime = System.nanoTime();

        System.out.printf("fibFast(%d): %fs\n", n, (endTime - startTime) / 1e9);
    }

    public static void timeFibFaster(int n) {
        long startTime = System.nanoTime();
        runFibFaster(n);
        long endTime = System.nanoTime();

        System.out.printf("fibFaster(%d): %fs\n", n, (endTime - startTime) / 1e9);
    }

    public static void timeFibFastest(int n) {
        long startTime = System.nanoTime();
        BigInteger val = fibFastest(n);
        long endTime = System.nanoTime();

        System.out.printf("fibFastest(%d): %fs\n", n, (endTime - startTime) / 1e9);
        System.out.println();
    }

}
