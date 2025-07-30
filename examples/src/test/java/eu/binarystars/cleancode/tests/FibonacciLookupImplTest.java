package eu.binarystars.cleancode.tests;

import java.util.HashMap;
import java.util.Map;

class FibonacciLookupImplTest extends FibonacciTestBase {

    @Override
    Fibonacci createFibonacci() {
        Map<Integer, Integer> map = new HashMap<>() {{
            put(0, 0);
            put(1, 1);
            put(2, 1);
            put(3, 2);
            put(4, 3);
        }};
        return new FibonacciLookupImpl(new FibonacciDaoMapImpl(map));
    }
}
