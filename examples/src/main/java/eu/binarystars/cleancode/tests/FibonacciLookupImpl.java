package eu.binarystars.cleancode.tests;

import eu.binarystars.cleancode.dao.GenericDao;

import java.util.Map;

public class FibonacciLookupImpl extends FibonacciBaseImpl implements Fibonacci {
    private final FibonacciDao dao;

    FibonacciLookupImpl(FibonacciDao dao) {
        this.dao = dao;
    }

    @Override
    Integer calcImpl(final Integer index) {
        return dao.get(index).orElseGet(() -> {
            var newValue = calcImpl(index - 2) + calcImpl(index - 1);
            dao.put(index, newValue);
            return newValue;
        });
    }
}
