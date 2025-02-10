package fibonacci;

import java.math.BigInteger;
import org.knowm.xchart.*;

import static fibonacci.FibonacciSequence.*;

public class FibViz {


    public static void main(String[] args) {
        int n = 1000;
        vizFibFastest(n);
    }

    private static void vizFib(int n) {
        double[] fibTimes = new double[n + 1];
        double[] fibN = new double[n + 1];
        for (int i = 0; i <= n; i++) {
            long startTime = System.nanoTime();
            long val = fib(i);
            long endTime = System.nanoTime();
            double totalTime = (endTime - startTime) / 1e9;

            fibTimes[i] = totalTime;
            fibN[i] = i;
        }
        XYChart chart = QuickChart.getChart("Time Complexity of fib(n)", "n", "Time", "time", fibN, fibTimes);
        new SwingWrapper<>(chart).displayChart();
    }

    public static void vizFibFast(int n) {
        BigInteger[] mem = setupMem(n);
        double[] fibFastTimes = new double[n + 1];
        double[] fibN = new double[n + 1];

        for (int i = 0; i <= n; i++) {
            long startTime = System.nanoTime();
            BigInteger val = fibFast(i, mem);
            long endTime = System.nanoTime();
            double totalTime = (endTime - startTime) / 1e9;

            fibFastTimes[i] = totalTime;
            fibN[i] = i;
        }
        XYChart chart = QuickChart.getChart("Time Complexity of fibFast(n)", "n", "Time", "time", fibN, fibFastTimes);
        new SwingWrapper<>(chart).displayChart();
    }

    public static void vizFibFaster(int n) {
        double[] fibFasterTimes = new double[n + 1];
        double[] fibN = new double[n + 1];

        for (int i = 0; i <= n; i++) {
            long startTime = System.nanoTime();
            BigInteger val = fibFaster(i);
            long endTime = System.nanoTime();
            double totalTime = (endTime - startTime) / 1e9;

            fibFasterTimes[i] = totalTime;
            fibN[i] = i;
        }
        XYChart chart = QuickChart.getChart("Time Complexity of fibFaster(n)", "n", "Time", "time", fibN, fibFasterTimes);
        new SwingWrapper<>(chart).displayChart();
    }

    public static void vizFibFastest (int n) {
        double[] fibFastestTimes = new double[n + 1];
        double[] fibN = new double[n + 1];

        for (int i = 0; i <= n; i++) {
            long startTime = System.nanoTime();
            BigInteger val = fibFastest(i);
            long endTime = System.nanoTime();
            double totalTime = (endTime - startTime) / 1e9;

            fibFastestTimes[i] = totalTime;
            fibN[i] = i;
        }
        XYChart chart = QuickChart.getChart("Time Complexity of fibFastest(n)", "n", "Time", "time", fibN, fibFastestTimes);
        new SwingWrapper<>(chart).displayChart();
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
