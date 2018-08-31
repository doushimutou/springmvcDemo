package com.ayt.dataprovider;

import com.ayt.utils.excel.ReadExcel;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;

/**
 * @Auther: ayt
 * @Date: 2018/8/26 22:35
 * @Description: Don't worry ,just try
 */

public class ReadExceLTest {
    private static String filePath ="F:\\git\\springboot-mybatis\\src\\main\\java\\com\\ayt\\exceldata\\excelTest.xls";
    private static Logger logger=Logger.getLogger(DataProvider1Test.class);

    @Test
    public void readExcel() throws Exception {

        List<List<Map<String,String>>> result =  ReadExcel.readExcel(filePath);

        logger.info(result);
    }

}
