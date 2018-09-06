package com.ayt.webui.testcase;

import com.ayt.SpringbootMybatisDemoApplication;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

/**
 * @author ayt  on 220180901
 */

@Component
public class BaseCase extends AbstractTestNGSpringContextTests{

    public static Logger logger = LoggerFactory.getLogger(BaseCase.class);

    @Value("${webDriver}")
    String webDriver;
    @Value("${webDriver.Win.Value}")
    String webDriverWinValue ;

    public static WebDriver driver;

    @BeforeClass
    public void initTest() throws InterruptedException {

        logger.info(webDriver+webDriverWinValue);
        System.setProperty(webDriver,webDriverWinValue);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void close(){
        //关闭浏览器
        logger.info("关闭浏览器");
        driver.quit();
    }

    /**
     * 判断元素是否存在
     * @param by
     * @return
     */
    public static boolean isElementExist(By by) {
        boolean isExist=false;
        int length=driver.findElements(by).size();
        if(length>0){
            isExist=true;
        }
        return isExist;
    }
}
