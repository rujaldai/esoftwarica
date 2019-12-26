package com.rujal.esoftwarica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private Button btnlogin;
    private final String USERNAME = "softwarica";
    private final String PASSWORD = "coventry";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnlogin = findViewById(R.id.btnLogin);

        btnlogin.setOnClickListener(this::login);
    }

    private void login(View view) {
        if (etUsername.getText().toString().equalsIgnoreCase(USERNAME) && etPassword.getText().toString().equals(PASSWORD)) {
            Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
            etUsername.setText("");
            etPassword.setText("");
        }
    }
}
