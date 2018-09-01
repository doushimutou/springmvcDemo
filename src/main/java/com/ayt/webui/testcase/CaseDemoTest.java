package com.ayt.webui.testcase;

import com.ayt.SpringbootMybatisDemoApplication;
import com.ayt.dataprovider.DataProviderOnly;
import com.ayt.webui.action.BaseAction;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * @author ayt  on 20180901
 */

@SpringBootTest(classes = SpringbootMybatisDemoApplication.class)
@Component
public class CaseDemoTest extends BaseCase{

    @Test(dataProvider = "dataprovider",dataProviderClass = DataProviderOnly.class)
    public void caseDemo(Map<String ,String> data) throws InterruptedException {
        driver.get("http://www.baidu.com/" );
        BaseAction baseAction= new BaseAction(driver);
        baseAction.wait(5);
        baseAction.setSearch(data,driver);


    }

}
