package com.aniket.distributed.local.cache.dao;

import com.aniket.distributed.local.cache.exception.DaoException;
import com.aniket.distributed.local.cache.model.TaxiRide;
import com.aniket.distributed.local.cache.service.RedisMessagePublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class RedisRepositoryDaoImpl implements RedisRepositoryDao {

    private static final Logger logger = LoggerFactory.getLogger(RedisRepositoryDaoImpl.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisMessagePublisher redisMessagePublisher;

    private HashOperations hashOperations;

    private String hashRegion = "TAXIRIDE";

    @PostConstruct
    public void init(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void updateRemoteCache(TaxiRide taxiRide) throws DaoException {
        try{
            String bucketNumber = getBucketNumber(taxiRide.getTaxi_id());
            String hash = hashRegion + ":" + bucketNumber;
            hashOperations.put(hash , String.valueOf(taxiRide.getTaxi_id()), taxiRide);
            logger.info("Published " + String.valueOf(taxiRide.getTaxi_id()) + " to bucket number=" + bucketNumber);
            redisMessagePublisher.publish(String.valueOf(taxiRide.getTaxi_id()));
        } catch (Exception ex) {
            logger.error("Caught exception while updating remote cache. Exception=" + ex.getMessage());
            throw new DaoException("Caught exception while updating remote cache. Exception=" + ex.getMessage());
        }
    }



    public String getBucketNumber(int id){
        final int numSlots = 16384;
        return String.valueOf(id%numSlots);
    }

}
