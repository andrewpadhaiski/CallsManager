package com.redalpha.callsmanager.dao;

import java.io.Serializable;

import com.redalpha.callsmanager.domain.Call;

/**
 * Represents base behavior for working with domain entities,
 *
 * @param <T>  Type of object.
 * @param <ID> type of identifier.
 */
public interface BaseRepository<T, ID extends Serializable> {

    void save(Call call);
}
