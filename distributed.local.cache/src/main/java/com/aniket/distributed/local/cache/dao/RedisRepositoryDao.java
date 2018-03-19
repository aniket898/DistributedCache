package com.aniket.distributed.local.cache.dao;

import com.aniket.distributed.local.cache.exception.DaoException;
import com.aniket.distributed.local.cache.model.TaxiRide;

public interface RedisRepositoryDao {

    void updateRemoteCache(TaxiRide taxiRide) throws DaoException;
}
