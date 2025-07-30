package eu.binarystars.cleancode.tests;

public class FibonacciRecursionImpl extends FibonacciBaseImpl implements Fibonacci {

    Integer calcImpl(Integer index) {
        if (index < 2) {
            return index;
        }

        return calcImpl(index - 2) + calcImpl(index - 1);
    }
}
