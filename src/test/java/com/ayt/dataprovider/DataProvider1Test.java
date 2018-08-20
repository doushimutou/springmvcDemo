package com.ayt.dataprovider;

import org.apache.log4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * @Auther: ayt
 * @Date: 2018/8/19 23:37
 * @Description: Don't worry ,just try
 */
@Listeners
@SpringBootTest
public class DataProvider1Test {
    private static Logger logger=Logger.getLogger(DataProvider1Test.class);
    @Test(dataProvider = "create",dataProviderClass = DataProvider1.class)
    public void testDataCreat(int x,int y,int z,boolean expected){

       logger.info(x+y+z);
       logger.info(expected);

    }
    @Test(dataProvider = "create",dataProviderClass = DataProvider1.class)
    public void testDataCreat1(Object[][] objects){

//        logger.info(x+y+z);
//        logger.info(expected);


        for (int i=0;i<objects.length;i++){
            for (int j = 0; j <objects[i].length ; j++) {
                 logger.info(objects[i][j]);
            }
        }


        }




    @Test(dataProvider = "create1",dataProviderClass = DataProvider1.class)
    public void two (int x){
        logger.info(x);
    }


    @Test(dataProvider = "create2",dataProviderClass = DataProvider1.class)
    public void randow(Integer n){
        logger.info(n);
    }



}
