package com.ayt.dataprovider;

import com.ayt.utils.excel.ReadExcel;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Auther: ayt
 * @Date: 2018/8/27 22:59
 * @Description: Don't worry ,just try
 */
public class ExcelDataProvider1 {
    private static String classname ="excelTest";
    private static Logger logger=Logger.getLogger(DataProvider1Test.class);
    @Test(dataProvider = "dataprovider",dataProviderClass = DataProviderOnly.class)
    public void testData(Map<String,String> data){
      String list = data.get("姓名");
      logger.info(list);
      logger.info(data);
    }




}
