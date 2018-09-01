package com.ayt.webui.testcase;

import com.ayt.SpringbootMybatisDemoApplication;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


    String webDriver="webdriver.chrome.driver";

    String webDriverWinValue ="E:/mygit/testngDemoLearn/chromedriver/chromedriver.exe";
    public static WebDriver driver;

    @BeforeSuite
    public void initSuite(){
        //初始化整个项目，如配置数据同步
    }


    @BeforeClass
    public void initTest()  {

        logger.info(webDriver+webDriverWinValue);

        System.setProperty(webDriver,webDriverWinValue);

        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @AfterClass
    public void close(){
        //关闭浏览器等操作，当然你也可以放在@AfterTest或@AfterMethod
        logger.info("关闭浏览器...");
        driver.quit();
    }














}