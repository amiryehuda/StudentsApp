package com.example.studentsappnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.studentsappnew.model.Model;
import com.example.studentsappnew.model.Student;

import java.util.List;

public class studentDetails extends AppCompatActivity {


    TextView studentName;
    TextView studentAddress;
    TextView studentId;
    TextView studentPhone;
    CheckBox isChecked;
    Button editStudentBtn;

    Student student;

    int pos;


    @Override
    protected void onResume() {
        super.onResume();
        studentName.setText(Model.instance.getAllStudents().get(pos).getName());
        studentAddress.setText(Model.instance.getAllStudents().get(pos).getAddress());
        studentId.setText(Model.instance.getAllStudents().get(pos).getId());
        studentPhone.setText(Model.instance.getAllStudents().get(pos).getPhone());
        isChecked.setChecked(Model.instance.getAllStudents().get(pos).isChecked());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);


        student = (Student) getIntent().getSerializableExtra("student");
        pos = getIntent().getExtras().getInt("position");



        studentName = findViewById(R.id.studentNameDetails_tv);
        studentAddress = findViewById(R.id.studentAddressDetails_tv);
        studentId = findViewById(R.id.studentIdDetails_tv);
        studentPhone = findViewById(R.id.studentPhoneDetails_tv);
        isChecked = findViewById(R.id.studentCheckedDetails_cb);
        editStudentBtn = findViewById(R.id.studentDetailEdit_btn);


        studentName.setText(student.getName());
        studentAddress.setText(student.getAddress());
        studentId.setText(student.getId());
        studentPhone.setText(student.getPhone());
        isChecked.setChecked(student.isChecked());

        editStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),EditStudentActivity.class);
                i.putExtra("student", student);
                i.putExtra("position",pos);
                startActivity(i);
                Log.d("TAG","edit clicked");
            }
        });

    }
}