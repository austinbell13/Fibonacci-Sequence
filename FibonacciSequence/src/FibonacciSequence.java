public class FibonacciSequence {

    static int fCount = 0;
    static int timeStep = 0;

    private static long fib(int n) {
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
        long fibPrev = fib(n - 1);
        long fibPrevPrev = fib(n - 2);
        long fibN = fibPrev + fibPrevPrev;

        System.out.printf("t%03d |", ++timeStep); // Including a time step.
        System.out.println("_____|".repeat(fCount) + "ed:fib(" + n + "): " + fibN);
        --fCount;
        return fibN;
    }

    private static long fibNoViz(int n) {
        if (n == 0) {
            return 0;
        } if (n == 1) {
            return 1;
        }
        long fibPrev = fibNoViz(n - 1);
        long fibPrevPrev = fibNoViz(n - 2);
        long fibN = fibPrev + fibPrevPrev;

        return fibN;
    }

    private static void runFib() {
        int n = 5;
        long fibN = fib(n);
        System.out.println("fib(" + n + "): " + fibN);
    }

    private static void runFibMany() {
        for (int i = 0; i <= 50; i++) {
            long startTime = System.nanoTime();
            long val = fib(i);
            long endTime = System.nanoTime();
            System.out.printf("fib(%d) = %d \t time: %fs\n", i, val, (endTime - startTime) / 1e9);
        }
    }

    private static long fibFast(int n, Long[] mem) {
        // Top-Down Dynamic programming (memorization).
        if (mem[n] != null) {
            return mem[n];
        }
        // First base case.
        if (n == 0) {
            return 0;
        }
        // Second base case.
        if (n == 1) {
            return 1;
        }
        long fibPrev = fibNoViz(n - 1);
        long fibPrevPrev = fibNoViz(n - 2);
        long fibN = fibPrev + fibPrevPrev;

        mem[n] = fibN;

        return mem[n];
    }

    public static void runFastFibMany() {
        for (int i = 0; i <= 50; i++) {
            long startTime = System.nanoTime();
            // long val = fibFast(i, new Long[i + 1]);
            long val = fibFaster(i);
            long endTime = System.nanoTime();
            System.out.printf("fibFast(%d) = %d \t time: %fs\n", i, val, (endTime - startTime) / 1e9);
        }
    }

    // Bottom-up dynamic programming (Table-filling)
    public static long fibFaster (int n) {
        long[] dp = new long[Math.max(2, n + 1)];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        runFastFibMany();
    }

}
