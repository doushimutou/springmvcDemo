package com.ayt.webui.action;

import com.ayt.webui.page.IndexPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

import static java.lang.Thread.sleep;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author admin
 * @Auther: ayt
 * @Date: 2018/9/2 00:19
 * @Description: Don't worry ,just try
 */
public class BaseAction {
    private WebDriver driver;
    private static Logger logger = LogManager.getLogger(BaseAction.class);

    public BaseAction(WebDriver driver){
        this.driver = driver;
    }

    /**
     * 搜索DEMO
     * @param
     */
    public void setSearch(Map<String,String> data,WebDriver driver) throws InterruptedException {
        IndexPage indexPage = new IndexPage(driver);
        click(indexPage.getSearchInput());
        setText(indexPage.getSearchInput(),data.get("txt"),true);
        wait(10);


    }


    public void click(WebElement e){
        if(e != null){
            logger.info("点击对象：" + getText(e));
            e.click();
        }else{
            logger.error("未找到对象");
        }
    }

    public void setText(WebElement element, Object content, boolean isPrintLog){
        if(element != null){
            element.clear();
            element.sendKeys(String.valueOf(content));
            if(isPrintLog){
                assertEquals(getText(element), content+"", "输入");
            }
        }else{
            logger.error("文本框元素未找到");
        }
    }

    public String getText(WebElement e){
        String text = "";
        if(e != null){
            if (e.getText().length()>0){
                text = e.getText();
            }
        }
        return text;
    }

    public void wait(int second) throws InterruptedException {
        sleep(1000*second);
    }



}
