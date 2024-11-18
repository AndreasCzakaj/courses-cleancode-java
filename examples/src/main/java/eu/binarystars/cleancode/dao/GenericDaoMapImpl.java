package eu.binarystars.cleancode.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class GenericDaoMapImpl<I, E> implements GenericDao<I, E> {
    private final Function<E, I> uidProvider;
    public final Map<String, E> repo = new HashMap<>();

    public GenericDaoMapImpl(Function<E, I> uidProvider) {
        this.uidProvider = uidProvider;
    }

    @Override
    public Optional<E> get(final I uid)  throws IOException {
        return Optional.ofNullable(repo.get(uid.toString()));
    }

    @Override
    public E save(final E entity) throws IOException {
        repo.put(uidProvider.apply(entity).toString(), entity);
        return entity;
    }
}
