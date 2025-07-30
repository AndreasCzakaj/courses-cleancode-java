package eu.binarystars.cleancode.tests;

import java.util.Optional;

public interface FibonacciDao {
    Optional<Integer> get(int index);
    void put(int index, int value);
}
