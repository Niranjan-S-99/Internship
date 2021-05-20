package com.example.internbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Random;

public class MainActivity4 extends AppCompatActivity {

    TextView receiver;
    Calendar calendar;
    private static final String TAG = "MainActivity4";

    Databasehelper mDatabaseHelper;
    TextView viewhistroy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        viewhistroy = findViewById(R.id.transaction_historybutton);
        mDatabaseHelper = new Databasehelper(this);

        viewhistroy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this, ListDataActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Moving Transaction Details",Toast.LENGTH_SHORT).show();
            }
        });





        receiver = findViewById(R.id.textView1);
        receiver.setText(getIntent().getStringExtra("EdiTtEXTvALUE"));

        calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM hh:mm a");
        String datetime = dateFormat.format(calendar.getTime());
        TextView textView = findViewById(R.id.completed);
        textView.setText(datetime);


        class RandomString {
            String Letter = "abcdefghijklmnopqrstuv";
            String Numb = "123456789";
            char[] alphanumb = (Letter + Letter.toUpperCase() + Numb).toCharArray();

            String generator(int length) {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < length; i++) {
                    result.append(alphanumb[new Random().nextInt(alphanumb.length)]);

                }
                return result.toString();
            }

        }
        TextView tex = findViewById(R.id.transaction);

            RandomString rand = new RandomString();
            String result= rand.generator(13);
            tex.setText(result);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MainActivity4.this,MainActivity3.class);
        startActivity(intent);
    }

    public  void transaction_histroy(View view){
        Intent i = new Intent(MainActivity4.this,MainActivity6.class);
        startActivity(i);
    }
}