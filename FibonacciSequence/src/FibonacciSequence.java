public class FibonacciSequence {

    public static void main(String[] args) {
        runFib();
    }
    static int fCount = 0;
    private static long fib(int n) {
        ++fCount;
        System.out.println("     |".repeat(fCount) + "st:fib(" + n + "): ?");
        if (n == 0) {
            System.out.println("     |".repeat(fCount) + "ed:fib(" + n + "): 0");
            --fCount;
            return 0;
        } if (n == 1) {
            System.out.println("     |".repeat(fCount) + "ed:fib(" + n + "): 1");
            --fCount;
            return 1;
        }
        long fibPrev = fib(n - 1);
        long fibPrevPrev = fib(n - 2);
        long fibN = fibPrev + fibPrevPrev;
        System.out.println("     |".repeat(fCount) + "ed:fib(" + n + "): " + fibN);
        --fCount;
        return fibN;
    }

    private static void runFib() {
        int n = 5;
        long fibN = fib(n);
        System.out.println("fib(" + n + "): " + fibN);
    }

}
