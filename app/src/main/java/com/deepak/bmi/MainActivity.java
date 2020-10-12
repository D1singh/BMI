package com.deepak.bmi;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView Male, Female;
    EditText WeightInKg, HeightInInches;
    TextView ShowResult;
    Button CalculateBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        Spinner spinner = findViewById(R.id.Spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Male.setVisibility(View.GONE);
                    Female.setVisibility(View.GONE);
                } else if (position == 1) {
                    Male.setVisibility(View.VISIBLE);
                    Female.setVisibility(View.GONE);
                } else {
                    Female.setVisibility(View.VISIBLE);
                    Male.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initView() {
        Male = findViewById(R.id.Male);
        Female = findViewById(R.id.Female);
        WeightInKg = findViewById(R.id.WeightInKg);
        HeightInInches = findViewById(R.id.HeightInInches);
        CalculateBMI = findViewById(R.id.CalculateBMI);
        ShowResult  = findViewById(R.id.ShowResult);

        CalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              CalculatedBMIResult();

            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void CalculatedBMIResult() {
        double wt = Double.parseDouble(String.valueOf(WeightInKg.getText()));
        double ht = Double.parseDouble(String.valueOf(HeightInInches.getText()));
        double result = (wt/(ht*ht));
        ShowResult.setText((float) result +" kg/m2");
    }

}