package com.rujal.esoftwarica.fragments.add_students;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.rujal.esoftwarica.MainActivity;
import com.rujal.esoftwarica.R;
import com.rujal.esoftwarica.Student;


public class AddStudentFragment extends Fragment {

    private AddStudentModel addStudentModel;
    String fullname, address, age, gender;
    EditText etName, etAddress, etAge;
    RadioGroup radioGender;
    Button btnSave;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        addStudentModel = ViewModelProviders.of(this).get(AddStudentModel.class);
        View root = inflater.inflate(R.layout.fragment_add_student, container, false);

        radioGender = root.findViewById(R.id.radioGender);
        etName = root.findViewById(R.id.etName);
        etAge = root.findViewById(R.id.etAge);
        etAddress = root.findViewById(R.id.etAddress);
        btnSave = root.findViewById(R.id.btnSave);

        radioGender.setOnCheckedChangeListener(this::selectGender);
        btnSave.setOnClickListener(this::save);

        TextView textView = root.findViewById(R.id.text_dashboard);
        addStudentModel.getText().observe(this, textView::setText);

        return root;

    }

    private void selectGender(RadioGroup radioGroup, int selectedId) {
        if (selectedId == R.id.radioMale) {
            gender = "male";
        } else if (selectedId == R.id.radioFemale) {
            gender = "female";
        } else {
            gender = "other";
        }

    }

    private void save(View view) {
        if (view.getId() == R.id.btnSave) {
            Toast.makeText(getActivity(), "Save", Toast.LENGTH_SHORT).show();
            fullname = etName.getText().toString();
            age = etAge.getText().toString();
            address = etAddress.getText().toString();

            if (isInputDetailsValid()) {
                MainActivity.students.add(new Student(fullname, address, gender, Integer.parseInt(age)));
                Toast.makeText(getContext(), "Student added", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean isInputDetailsValid() {
        if (etName.getText().toString().isEmpty()) {
            etName.setError("Please, enter full name !");
            etName.requestFocus();
            return false;
        }

        if (etAge.getText().toString().isEmpty()) {
            etAge.setError("Please enter age");
            etAge.requestFocus();
            return false;
        }

        if (etAddress.getText().toString().isEmpty()) {
            etAddress.setError("Please enter address");
            etAddress.requestFocus();
            return false;
        }

        if (gender.isEmpty()) {
            Toast.makeText(getContext(), "Please select gender", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

}

