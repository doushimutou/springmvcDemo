package com.ayt.webui;/**
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @author ayt
 * @date 2018/9/116:20
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author ayt  on 
 */
public class SeleniumHello {

    public static void main(String[] args) throws InterruptedException {
        String webDriver="webdriver.chrome.driver";

        String webDriverWinValue ="E:\\DWD-Test-webUI-test\\chromedriver\\chromedriver.exe";


        System.setProperty(webDriver, webDriverWinValue);

        //定义驱动对象为 FirefoxDriver 对象
        WebDriver driver = new ChromeDriver();


        //驱动的网址
        driver.get("http://www.baidu.com/");


        //浏览器窗口变大
        driver.manage().window().maximize();

       driver.wait(10);


        //关闭驱动
        driver.close();


    }

}

