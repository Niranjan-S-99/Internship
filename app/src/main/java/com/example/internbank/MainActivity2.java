package com.example.internbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;


public class MainActivity2 extends AppCompatActivity {
    ImageButton img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        img = (ImageButton)findViewById(R.id.button1);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity5.class);
                startActivity(intent);
            }});

        ImageView imageView = (ImageView)findViewById(R.id.imageView2);
        imageView.setImageResource(R.drawable.transaction_hand);
        AnimationDrawable transaxtion_hand = (AnimationDrawable) imageView.getDrawable();
        transaxtion_hand.start();




    }
    public void transaction_history (View view){
        Intent i = new Intent(this,ListDataActivity.class);
        startActivity(i);
    }

}


