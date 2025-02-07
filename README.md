# Fibonacci Sequence in Java

### Overview

This Java project calculates Fibonacci numbers using multiple approaches and includes a method to visualize the JVM call stack during recursive calls. The different implementations of Fibonacci calculation provided in this project are:
- `fibViz` - A recursive Fibonacci function with a visualization of the call stack.

- `fib` - A traditional recursive Fibonacci function.

- `fibFast` - A top-down dynamic programming approach (memoization).

- `fibFaster` - A bottom-up dynamic programming approach (table-filling).

### Features

- Visualization of recursion using `fibViz`.

- Recursive implementation with `fib`.

- Optimized solutions using dynamic programming (`fibFast` and `fibFaster`).

- Performance measurement of different Fibonacci computation methods.

### Methods Explained

`fibViz(int n)`
- Recursively calculates Fibonacci numbers while printing the JVM call stack.
- Useful for understanding recursion depth and function calls.

`fib(int n)`

- Traditional recursive Fibonacci function.

- Time Complexity: O(2^n)

`fibFast(int n, BigInteger[] mem)`

- Uses memoization (top-down dynamic programming) to avoid redundant calculations.

- Time Complexity: O(n)

`fibFaster(int n)`

- Uses bottom-up dynamic programming (tabulation) to calculate Fibonacci numbers iteratively.

- Time Complexity: O(n)