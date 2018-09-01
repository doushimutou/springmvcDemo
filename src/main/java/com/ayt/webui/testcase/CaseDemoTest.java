package com.ayt.webui.testcase;

import com.ayt.SpringbootMybatisDemoApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;

/**
 * @author ayt  on 20180901
 */
@Test
@SpringBootTest(classes = SpringbootMybatisDemoApplication.class)
@Component
public class CaseDemoTest extends BaseCase{

    @Test
    public void caseDemo(){
        driver.get("www.baidu.com" );
    }

}
