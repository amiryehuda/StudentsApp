package com.example.studentsappnew;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.studentsappnew.model.Model;
import com.example.studentsappnew.model.Student;

import java.util.List;

public class EditStudentActivity extends AppCompatActivity {

    EditText editName;
    EditText editID;
    EditText editAddress;
    EditText editPhone;
    CheckBox editCB;

    Button cancelBtn;
    Button deleteBtn;
    Button saveBtn;

    Student student;

    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        student = (Student) getIntent().getSerializableExtra("student");
        pos = getIntent().getExtras().getInt("position");


        editName = findViewById(R.id.editStudentName_pt);
        editID = findViewById(R.id.editStudentID_pt);
        editAddress = findViewById(R.id.editStudentAddress_pt);
        editPhone = findViewById(R.id.editStudentPhone_pt);
        editCB = findViewById(R.id.editStudentCB);
        saveBtn = findViewById(R.id.editStudentSave_btn);
        cancelBtn = findViewById(R.id.editStudentCancel_btn);
        deleteBtn = findViewById(R.id.editStudentDelete_btn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
                finish();
            }
        });

        editName.setText(Model.instance.getAllStudents().get(pos).getName());
        editID.setText(Model.instance.getAllStudents().get(pos).getId());
        editAddress.setText(Model.instance.getAllStudents().get(pos).getAddress());
        editPhone.setText(Model.instance.getAllStudents().get(pos).getPhone());
        editCB.setChecked(Model.instance.getAllStudents().get(pos).isChecked());

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Model.instance.getAllStudents().remove(pos);
                Intent intent = new Intent(getApplicationContext(), frontPageMainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    public void save() {
        String studentName = editName.getText().toString();
        String studentID = editID.getText().toString();
        String studentPhone = editPhone.getText().toString();
        String studentAddress = editAddress.getText().toString();
        boolean studentIsChecked = editCB.isChecked();
        Model.instance.getAllStudents().get(pos).setName(studentName);
        Model.instance.getAllStudents().get(pos).setId(studentID);
        Model.instance.getAllStudents().get(pos).setPhone(studentPhone);
        Model.instance.getAllStudents().get(pos).setAddress(studentAddress);
        Model.instance.getAllStudents().get(pos).setChecked(studentIsChecked);
//        Log.d("TAG",Model.instance.getAllStudents().get(pos).getName());
    }

}