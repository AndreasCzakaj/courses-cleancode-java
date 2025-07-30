package eu.binarystars.cleancode.tests;

abstract class FibonacciBaseImpl implements Fibonacci {
    void checkIndex(Integer index) {
        if (index == null) {
            throw new IllegalArgumentException("Index must not be null");
        }

        if (index < 0) {
            throw new IllegalArgumentException("Index must be positive integer");
        }

        if (index > 46) {
            throw new IllegalArgumentException("Index only allowed up to 46");
        }
    }

    public final Integer calc(Integer index) {
        checkIndex(index);

        return calcImpl(index);
    }

    abstract Integer calcImpl(Integer index);
}
