# Springboot+mybatils+testng
1、这个demo,主要是关于testng的使用
2、使用自定义的listener
    **有两种方式声明listener：**
    一种是添加@Listeners注解到测试条例上，缺点是每个使用自定义listener的测试条例都要添加@Listeners注解，很麻烦。
    另一种是，使用testng.xml配置文件，在其中添加suite标签和listener标签。
  实践：两种同时存在，测试用例会执行两次