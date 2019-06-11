package com.lwf.Dao;

import com.lwf.entity.Student;

import java.util.List;

/**
 * @author lwf
 * @date 2019/6/11-10:03
 */
public interface studentMapper {
    Student queryStudentById(int id);
    int insertStudent(Student student);
    int updateStudent(Student student);
    Student queryStudentByIdWithTH(int id);
    int updateStudentSex(Student student);
    List<Student> queryStudentAll();
}
