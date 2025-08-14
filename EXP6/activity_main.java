package com.example.exp6;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName, etEmail, etPassword;
    RadioButton male, female;
    CheckBox terms;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextText3);
        etEmail = findViewById(R.id.editTextText4);
        etPassword = findViewById(R.id.editTextTextPassword);
        male = findViewById(R.id.radioButton);
        female = findViewById(R.id.radioButton2);
        terms = findViewById(R.id.checkBox);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateForm();
            }
        });
    }

    private void validateForm() {
        // Name check
        if (TextUtils.isEmpty(etName.getText().toString())) {
            etName.setError("Name is required");
            return;
        }

        // Email check
        if (!Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString()).matches()) {
            etEmail.setError("Enter a valid email");
            return;
        }

        // Password check
        if (etPassword.getText().toString().length() < 8) {
            etPassword.setError("Password must be at least 8 characters");
            return;
        }

        // Gender check
        if (!male.isChecked() && !female.isChecked()) {
            Toast.makeText(this, "Select your gender", Toast.LENGTH_SHORT).show();
            return;
        }

        // Terms check
        if (!terms.isChecked()) {
            Toast.makeText(this, "Please accept terms and conditions", Toast.LENGTH_SHORT).show();
            return;
        }

        // Success
        Toast.makeText(this, "Form submitted", Toast.LENGTH_LONG).show();
    }
}

