package com.ayt.mongo.dao;

import java.util.List;

import com.ayt.mongo.entiy.Region;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * @Auther: ayt
 * @Date: 2018/9/9 21:28
 * @Description: Don't worry ,just try
 */
public interface RegionService {
    /**
     * 查询城市下所有已发布区域、区块
     *
     * @param cityId cityId
     * @return region list
     */
    Region findRegion(Integer cityId);

//    public List<Region> findDeployRegion(Integer cityId) {
//        Criteria criteria = Criteria.where("cityId").is(cityId)
//                .and("status").is(RegionStatus.DEPLOYED.getCode());
//        return regionRepository.find(new Query(criteria));
//    }
}
