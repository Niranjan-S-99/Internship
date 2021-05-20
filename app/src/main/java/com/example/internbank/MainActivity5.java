package com.example.internbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hanks.passcodeview.PasscodeView;

public class MainActivity5 extends AppCompatActivity {
    PasscodeView passcodeView;
    EditText editText;
    Button button;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        passcodeView = findViewById(R.id.passcode);
        passcodeView.setPasscodeLength(4)
                .setLocalPasscode("1234")
                .setListener(new PasscodeView.PasscodeViewListener() {
                    @Override
                    public void onFail() {
                        Toast.makeText(getApplicationContext(),"Password is Wrong",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String number) {
                        Toast.makeText(getApplicationContext(),"Password is Correct",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity5.this,MainActivity3.class);
                        startActivity(intent);
                    }
                });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MainActivity5.this,MainActivity2.class);
        startActivity(intent);
    }
}