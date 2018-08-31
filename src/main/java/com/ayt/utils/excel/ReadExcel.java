package com.ayt.utils.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: ayt
 * @Date: 2018/8/26 21:05
 * @Description: Don't worry ,just try
 */
public class ReadExcel {

    public static List<List<Map<String,String>>> readExcel(String filePath) throws Exception {
       String fileType = filePath.substring(filePath.lastIndexOf(".")+1, filePath.length());
        InputStream is = null;
        Workbook wb = null;
        try {
            is = new FileInputStream(filePath);
            //区分文件格式
            if (fileType.equals("xls")) {
                wb = new HSSFWorkbook(is);
            } else if (fileType.equals("xlsx")) {
                wb = new XSSFWorkbook(is);
            } else {
                throw new Exception("读取的不是excel文件");
            }
            //excel文件
            List<List<Map<String, String>>> result = new ArrayList<List<Map<String, String>>>();

            int sheetSize =wb.getNumberOfSheets();
            //遍历sheet,sheet为list,
            for (int i = 0; i <sheetSize ; i++) {
                Sheet sheet =wb.getSheetAt(i);
                //放对应的sheet页
                List<Map<String ,String>> sheetList = new ArrayList<Map<String, String>>();
                //放所有的标题，第一行
                List<String> titles = new ArrayList<String>();
                //所有的行数
                int rowSize = sheet.getLastRowNum()+1;
                //遍历行
                for (int j = 0; j <rowSize ; j++) {
                    //获取当前行
                    Row row =sheet.getRow(j);
                    //空行继续
                    if (row ==null){
                        continue;
                    }
                    //获取行中的列数
                    int  cellSize = row.getLastCellNum();
                    //把第一行的数据当做title
                    if(j==0) {
                        for (int k = 0; k <cellSize ; k++) {
                            Cell cell =row.getCell(k);
                            titles.add(cell.toString());
                        }
                    }else {
                        //其他行的行的数据,用map装起来
                        // 对应一行的数据
                        Map<String,String> rowMap = new HashMap<String, String>();
                        //遍历一行的数据
                        for (int k = 0; k <titles.size() ; k++) {
                            Cell cell = row.getCell(k);
                            String key = titles.get(k);
                            String value= null;
                            if (cell!=null){
                                value=cell.toString();
                            }
                            //这一行，标题对应的数据，放进map
                            rowMap.put(key,value);
                        }
                        //把所有的map,装进list
                        sheetList.add(rowMap);
                    }
                }
                result.add(sheetList);
            }
            return result;
        } catch (FileNotFoundException e) {
            throw e;
        }finally {
            if (wb!=null){
                wb.close();
            }if (is!=null){
                is.close();
            }
        }
    }












}
