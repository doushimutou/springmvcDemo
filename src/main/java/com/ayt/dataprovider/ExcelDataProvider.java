package com.ayt.dataprovider;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


import org.testng.Assert;



import java.io.FileInputStream;
import java.io.InputStream;

import java.util.*;

/**
 * excel文件的数据提供者,重写了迭代器
 * @Auther: ayt
 * @Date: 2018/8/20 22:55
 * @Description: Don't worry ,just try
 */
public class ExcelDataProvider implements Iterator<Object[]> {

        private Workbook book         = null;
        private Sheet sheet        = null;
        private int      rowNum       = 0;
        private int      currentRowNo = 0;
        private int      columnNum    = 0;
        private String[] columnnName;

    public  ExcelDataProvider(String classname,String methodname){
        try {
            int dotNum = classname.indexOf(".");
            if (dotNum > 0) {
                classname = classname.substring(classname.lastIndexOf(".") + 1,
                        classname.length());
            }

            String path = "F:\\git\\springboot-mybatis\\src\\main\\java\\com\\ayt\\exceldata\\" + classname + ".xls";
            InputStream inputStream = new FileInputStream(path);

            book = Workbook.getWorkbook(inputStream);
            List<String> sheetNames = Arrays.asList(book.getSheetNames());
            if(sheetNames.contains(methodname)){
                sheet = book.getSheet(methodname);
            }else{
                sheet = book.getSheet(0);
            }
            rowNum = sheet.getRows();
            Cell[] cell = sheet.getRow(0);
            columnNum = cell.length;
            columnnName = new String[cell.length];
            //读表头
            for (int i = 0; i < cell.length; i++) {
                columnnName[i] = cell[i].getContents().toString();
            }
            this.currentRowNo++;
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("unable to read Excel data");
        }
    }

    public ExcelDataProvider(String classname) {
         this(classname,null);
    }


    @Override
    public boolean hasNext() {

        if (this.rowNum == 0 || this.currentRowNo >= this.rowNum) {
            try {
                book.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        } else {
            // sheet下一行内容最后一个字段为空，则判定结束
            if ((sheet.getRow(currentRowNo))[0].getContents().equals("#")){
                return false;
            }
            return true;
        }
    }

    @Override
    public Object[] next() {
        Cell[] c = sheet.getRow(this.currentRowNo);
        Map<String, String> data = new HashMap<String, String>();

        // List<String> list = new ArrayList<String>();
        for (int i = 0; i < this.columnNum; i++) {
            String temp = "";
            try {
                temp = c[i].getContents().toString();
            } catch (ArrayIndexOutOfBoundsException ex) {
                temp = "";
            }
            // if(temp != null&& !temp.equals(""))
            // list.add(temp);
            data.put(this.columnnName[i], temp);
        }
        Object object[] = new Object[1];
        object[0] = data;
        this.currentRowNo++;
        return object;

    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove unsupported.");
    }
}
