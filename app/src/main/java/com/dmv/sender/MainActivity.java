package com.dmv.sender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn_change1, btn_change2, btn_nosend, btn_send;
    TextView text_screen1;
    String Tag = "test";
    String setText1, setText2;
    static byte minPair = 1, maxPair = 99;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btn_change1 = findViewById(R.id.btn1);
        btn_change2 = findViewById(R.id.btn2);
        btn_nosend = findViewById(R.id.btn_nosend);
        btn_send = findViewById(R.id.btn_sender);
        text_screen1 = findViewById(R.id.text_screen1);

        //Messages
        Calendar calendar = Calendar.getInstance();

        setText1 = "Today is " + calendar.get(Calendar.YEAR ) +" "+ calendar.get(Calendar.MONTH)+ " " + calendar.get(Calendar.DAY_OF_MONTH);
        setText2 = "I lived in Prypiat";

        //------------ Listeners --------------//
        btn_change1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_screen1.setText(setText1);
            }
        });
        btn_change2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_screen1.setText(setText2);
            }
        });
        btn_nosend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, pantallados.class);
                startActivity(i);
            }
        });
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, pantallados.class);
                i.putExtra("labelText", text_screen1.getText().toString());
                i.putExtra("verification", getVerificationNumber());
                startActivity(i);
            }
        });

    }

    private HashMap<Byte, Byte> getVerificationNumber() {
        HashMap<Byte, Byte> pairs = new HashMap<>();
        byte correctPos = getRandomNumber(0, 2);
        for (byte i = 0; i < 3; i++){
            byte key = (i == correctPos) ? 10 : i;
            pairs.put(key, getRandomNumber(minPair, maxPair));
        }
        return pairs;
    }

    private static byte getRandomNumber(int min, int max){
        Random rnd = new Random();
        return (byte) (rnd.nextInt(max - min + 1) + min);
    }
}