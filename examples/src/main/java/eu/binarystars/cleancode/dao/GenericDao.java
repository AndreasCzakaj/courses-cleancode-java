package eu.binarystars.cleancode.dao;

import java.util.Optional;

public interface GenericDao<I, E> {
    Optional<E> get(I uid) throws DaoException;
    E save(E entity) throws DaoException;
}
