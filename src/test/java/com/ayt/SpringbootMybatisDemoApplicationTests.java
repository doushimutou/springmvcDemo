package com.ayt;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ayt.mapper.city.CityMapper;
import com.ayt.model.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisDemoApplicationTests {

    @Autowired
    CityMapper cityMapper;


    @Test
	public void contextLoads() {
        String id="1";
        City city= cityMapper.findById(id);
        //实体类或集合转JSON串
        String jsonString = JSONObject.toJSONString(city);
        System.out.println(jsonString);
        //JSON串转JSONObject
        JSONObject jsonObject =JSONObject.parseObject(jsonString);
        System.out.println(jsonObject);
        //3.JSON串转实体类
        City city1= JSON.parseObject(jsonString,City.class);

        //JSON串转带泛型的List的集合
        List<City> list =JSON.parseObject(jsonString, new TypeReference<List<City>> (){});



        System.out.println(city.getCityName());


    }

}
