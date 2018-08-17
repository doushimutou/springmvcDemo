package com.ayt.listener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;

/**
 * @Auther: ayt
 * @Date: 2018/8/18 00:41
 * @Description: Don't worry ,just try
 */
public class ListenerTest extends TestListenerAdapter {
    private static Logger logger = LogManager.getLogger(ListenerTest.class);
    private int m_count = 0;

    @Override
    public void onTestFailure(ITestResult tr) {
        log(tr.getName()+ "--Test method failed\n");
        logger.info("测试失败");

    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        log(tr.getName()+ "--Test method skipped\n");
        logger.info("测试跳过");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        log(tr.getName()+ "--Test method success\n");
        logger.info("测试成功");
    }

    private void log(String string) {
        System.out.print(string);
        if (++m_count % 40 == 0) {
            System.out.println("");
        }
    }




}
