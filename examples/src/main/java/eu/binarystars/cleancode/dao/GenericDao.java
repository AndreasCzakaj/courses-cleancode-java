package eu.binarystars.cleancode.dao;

import java.io.IOException;
import java.util.Optional;

public interface GenericDao<I, E> {
    Optional<E> get(I uid) throws IOException;
    E save(E entity) throws IOException;
}
