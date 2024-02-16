package com.dmv.sender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_change1, btn_nosend, btn_send;
    TextView text_screen1;
    String Tag = "test";
    String setText1, textsender;
    static byte minPair = 1, maxPair = 99;
    byte randomByte, correctPos;
    String[] keys = new String[3];
    String[] randomizer = {"Avid reader", "Stealth ninja", "Pineaple airplane", "Html is a programing language (brainless)", "I've lived in Prypiat"};
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btn_change1 = findViewById(R.id.btn1);
        btn_send = findViewById(R.id.btn_sender);
        text_screen1 = findViewById(R.id.text_screen1);

        //------------ Listeners --------------//
        btn_change1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomElement = rand.nextInt(randomizer.length);
                textsender = randomizer[randomElement];
                text_screen1.setText(textsender);
            }
        });
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, pantallados.class);
                i.putExtra("text", textsender);
                i.putExtra("verification", getVerificationNumber());
                i.putExtra("keys", keys);
                startActivity(i);
            }
        });

    }
    private HashMap<Byte, Boolean> getVerificationNumber() {
        HashMap<Byte, Boolean> pairs = new HashMap<>();
        correctPos = getRandomNumber(0, 2);
        for (byte i = 0; i < 3; i++){
            boolean val = (i == correctPos) ? true : false;
            randomByte = getRandomNumber(minPair, maxPair);
            pairs.put(randomByte, val);
            keys[i] = String.valueOf(randomByte);
        }
        return pairs;
    }
    private static byte getRandomNumber(int min, int max){
        Random rnd = new Random();
        return (byte) (rnd.nextInt(max - min + 1) + min);
    }
}

