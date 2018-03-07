package com.aniket.distributed.local.cache.dao;

import com.aniket.distributed.local.cache.exception.DaoException;

public interface RedisRepositoryDao {

    void updateRemoteCache() throws DaoException;
}
