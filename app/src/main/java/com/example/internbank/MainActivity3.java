package com.example.internbank;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity3 extends AppCompatActivity {

    Intent intent;
    EditText SendValue;
    TextView textView;
    private static final String TAG = "MainActivity3";

    Databasehelper mDatabaseHelper;
     TextView transaction;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mDatabaseHelper = new Databasehelper(this);
        SendValue = (EditText) findViewById(R.id.money_editText);



        ImageView imageView = findViewById(R.id.imageView2);
        imageView.setImageResource(R.drawable.transaction_hand);
        AnimationDrawable transaction_hand = (AnimationDrawable) imageView.getDrawable();
        transaction_hand.start();


        textView = (TextView) findViewById(R.id.pay);
        SendValue = (EditText) findViewById(R.id.money_editText);

        textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ImageView imageeview = findViewById(R.id.animation_arrow);
                imageeview.setImageResource(R.drawable.arrowani);
                AnimationDrawable arrowani = (AnimationDrawable) imageeview.getDrawable();
                arrowani.start();

                textView.setText("Please Wait...");
                Toast.makeText(getApplicationContext(),"Transaction is ongoing", Toast.LENGTH_LONG).show();
                ProgressBar progressBar = findViewById(R.id.fg);
                progressBar.setVisibility(View.VISIBLE);
                new Handler(Looper.myLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        textView.setText("Transaction Completed.");
                        progressBar.setVisibility(View.INVISIBLE);
                        textView.setBackgroundColor(getColor(R.color.green));
                        Toast.makeText(getApplicationContext(),"Transaction History saved!",Toast.LENGTH_SHORT).show();


                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                intent = new Intent(getApplicationContext(), MainActivity4.class);
                                intent.putExtra("EdiTtEXTvALUE", SendValue.getText().toString());
                                startActivity(intent);

                                String newEntry = SendValue.getText().toString();
                                if (SendValue.length() != 0) {
                                    AddData(newEntry);
                                    SendValue.setText("");
                                } else {
                                    toastMessage("You must put something in the text field!");
                                }
                            }
                        },3000);

                    }
                },10000);

            }

        });

    }


    public void AddData(String newEntry) {
        boolean insertData = mDatabaseHelper.addData(newEntry);

        if (insertData) {
            toastMessage("Amount Sended Safely");
        } else {
            toastMessage("Something went wrong");
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }




    @Override
    public void onBackPressed() {
       intent = new Intent(getApplicationContext(),MainActivity2.class);
       startActivity(intent);
    }

    public void arr(View v) {
        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);

    }
}




