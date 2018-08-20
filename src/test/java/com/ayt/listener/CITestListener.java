package com.ayt.listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;

/**
 * @Auther: ayt
 * @Date: 2018/8/19 15:45
 * @Description: Don't worry ,just try
 */
public class CITestListener implements org.testng.ITestListener {

    private static Logger logger =Logger.getLogger(CITestListener.class);
    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.info("测试开始"+iTestResult.getMethod().getMethodName()+iTestResult.getStartMillis());


    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.info("革命成功了");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logger.info("革命尚未成功，同志可以在努努力");

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logger.info("跳过，不革命");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
