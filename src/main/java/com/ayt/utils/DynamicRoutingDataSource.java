//package com.ayt.utils;
//
//
//import org.apache.log4j.Logger;
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
///**
// * @Auther: ayt
// * @Date: 2018/8/12 23:00
// * @Description: Don't worry ,just try
// */
//public class DynamicRoutingDataSource {
//    private static final Logger LOG = Logger.getLogger(DynamicRoutingDataSource.class);
//    @Override
//    protected Object determineCurrentLookupKey() {
//        LOG.info("当前数据源：{}"+ DynamicDataSourceContextHolder.get());
//        return DynamicDataSourceContextHolder.get();
//    }
//}
