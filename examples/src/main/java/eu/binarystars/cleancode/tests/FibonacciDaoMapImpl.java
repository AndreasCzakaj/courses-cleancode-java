package eu.binarystars.cleancode.tests;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FibonacciDaoMapImpl implements FibonacciDao {
    private final Map<Integer, Integer> map;

    FibonacciDaoMapImpl(Map<Integer, Integer> map) {
        this.map = map == null ? new HashMap<>() : map;
    }
    public Optional<Integer> get(int index) {
        return Optional.ofNullable(map.get(index));
    }

    public  void put(int index, int value) {
        map.put(index, value);
    }
}
