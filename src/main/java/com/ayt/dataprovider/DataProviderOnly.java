package com.ayt.dataprovider;

import org.testng.annotations.DataProvider;

import java.util.Iterator;

/**
 * @Auther: ayt
 * @Date: 2018/8/27 22:47
 * @Description: Don't worry ,just try
 */
public class DataProviderOnly {
    @DataProvider(name = "dataprovider")
    public static Iterator<Object[]>   onlyDP() {
        return  new ExcelDataProvider("excelTest","testData");
    }
}
