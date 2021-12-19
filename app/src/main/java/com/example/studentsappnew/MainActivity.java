// creating new student!!!!


package com.example.studentsappnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.studentsappnew.model.Model;
import com.example.studentsappnew.model.Student;

public class MainActivity extends AppCompatActivity {

    EditText studentNameInput;
    EditText studentIDInput;
    EditText studentPhoneInput;
    EditText studentAddressInput;
    CheckBox studentIsCheckedBtn;
    Button saveBtn;
    Button cancelBtn;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Add a new student");


         studentNameInput = findViewById(R.id.studentNameInput_pt);
         studentIDInput = findViewById(R.id.studentIDInput_pt);
         studentPhoneInput = findViewById(R.id.studentPhoneInput_pt);
         studentAddressInput = findViewById(R.id.studentAddressInput_pt);
         studentIsCheckedBtn = findViewById(R.id.studentIsChecked_cb);
         saveBtn = findViewById(R.id.addStudent_saveButton_btn);
         cancelBtn = findViewById(R.id.addStudent_cancelButton_btn);


         saveBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 save();
                 finish();
             }
         });

         cancelBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                finish();
             }
         });

    }

    private void save(){
        String studentName = studentNameInput.getText().toString();
        String studentID = studentIDInput.getText().toString();
        String studentPhone = studentPhoneInput.getText().toString();
        String studentAddress = studentAddressInput.getText().toString();
        boolean studentIsChecked = studentIsCheckedBtn.isChecked();
        Log.d("TAG","save pressed");
        Log.d("TAG","creating new student");
        Student s = new Student(studentName,studentID,studentAddress,studentPhone,studentIsChecked);
        Model.instance.addStudent(s);
        Log.d("TAG","Student created");
        Log.d("TAG","name: "+ studentName);

    }



}