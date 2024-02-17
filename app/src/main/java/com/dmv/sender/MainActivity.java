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

    Button btn_change1, btn_send;
    TextView text_screen1, text_info;
    String attempts,Tag = "test", attemptsStr = "Attempts to discover the number: ", textsender = "You haven't randomized the text. This is a default text.";
    String[] keys = new String[3];
    String[] randomizer = {"Avid reader", "Stealth ninja", "Pineaple airplane", "Html is a programing language (brainless)", "I've lived in Prypiat"};
    static byte minPair = 1, maxPair = 99;
    byte randomByte, correctPos;
    Random rand = new Random();
    //--------Life loop methods--------//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onStart() {
        super.onStart();
        //----------"""DOM"""---------//
        btn_change1 = findViewById(R.id.btn1);
        btn_send = findViewById(R.id.btn_sender);
        text_screen1 = findViewById(R.id.text_screen1);
        text_info = findViewById(R.id.text_info);

        //--Tries to get the attempts string provided by screen 2 and change the info text.---//
        try{
            attempts = getIntent().getStringExtra("attempts");
            text_info.setText(attemptsStr.concat(attempts));
        } catch (Exception e){}

        //------------ Listeners --------------//
        //Randomizer
        btn_change1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomElement = rand.nextInt(randomizer.length);
                textsender = randomizer[randomElement];
                text_screen1.setText(textsender);
            }
        });
        //Generator & sender
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
    /***
     * Gets a dictionary with 3 random keys between 1 - 99 and 3 boolean values,
     * where 2 booleans always be false and the remaining boolean always be true.
     * The numbers keys will be displayed in the 2nd screen buttons and the booleans
     * will check the user clicks. The program will mark bad if you tap a number that
     * their value is false and will mark as correct when you tap the 'true' number.
     * @return HashMap
     */
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
    /***
     * Gets a random number in a range.
     * This function has been limited returning a byte due to the program doesn't need a higher number
     * @param min minor number (included)
     * @param max major number (included)
     * @return byte
     */
    private static byte getRandomNumber(int min, int max){
        Random rnd = new Random();
        return (byte) (rnd.nextInt(max - min + 1) + min);
    }
}

