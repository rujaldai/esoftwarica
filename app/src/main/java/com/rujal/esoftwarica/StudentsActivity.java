package com.rujal.esoftwarica;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class StudentsActivity extends RecyclerView.Adapter<StudentsActivity.StudentViewHolder> {

    Context mContext;
    List<Student> studentList;

    public StudentsActivity(Context mContext, List<Student> studentList) {
        this.mContext = mContext;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_students, parent, false);
        return new StudentViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder studentViewHolder, final int position) {
        Student student = studentList.get(position);
        studentViewHolder.tvName.setText(student.getName());
        studentViewHolder.tvAddress.setText(student.getAddress());
        studentViewHolder.tvGender.setText(student.getGender());
        studentViewHolder.tvAge.setText(String.valueOf(student.getAge()));


        studentViewHolder.imgRemove.setImageDrawable(mContext.getResources().getDrawable(R.drawable.delete));
        String gender = student.getGender();
        if (gender.equalsIgnoreCase("male")) {
            studentViewHolder.imgProfile.setImageResource(R.drawable.male);
        } else if (gender.equalsIgnoreCase("female")) {
            studentViewHolder.imgProfile.setImageResource(R.drawable.female);
        } else {
            studentViewHolder.imgProfile.setImageDrawable(mContext.getResources().getDrawable(R.drawable.female));
        }

        studentViewHolder.imgProfile.setOnClickListener( i -> Toast.makeText(mContext, "Hi!" + student.getName(), Toast.LENGTH_SHORT).show());

        studentViewHolder.imgRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentList.remove(position);
                notifyItemRemoved(position);
                Toast.makeText(mContext, "Removed:" + student.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }


    public class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvAddress, tvAge, tvGender;
        ImageView imgProfile, imgRemove, imgEdit;

        public StudentViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvGender = itemView.findViewById(R.id.tvgender);
            imgProfile = itemView.findViewById(R.id.imgProfile);
            imgRemove = itemView.findViewById(R.id.imgremove);

        }
    }
}
