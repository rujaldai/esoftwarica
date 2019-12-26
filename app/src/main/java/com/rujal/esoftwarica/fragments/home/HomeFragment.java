package com.rujal.esoftwarica.fragments.home;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rujal.esoftwarica.MainActivity;
import com.rujal.esoftwarica.R;
import com.rujal.esoftwarica.Student;
import com.rujal.esoftwarica.StudentsActivity;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private HomeModel homeModel;
    private RecyclerView recyclerView;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        homeModel = ViewModelProviders.of(this).get(HomeModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        TextView textView = view.findViewById(R.id.tvHome);
        homeModel.getText().observe(this, textView::setText);

        recyclerView = view.findViewById(R.id.recyclerView);
        List<Student> students = MainActivity.students;

        if (students.isEmpty()) {
            students.add(new Student("Rujal", "Kathmandu", "Male", 25));
        }

        StudentsActivity studentsActivity = new StudentsActivity(getContext(), students);
        recyclerView.setAdapter(studentsActivity);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}


