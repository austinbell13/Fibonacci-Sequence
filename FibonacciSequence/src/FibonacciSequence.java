import java.math.BigInteger;

public class FibonacciSequence {

    static int fCount = 0;
    static int timeStep = 0;

    private static long fibViz(int n) {
        ++fCount; // Stack frame count.
        // Stack frame visualization.
        System.out.printf("t%03d |", ++timeStep); // Including a time step.
        System.out.println("_____|".repeat(fCount) + "st:fib(" + n + "): ?");
        if (n == 0) {
            System.out.printf("t%03d |", ++timeStep); // Including a time step.
            System.out.println("_____|".repeat(fCount) + "ed:fib(" + n + "): 0");
            --fCount;
            return 0;
        } if (n == 1) {
            System.out.printf("t%03d |", ++timeStep); // Including a time step.
            System.out.println("_____|".repeat(fCount) + "ed:fib(" + n + "): 1");
            --fCount;
            return 1;
        }
        long fibPrev = fibViz(n - 1);
        long fibPrevPrev = fibViz(n - 2);
        long fibN = fibPrev + fibPrevPrev;

        System.out.printf("t%03d |", ++timeStep); // Including a time step.
        System.out.println("_____|".repeat(fCount) + "ed:fib(" + n + "): " + fibN);
        --fCount;
        return fibN;
    }

    private static long fib(int n) {
        if (n == 0) {
            return 0;
        } if (n == 1) {
            return 1;
        }
        long fibPrev = fib(n - 1);
        long fibPrevPrev = fib(n - 2);
        long fibN = fibPrev + fibPrevPrev;

        return fibPrev + fibPrevPrev;
    }


    /**
     * private static void runFib() {
     *     int n = 5;
     *     long fibN = fib(n);
     *     System.out.println("fib(" + n + "): " + fibN);
     * }
     */

    private static void runFibMany(int n) {
        for (int i = 0; i <= n; i++) {
            long startTime = System.nanoTime();
            long val = fib(i);
            long endTime = System.nanoTime();
            System.out.printf("fib(%d) = %d \t time: %fs\n", i, val, (endTime - startTime) / 1e9);
        }
    }

    // Top-down dynamic programming (memorization).
    private static BigInteger fibFast(int n, BigInteger[] mem) {
        // If already computed, return the stored value
        if (mem[n] != null) {
            return mem[n];
        }

        // Base cases
        if (n == 0) {
            return BigInteger.ZERO;
        }
        if (n == 1) {
            return BigInteger.ONE;
        }

        BigInteger fibPrev = fibFast(n - 1, mem);
        BigInteger fibPrevPrev = fibFast(n - 2, mem);
        BigInteger fibN = fibPrev.add(fibPrevPrev);

        mem[n] = fibN;

        return fibN;
    }

    public static void runFibFastMany(int n) {
        for (int i = 0; i <= n; i++) {
            long startTime = System.nanoTime();
            // long val = fibFast(i, new Long[i + 1]);
            BigInteger val = fibFast(i, new BigInteger[i + 1]);
            long endTime = System.nanoTime();
            System.out.printf("fibFast(%d) = %d \t time: %fs\n", i, val, (endTime - startTime) / 1e9);
        }
    }

    // Bottom-up dynamic programming (Table-filling).
    public static BigInteger fibFaster(int n) {
        BigInteger[] dp = new BigInteger[Math.max(2, n + 1)];
        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }
        return dp[n];
    }

    public static void runFibFasterMany(int n) {
        for (int i = 0; i <= n; i++) {
            long startTime = System.nanoTime();
            BigInteger val = fibFaster(i);
            long endTime = System.nanoTime();
            System.out.printf("fibFaster(%d) = %s \t time: %fs\n", i, val, (endTime - startTime) / 1e9);
        }
    }

    public static void main(String[] args) {
        int n = 40;
        fibViz(n);
        runFibMany(n);
        runFibFastMany(n);
        runFibFasterMany(n);
    }

}
