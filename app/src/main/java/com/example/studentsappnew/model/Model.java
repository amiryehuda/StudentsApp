package com.example.studentsappnew.model;

import android.util.Log;

import java.util.LinkedList;
import java.util.List;

public class Model {

    public static final Model instance = new Model();

    List<Student> studentsList = new LinkedList<Student>();

    public List<Student> getAllStudents(){
        return studentsList;
    }



    public void addStudent(Student student)
    {
        studentsList.add(student);
        Log.d("TAG","student added");

    }

    public boolean isExists(String studentID)
    {
        for (Student s:getAllStudents()){
            if (s.getId().equals(studentID))
                Log.d("TAG","Student already exists");
                return true;
        }
        return false;
    }














}
