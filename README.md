自己使用mybatis源码分析

调试入口测试类 MyTest, 数据库需要创建对应的user表, 更改mybatis-config.xml

总体架构

![image-20220531101830133](C:\Users\DELL\AppData\Roaming\Typora\typora-user-images\image-20220531101830133.png)

获取sqlSession流程

![image-20220531101940478](C:\Users\DELL\AppData\Roaming\Typora\typora-user-images\image-20220531101940478.png)

sql执行流程

![image-20220531102034605](C:\Users\DELL\AppData\Roaming\Typora\typora-user-images\image-20220531102034605.png)

执行器

![image-20220531102212303](C:\Users\DELL\AppData\Roaming\Typora\typora-user-images\image-20220531102212303.png)

![image-20220531102225668](C:\Users\DELL\AppData\Roaming\Typora\typora-user-images\image-20220531102225668.png)

涉及的涉及模式:

门面模式: sqlSession 统一对外的接口

代理模式: 测试代码中的方式二

工厂模式: 各种factory