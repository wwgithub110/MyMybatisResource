package com.mytest;

import com.mytest.mapper.UserMapper;
import com.mytest.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyTest {

  public static void main(String[] args) throws IOException {
    //读取配置文件
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    //创建SqlSessionFactory (创建 xml 解析器, 解析配置文件, 以及 mapper.xml文件)
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    //创建session (里面会根据 executorType 获取对应的执行器 BatchExecutor, ReuseExecutor, SimpleExecutor, CachingExecutor 并放到interceptorChain中)
    SqlSession session = sqlSessionFactory.openSession();
    //查询数据
    //方式一
    //User user = (User) session.selectOne("com.mytest.mapper.UserMapper.selectUser", 1);

    //方式二, 动态代理
    UserMapper mapper = session.getMapper(UserMapper.class);
    User user = mapper.selectUser(1);
    System.out.println(user.toString());

    //释放资源
    session.close();
    inputStream.close();
  }
}
