package com.aniket.distributed.local.cache.service;

import com.aniket.distributed.local.cache.exception.DaoException;

public interface CacheDataUploadService {

    boolean cacheData() throws DaoException;
}
