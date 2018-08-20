package com.ayt.listener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * @Auther: ayt
 * @Date: 2018/8/18 00:38
 * @Description: Don't worry ,just try
 */
@Listeners(CITestListener.class)
public class SampleTest {
    @Test
    public void testMethodOne(){
        Assert.assertTrue(true);
    }

    @Test
    public void testMethodTwo(){
        Assert.assertTrue(false);
    }

    /**
     * 依赖测试
     */
    @Test(dependsOnMethods={"testMethodTwo"})
    public void testMethodThree(){
        Assert.assertTrue(true);
    }
}
