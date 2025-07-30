package eu.binarystars.cleancode.tests;

class FibonacciRecursionImplTest extends FibonacciTestBase {

    @Override
    Fibonacci createFibonacci() {
        return new FibonacciRecursionImpl();
    }
}
