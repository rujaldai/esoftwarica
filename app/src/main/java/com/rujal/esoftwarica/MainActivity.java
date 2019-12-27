package com.rujal.esoftwarica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.rujal.esoftwarica.fragments.add_students.AddStudentFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements StudentEditListener {

    public static List<Student> students = new ArrayList<>();
    private int selectedStudentPositionForEdit = 0;


    public int getSelectedStudentPositionForEdit() {
        return selectedStudentPositionForEdit;
    }

    public void setSelectedStudentPositionForEdit(int selectedStudentPositionForEdit) {
        this.selectedStudentPositionForEdit = selectedStudentPositionForEdit;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navHome, R.id.navDashboard, R.id.navAbout)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

    }

    @Override
    public void editStudent(int position) {

        setSelectedStudentPositionForEdit(position);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        AddStudentFragment addStudentFragment = new AddStudentFragment();
        fragmentTransaction.replace(R.id.navHostFragment, addStudentFragment);
        fragmentTransaction.commit();
    }
}
