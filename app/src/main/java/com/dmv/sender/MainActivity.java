package com.dmv.sender;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn_change1, btn_change2, btn_nosend, btn_send;
    TextView text_screen1;
    String Tag = "test";
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

        //------------ Listeners --------------//


    }


    private HashMap<Boolean, Byte> getVerificationNumber() {
        HashMap<Boolean, Byte> pairs = new HashMap<>();
        byte truePos = getRandomNumber(0, 2);
        for (byte i = 0; i < 3; i++){
            boolean key = (i == truePos) ? true : false;
            pairs.put(key, getRandomNumber(minPair, maxPair));
        }

        return pairs;
    }

    private static byte getRandomNumber(int min, int max){
        Random rnd = new Random();
        return (byte) (rnd.nextInt(max - min + 1) + min);
    }
}