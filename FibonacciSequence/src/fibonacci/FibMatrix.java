package fibonacci;

import java.math.BigInteger;

public class FibMatrix {
    // Multiplies two 2x2 matrices
    private static void multiplyMatrix(BigInteger[][] A, BigInteger[][] B) {
        BigInteger x = A[0][0].multiply(B[0][0]).add(A[0][1].multiply(B[1][0]));
        BigInteger y = A[0][0].multiply(B[0][1]).add(A[0][1].multiply(B[1][1]));
        BigInteger z = A[1][0].multiply(B[0][0]).add(A[1][1].multiply(B[1][0]));
        BigInteger w = A[1][0].multiply(B[0][1]).add(A[1][1].multiply(B[1][1]));


        A[0][0] = x;
        A[0][1] = y;
        A[1][0] = z;
        A[1][1] = w;
    }

    // Raises matrix F to the power n using exponentiation
    private static void powerMatrix(BigInteger[][] F, int n) {
        if (n == 0 || n == 1)
            return;

        BigInteger[][] M = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};

        powerMatrix(F, n / 2);
        multiplyMatrix(F, F);

        if (n % 2 != 0)
            multiplyMatrix(F, M);
    }

    // Computes the nth Fibonacci number
    public static BigInteger fibonacci(int n) {
        if (n == 0)
            return BigInteger.ZERO;
        BigInteger[][] F = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};
        powerMatrix(F, n - 1);
        return F[0][0];
    }

    public static void main(String[] args) {
        int n = 5000000;
        long startTime = System.nanoTime();
        System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));  // Output: 55
        long endTime = System.nanoTime();
        System.out.printf("took %fs", (endTime - startTime) / 1e9);
    }
}
