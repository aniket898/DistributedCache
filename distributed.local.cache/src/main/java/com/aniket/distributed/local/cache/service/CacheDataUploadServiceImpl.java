package com.aniket.distributed.local.cache.service;

import com.aniket.distributed.local.cache.dao.RedisRepositoryDao;
import com.aniket.distributed.local.cache.exception.DaoException;
import com.aniket.distributed.local.cache.model.TaxiRide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Service
public class CacheDataUploadServiceImpl implements CacheDataUploadService{

    private static final Logger logger = LoggerFactory.getLogger(CacheDataUploadServiceImpl.class);

    @Value("${upload.file.location}")
    private String inputFilePath;

    @Autowired
    private RedisRepositoryDao redisRepositoryDao;

    @Override
    public boolean cacheData() throws DaoException {
        List<TaxiRide> taxiRideList;
        try{
            taxiRideList = createRideList();
            taxiRideList.forEach(taxiRide -> {
                try {
                    redisRepositoryDao.updateRemoteCache(taxiRide);
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            logger.error("Caught exception while uploading file data " + e.getMessage());
        }
        return false;
    }

    private List<TaxiRide> createRideList(){
        Random random = new Random();
        List taxiRideList = Collections.synchronizedList(new ArrayList());
        IntStream.range(0, 10).parallel().forEach(nbr -> {
            TaxiRide taxiRide = new TaxiRide();
            taxiRide.setTaxi_id(random.nextInt(Integer.MAX_VALUE));
            taxiRide.setTrip_start_timestamp("");
            taxiRide.setTrip_end_timestamp("");
            taxiRide.setTrip_seconds(random.nextInt(Integer.MAX_VALUE));
            taxiRide.setTrip_miles(random.nextFloat());
            taxiRide.setPickup_census_tract(random.nextInt(Integer.MAX_VALUE));
            taxiRide.setDropoff_census_tract(random.nextInt(Integer.MAX_VALUE));
            taxiRide.setPickup_community_area(random.nextInt(Integer.MAX_VALUE));
            taxiRide.setDropoff_community_area(random.nextInt(Integer.MAX_VALUE));
            taxiRide.setFare(random.nextFloat());
            taxiRide.setTips(1.0F);
            taxiRide.setTolls(3.0F);
            taxiRide.setTolls(1.0F);
            taxiRide.setTrip_total(taxiRide.getFare()+4.0F);
            taxiRide.setPayment_type("Cash");
            taxiRide.setCompany(random.nextInt(4));
            taxiRide.setPickup_latitude(random.nextInt(Integer.MAX_VALUE));
            taxiRide.setPickup_longitude(random.nextInt(Integer.MAX_VALUE));
            taxiRide.setDropoff_latitude(random.nextInt(Integer.MAX_VALUE));
            taxiRide.setDropoff_longitude(random.nextInt(Integer.MAX_VALUE));
            taxiRideList.add(taxiRide);
        });

        return taxiRideList;
    }

}