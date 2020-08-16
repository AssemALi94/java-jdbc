package com.jdbc.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> get(long id);

    List<T> getAll();

    int save(T t);

    int update(T t, long id);

    int delete(long id);
}