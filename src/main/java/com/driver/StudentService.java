package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }

    public void addTeacherStudentPair(String student_name, String teacher_name){
        studentRepository.addTeacherStudentPair(student_name, teacher_name);
    }

    public Student getStudent(String student_name){
        return studentRepository.getstudent(student_name);
    }

    public Teacher getTeacher(String teacher_name){
        return studentRepository.getteacher(teacher_name);
    }

    public List<String> getAllTeacherStudents(String teacher_name){
        return studentRepository.getListOfStudentsForTeacher(teacher_name);
    }

    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    public void deleteTeacherAndStudents(String teacher_name){
        studentRepository.DeleteAllTeacherAndTheirStudents();
    }

    public void deleteAllTeachersAndTheirStudents(){
        studentRepository.DeleteAllTeacherAndTheirStudents();
    }
}
