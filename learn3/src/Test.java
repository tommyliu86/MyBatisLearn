import com.lwf.Dao.studentMapper;
import com.lwf.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.type.JdbcType;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @author lwf
 * @date 2019/6/11-10:00
 */
public class Test {
    public static void main(String[] args) throws IOException {
//        test1();
//        testupdate();
//        testInsert();
//        testtypeHandler();
        testupdateTypeHandler();
        testGetAll();

    }

    private static void testGetAll() throws IOException {
        SqlSession sqlSession = factory().openSession();
        studentMapper mapper = sqlSession.getMapper(studentMapper.class);
        List<Student> students = mapper.queryStudentAll();
        for (Student s : students
        ) {
            System.out.println(s.toString());
        }
        sqlSession.close();

    }

    private static void testupdateTypeHandler() throws IOException {
        SqlSession sqlSession = factory().openSession();
        studentMapper mapper = sqlSession.getMapper(studentMapper.class);
        Student student = new Student();
        student.setId(1);
        student.setSex(true);

        int i = mapper.updateStudentSex(student);
        sqlSession.commit();
        System.out.println(student.toString());
        System.out.println(i);
        sqlSession.close();

    }

    private static void testtypeHandler() throws IOException {
        SqlSession sqlSession = factory().openSession();
        studentMapper mapper = sqlSession.getMapper(studentMapper.class);
        Student student = mapper.queryStudentByIdWithTH(7);

        System.out.println(student.toString());
        sqlSession.close();

    }

    private static void testInsert() throws IOException {
        SqlSession sqlSession = factory().openSession();
        studentMapper mapper = sqlSession.getMapper(studentMapper.class);
        Student student = new Student(0, "ww55", 21);
        int ww5 = mapper.insertStudent(student);
        sqlSession.commit();
        System.out.println(ww5);
        System.out.println(student.toString());
        sqlSession.close();

    }

    private static void test1() throws IOException {

        SqlSession sqlSession = factory().openSession();
        studentMapper mapper = sqlSession.getMapper(studentMapper.class);
        Student student = mapper.queryStudentById(1);
        System.out.println(student.toString());
        sqlSession.close();

    }

    private static void testupdate() throws IOException {
        SqlSession sqlSession = factory().openSession();
        studentMapper mapper = sqlSession.getMapper(studentMapper.class);
        int zs111 = mapper.updateStudent(new Student(1, "zs111", 50));
        sqlSession.commit();
        System.out.println(zs111);
        sqlSession.close();
    }

    private static SqlSessionFactory sqlSessionFactory;

    private static SqlSessionFactory factory() throws IOException {
        if (null == sqlSessionFactory) {
            Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);


        }
        return sqlSessionFactory;

    }
}
