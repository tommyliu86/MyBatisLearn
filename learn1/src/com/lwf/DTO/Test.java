package com.lwf.DTO;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
 import org.apache.ibatis.session.SqlSessionFactory;
 import org.apache.ibatis.session.SqlSessionFactoryBuilder;

 import java.io.IOException;
 import java.io.Reader;

 /**
 * @author lwf
 * @date 2019/6/10-10:20
 */
public class Test {
    public static void main(String[] args) throws IOException {
        test1();
    }

    private static void test1() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();
        Student student = sqlSession.selectOne("com.lwf.DTO.studentMapper.queryStudentById", 1);
        System.out.println(student.toString());
        sqlSession.close();
    }
}
