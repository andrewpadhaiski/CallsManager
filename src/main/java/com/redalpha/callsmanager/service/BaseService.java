package com.redalpha.callsmanager.service;

import java.io.Serializable;

/**
 * Represents base behavior for working with domain entities,
 *
 * @param <T>  Type of object.
 * @param <ID> type of identifier.
 */
public interface BaseService<T, ID extends Serializable> {

    void save(T entity);
}
