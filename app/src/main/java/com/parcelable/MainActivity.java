package com.parcelable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnNext;
    private EditText etName;
    private EditText etTechnology;
    private EditText etExperience;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNext = (Button) findViewById(R.id.btn_send);
        etName = (EditText) findViewById(R.id.et_name);
        etTechnology = (EditText) findViewById(R.id.et_technology);
        etExperience = (EditText) findViewById(R.id.et_experience);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isValidInput()) {
                    Employee emp = getData();
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    // passing the object into the next screen, remember student has implement parcelable.
                    intent.putExtra("Employee", emp);
                    startActivity(intent);
                }
            }
        });

    }

    private boolean isValidInput() {
        boolean isValid = true;
        if (etName.getText().length() == 0) {
            Toast.makeText(this, "Enter Name!!", Toast.LENGTH_SHORT).show();
            isValid = false;
        } else if (etTechnology.getText().length() == 0) {
            Toast.makeText(this, "Enter Technology!!", Toast.LENGTH_SHORT).show();
            isValid = false;
        } else if (etExperience.getText().length() == 0) {
            Toast.makeText(this, "Enter Experience!!", Toast.LENGTH_SHORT).show();
            isValid = false;
        }
        return isValid;
    }
    // returning student object
    private Employee getData() {
        Employee employee = new Employee();
        String name = etName.getText().toString();
        String technology = etTechnology.getText().toString();
        int experience = Integer.parseInt(etExperience.getText().toString());
        employee.setEmployeeName(name);
        employee.setEmployeeTechnology(technology);
        employee.setExperience(experience);

        return employee;

    }
}
