package com.example.k;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    TextView textView;
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
        textView = findViewById(R.id.textView);
        MyTask mt = new MyTask();
        mt.execute();


    }

    public void onClick1(View view) {
        edTxtDouble = Double.parseDouble(editText1.getText().toString());
        if (radioButton1.isChecked()) Toast.makeText(this, Double.toString(edTxtDouble*dollar), Toast.LENGTH_LONG).show();
        if (radioButton2.isChecked()) Toast.makeText(this, Double.toString(edTxtDouble*euro), Toast.LENGTH_LONG).show();

    }

class MyTask extends AsyncTask<Void, Void, Void> {
    String s = "";
    @Override
    protected Void doInBackground(Void... voids) {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.facebook.com").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (doc!=null)
            s = doc.title();
        else
            s = "Ошибка";

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        textView.setText(s);
    }
}

}
