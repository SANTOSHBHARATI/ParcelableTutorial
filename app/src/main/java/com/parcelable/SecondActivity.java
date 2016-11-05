package com.parcelable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private TextView tvName;
    private TextView tvTechnology;
    private TextView tvExperience;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvName = (TextView) findViewById(R.id.textViewName);
        tvTechnology = (TextView) findViewById(R.id.textViewAddress);
        tvExperience = (TextView) findViewById(R.id.textViewRollNumber);

        Employee employee = getIntent().getParcelableExtra("Employee");

        if (employee != null) {
            tvName.setText(employee.getEmployeeName());
            tvTechnology.setText(employee.getEmployeeTechnology());
            tvExperience.setText(employee.getExperience()+" Years");
        } else {
            Toast.makeText(getBaseContext(), "Sorry", Toast.LENGTH_SHORT).show();
        }
    }
}
