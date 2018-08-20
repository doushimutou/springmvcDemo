package com.ayt.dataprovider;

/**
 * @Auther: ayt
 * @Date: 2018/8/19 23:22
 * @Description: Don't worry ,just try
 */

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import java.lang.reflect.Method;
import java.util.Random;


public class DataProvider1{

    @DataProvider(name = "create")
    public Object[][] dataCreate(){
        int lower=5;
        int upper=10;
        return new  Object[][]{
            {lower-1,lower,upper,false},
            {lower, lower, upper, true},
        };
    }

    /**
     * 数据提供者本身可以接受两个类型的参数：Method和ITestContext
     * method:
     * 数据提供者代码相当复杂，应该保存在一个地方，这样维护起来更方便。
        我们要传入数据的那些测试方法具有许多参数，其中只有少数参数是不一样的。
         我们引入了某个方法的特殊情况。
     * @param method
     * @return
     */
    @DataProvider(name="create1")
    public Object[][] provideNumbers(Method method){
        String methodName = method.getName();

        if (methodName.equals("two")){
            return new Object[][]{new Object[] {2}};
        }
        if (methodName.equals("three")){
            return new Object[][]{new Object[] {3}};
        }
        return null;
    }

    /**
     * ITestContext参数
     如果一个数据提供者在方法签名中声名了一个ITestContext类型的参数，
     TestNG就会将当前的测试上下文设置给它，这使得数据提供者能够知道当前测试执行的运行时刻参数。
     * @param iTestContext
     * @return
     */
    @DataProvider(name ="create2")
    public Object[][] randomIntegers(ITestContext iTestContext) {

        String[] groups = iTestContext.getIncludedGroups();
        int size = 2;
        for (String group : groups
                ) {
            if (group.equals("functional-test")) {
                size = 10;
                break;
            }
        }
        Object[][] result = new Object[size][];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            result[i] = new Object[]{
                    new Integer(random.nextInt())
            };
        }
        return  result;
    }

    }

