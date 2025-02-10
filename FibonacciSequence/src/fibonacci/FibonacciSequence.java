package fibonacci;

import java.math.BigInteger;

public class FibonacciSequence {

    public static long fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long fibPrev = fib(n - 1);
        long fibPrevPrev = fib(n - 2);

        return fibPrev + fibPrevPrev;
    }

    public static void runFib(int n) {
        for (int i = 0; i <= n; i++) {
            long val = fib(i);
        }
    }

    public static BigInteger[] setupMem(int n) {
        BigInteger[] mem = new BigInteger[n + 1];
        mem[0] = BigInteger.ZERO;
        if (n > 0) mem[1] = BigInteger.ONE;

        return mem;
    }

    // Top-down dynamic programming (memorization).
    public static BigInteger fibFast(int n, BigInteger[] mem) {
        // If already computed, return the stored value
        if (mem[n] != null) return mem[n];
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;

        BigInteger curr = fibFast(n - 1, mem);
        BigInteger prev = fibFast(n - 2, mem);
        BigInteger next = curr.add(prev);
        mem[n] = next;

        return next;
    }

    public static void runFibFast(int n) {
        BigInteger[] mem = setupMem(n);
        for (int i = 0; i <= n; i++) {
            BigInteger val = fibFast(i, mem);
        }
    }

    // Bottom-up dynamic programming (Table-filling)
    // Stores previous values. Space Complexity = O(n)
    public static BigInteger fibFaster(int n) {
        BigInteger[] dp = new BigInteger[Math.max(2, n + 1)];
        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }
        return dp[n];
    }

    public static void runFibFaster(int n) {
        for (int i = 0; i <= n; i++) {
            BigInteger val = fibFaster(i);
        }
    }

    public static BigInteger fibFastest(int n) {
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;

        BigInteger prev = BigInteger.ZERO, curr = BigInteger.ONE;
        for (int i = 0; i <= n - 2; i++) {
            BigInteger next = prev.add(curr);
            prev = curr;
            curr = next;
        }
        return curr;
    }

}
