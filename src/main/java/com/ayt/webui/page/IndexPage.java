package com.ayt.webui.page;

import com.ayt.webui.testcase.BaseCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @Auther: ayt
 * @Date: 2018/9/2 00:27
 * @Description: Don't worry ,just try
 */
public class IndexPage {
    private WebDriver driver;
    public IndexPage(WebDriver driver){
        this.driver=driver;
    }
    public  WebElement getSearchInput(){
        By by =By.xpath("//*[@id=\"kw\"]");
        return BaseCase.isElementExist(by) ? driver.findElement(by):null;
    }
}
