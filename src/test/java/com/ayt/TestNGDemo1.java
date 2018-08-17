package com.ayt;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @Auther: ayt
 * @Date: 2018/8/18 00:04
 * @Description: Don't worry ,just try
 */
public class TestNGDemo1 {
    /**
     *注解的方法将被运行之前的任何测试方法属于内部类的 <test>标签的运行。
     */
    @BeforeTest
    public void beforeClass(){
        System.out.println("执行测试前执行");
    }
    @BeforeMethod
    public void  beforeMethod(){
        System.out.println("执行测试方法前执行");
    }
    /**
     * 标记一个类或方法作为测试的一部分。
     */
    @Test
    public  void TestNGDo(){
        System.out.println("执行测试");

    }
    @Test
    public  void  TestNGDo1(){
        System.out.println("执行测试1");
    }
    /**
     * 注解的方法将被运行后，所有的测试方法，属于内部类的<test>标签的运行。
     */
    @AfterClass
    public  void  afterClass(){
        System.out.println("执行测试后执行");
    }

}
