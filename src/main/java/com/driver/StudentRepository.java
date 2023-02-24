package com.driver;

import org.springframework.stereotype.Repository;

import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {

    HashMap<String, Student> Studentmap;
    HashMap<String, Teacher> Teachermap;
    HashMap<String, List<String>> StudentTeacherMap;

    StudentRepository(){
        Studentmap = new HashMap<String, Student>();
        Teachermap = new HashMap<String, Teacher>();
        StudentTeacherMap = new HashMap<String, List<String>>();
    }

    public void addStudent(Student student){
        Studentmap.put(student.getName(), student);
    }

    public void addTeacher(Teacher teacher){
        Teachermap.put(teacher.getName(), teacher);
    }

    public void addTeacherStudentPair(String student_name, String teacher_name){
        if(Studentmap.containsKey(student_name) && Teachermap.containsKey(teacher_name)){
            Studentmap.put(student_name, Studentmap.get(student_name));
            Teachermap.put(teacher_name, Teachermap.get(teacher_name));
            List<String> curr = new ArrayList<>();
            if(StudentTeacherMap.containsKey(teacher_name)){
                curr = StudentTeacherMap.get(teacher_name);
            }
            curr.add(student_name);
            StudentTeacherMap.put(teacher_name, curr);
        }
    }

    public Student getstudent(String student_name){
        return Studentmap.get(student_name);
    }

    public Teacher getteacher(String teacher_name){
        return Teachermap.get(teacher_name);
    }

    public List<String> getListOfStudentsForTeacher(String teacher_name){
        return StudentTeacherMap.get(teacher_name);
    }

    public List<String> getAllStudents(){
        return new ArrayList<>(Studentmap.keySet());
    }

    public void DeleteTeacher(String teacher_name){
        List<String> students = new ArrayList<>();
        if(StudentTeacherMap.containsKey(teacher_name)){
            students = StudentTeacherMap.get(teacher_name);
            for(String s : students){
                Studentmap.remove(s);
            }
        }
        StudentTeacherMap.remove(teacher_name);
        Teachermap.remove(teacher_name);
    }

    public void DeleteAllTeacherAndTheirStudents(){
        for(Map.Entry<String, Teacher> name : Teachermap.entrySet()){
            DeleteTeacher(name.getKey());
        }
        Teachermap.clear();
        StudentTeacherMap.clear();
    }
}
