package fibonacci;

import java.math.BigInteger;
import static fibonacci.FibonacciSequence.*;

public class FibViz {

    private static void runFib(int n) {
        for (int i = 0; i <= n; i++) {
            long startTime = System.nanoTime();
            long val = fib(i);
            long endTime = System.nanoTime();
            System.out.printf("fib(%d) = %d \t time: %fs\n", i, val, (endTime - startTime) / 1e9);
        }
    }

    public static void printFibFast(int n) {
        BigInteger[] mem = setupMem(n);

        for (int i = 0; i <= n; i++) {
            long startTime = System.nanoTime();
            BigInteger val = fibFast(i, mem);
            long endTime = System.nanoTime();
            System.out.printf("fibFast(%d) = %d \t time: %fs\n", i, val, (endTime - startTime) / 1e9);
        }
    }

    public static void printFibFaster(int n) {
        for (int i = 0; i <= n; i++) {
            long startTime = System.nanoTime();
            BigInteger val = fibFaster(i);
            long endTime = System.nanoTime();
            System.out.printf("fibFaster(%d) = %s \t time: %fs\n", i, val, (endTime - startTime) / 1e9);
        }
    }

    public static void printFibFastest (int n) {
        for (int i = 0; i <= n; i++) {
            long startTime = System.nanoTime();
            BigInteger val = fibFastest(i);
            long endTime = System.nanoTime();
            System.out.printf("fibFaster(%d) = %s \t time: %fs\n", i, val, (endTime - startTime) / 1e9);
        }
    }

    static int fCount = 0;
    static int timeStep = 0;

    private static long fibStackViz(int n) {
        ++fCount;
        System.out.printf("t%03d |", ++timeStep);
        System.out.println("_____|".repeat(fCount) + "st:fib(" + n + "): ?");
        if (n == 0) {
            System.out.printf("t%03d |", ++timeStep);
            System.out.println("_____|".repeat(fCount) + "ed:fib(" + n + "): 0");
            --fCount;
            return 0;
        } if (n == 1) {
            System.out.printf("t%03d |", ++timeStep);
            System.out.println("_____|".repeat(fCount) + "ed:fib(" + n + "): 1");
            --fCount;
            return 1;
        }
        long fibPrev = fibStackViz(n - 1);
        long fibPrevPrev = fibStackViz(n - 2);
        long fibN = fibPrev + fibPrevPrev;

        System.out.printf("t%03d |", ++timeStep);
        System.out.println("_____|".repeat(fCount) + "ed:fib(" + n + "): " + fibN);
        --fCount;
        return fibN;
    }

}
