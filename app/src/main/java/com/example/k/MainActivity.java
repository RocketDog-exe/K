package com.example.k;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    RadioButton radioButton1, radioButton2;
    double edTxtDouble;
    final double dollar=27.00;
    final double euro=30.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        editText1 = findViewById(R.id.editText1);
        edTxtDouble = Double.parseDouble(editText1.getText().toString());

    }

    public void onClick1(View view) {
        if (radioButton1.isChecked()) Toast.makeText(this, Double.toString(edTxtDouble*dollar), Toast.LENGTH_LONG).show();
        if (radioButton2.isChecked()) Toast.makeText(this, Double.toString(edTxtDouble*euro), Toast.LENGTH_LONG).show();

    }
}
