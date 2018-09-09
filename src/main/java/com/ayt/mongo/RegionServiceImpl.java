package com.ayt.mongo;

import com.ayt.mongo.dao.RegionService;
import com.ayt.mongo.entiy.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * @Auther: ayt
 * @Date: 2018/9/9 21:38
 * @Description: Don't worry ,just try
 */
public class RegionServiceImpl implements RegionService{
    
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public Region findRegion(Integer cityId) {
        Query query =new Query(Criteria.where("cityId").is(cityId));
        Region region =mongoTemplate.findOne(query,Region.class);
        return region;
    }
}
