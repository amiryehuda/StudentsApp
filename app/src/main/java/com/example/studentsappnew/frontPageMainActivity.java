package com.example.studentsappnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studentsappnew.model.Model;
import com.example.studentsappnew.model.Student;

import java.util.List;

public class frontPageMainActivity extends AppCompatActivity {
    List<Student> data;
    RecyclerView studentsList;

    Button addStudentBtn;

    MyAdapter adapter = new MyAdapter(data);

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page_main);
        this.setTitle("Students list");

        data = Model.instance.getAllStudents();

        studentsList = findViewById(R.id.main_studentsList_rv);
        studentsList.setHasFixedSize(true);
        studentsList.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MyAdapter(data);
        studentsList.setAdapter(adapter);

        addStudentBtn = findViewById(R.id.main_addStudent_btn);

        addStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(frontPageMainActivity.this, MainActivity.class));
            }
        });


    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView listrowNameTv;
        TextView listrowIdTv;
        ImageView listrowAvatar;
        CheckBox listrowCheckBox;
        String data;

        public MyViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            listrowNameTv = itemView.findViewById(R.id.listrow_name_tv);
            listrowIdTv = itemView.findViewById(R.id.listrow_ID_tv);
            listrowCheckBox = itemView.findViewById(R.id.listrow_cb);
            listrowAvatar = itemView.findViewById(R.id.listrow_avatar_iv);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    Student s = adapter.mData.get(position);
                    Intent i = new Intent(getApplicationContext(),studentDetails.class);
                    i.putExtra("student", s);
                    i.putExtra("position", position);

                    startActivity(i);
                    //listener.onClick(position);
                }
            });


        }
    }


    interface OnItemClickListener {
        void onClick(int position);
    }


    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        public List<Student> mData = data;
        OnItemClickListener mListener;

        public void setmListener(OnItemClickListener listener) {
            this.mListener = listener;
        }

        public MyAdapter(List<Student> data) {
            mData = data;
        }


        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.student_list_row, parent, false);
            MyViewHolder holder = new MyViewHolder(view, mListener);
            return holder;
        }


        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            Student student = data.get(position);
            holder.listrowIdTv.setText(student.getId());
            holder.listrowNameTv.setText(student.getName());
            holder.listrowCheckBox.setChecked(student.isChecked());
            holder.itemView.setTag(position);
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }


    }


}