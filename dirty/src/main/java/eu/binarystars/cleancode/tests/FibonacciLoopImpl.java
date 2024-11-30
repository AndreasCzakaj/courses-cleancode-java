package eu.binarystars.cleancode.tests;


import static java.util.stream.IntStream.range;

public class FibonacciLoopImpl {

    public Integer calc(Integer index) {
        if (index == null) {
            return null;
        }
        if (index < 0) {
            throw new IllegalArgumentException("negative indices not allowed for Fibonacci");
        }
        if (index > 46) {
            throw new IllegalArgumentException("only supported for index <= 46");
        }
        if (index == 0) {
            return 0;
        }
        if (index == 1) {
            return 1;
        }

        final int[] fib = {0, 1};
        range(2, index + 1).forEach(i -> {
            int next = fib[0] + fib[1];
            fib[0] = fib[1];
            fib[1] = next;
        });

        return fib[1];
    }
}
