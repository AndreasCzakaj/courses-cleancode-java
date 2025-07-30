package eu.binarystars.cleancode.tests;

public class FibonacciLoopImpl extends FibonacciBaseImpl implements Fibonacci {

    Integer calcImpl(Integer index) {
        if (index < 2) {
            return index;
        }

        int out = 0;
        int prev1 = 0;
        int prev2 = 1;

        for (int i = 1; i <= index; i++) {
            out = prev1 + prev2;
            prev2 = prev1;
            prev1 = out;
        }

        return out;
    }
}
