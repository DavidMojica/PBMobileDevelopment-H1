package com.dmv.sender;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class pantallados extends AppCompatActivity {
    TextView text_screen2 ,attempts;
    Button touch1, touch2, touch3, return1;
    String labeltext, volatileText;
    String noIntentMsg = "No data sent in Intent";
    String attemptStr = "Attempt: ";
    HashMap<Byte, Boolean> pairs = new HashMap<Byte, Boolean>();
    String[] keys = new String[3];
    Boolean ban = true, reached = false;
    int attemptsInt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantallados);
    }

    @Override
    protected void onStart() {
        super.onStart();

        touch1 = findViewById(R.id.touch1);
        touch2 = findViewById(R.id.touch2);
        touch3 = findViewById(R.id.touch3);
        return1 = findViewById(R.id.return1);
        text_screen2 = findViewById(R.id.text_screen2);
        attempts = findViewById(R.id.attempts);

        try{
            labeltext = getIntent().getStringExtra("text");
            pairs = (HashMap<Byte, Boolean>) getIntent().getSerializableExtra("verification");
            keys = getIntent().getStringArrayExtra("keys");
        } catch (Exception e) {
            ban = false;
        }

        if (ban){
            touch1.setText(keys[0]);
            touch2.setText(keys[1]);
            touch3.setText(keys[2]);

            text_screen2.setText(labeltext);

            touch1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    volatileText = touch1.getText().toString();
                    if(find(keys, volatileText) && pairs.containsKey(Byte.valueOf(volatileText)) && pairs.get(Byte.valueOf(volatileText))){
                        Toast.makeText(getApplicationContext(), "Correcto", Toast.LENGTH_SHORT).show();
                        touch1.setBackgroundColor(Color.GREEN);
                        countAttempts();
                        reached = true;
                    } else{
                        touch1.setBackgroundColor(Color.RED);
                        countAttempts();
                    }
                }
            });

            touch2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    volatileText = touch2.getText().toString();
                    if(find(keys, volatileText) && pairs.containsKey(Byte.valueOf(volatileText)) && pairs.get(Byte.valueOf(volatileText))){
                        Toast.makeText(getApplicationContext(), "Correcto", Toast.LENGTH_SHORT).show();
                        touch2.setBackgroundColor(Color.GREEN);
                        countAttempts();
                        reached = true;
                    }
                    else {
                        touch2.setBackgroundColor(Color.RED);
                        countAttempts();
                    }
                }
            });

            touch3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    volatileText = touch3.getText().toString();
                    if(find(keys, volatileText) && pairs.containsKey(Byte.valueOf(volatileText)) && pairs.get(Byte.valueOf(volatileText))){
                        Toast.makeText(getApplicationContext(), "Correcto", Toast.LENGTH_SHORT).show();
                        touch3.setBackgroundColor(Color.GREEN);
                        countAttempts();
                        reached = true;
                    }
                    else {
                        touch3.setBackgroundColor(Color.RED);
                        countAttempts();
                    }
                }
            });

        } else{
            labeltext = noIntentMsg;
        }

        return1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantallados.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
    private boolean find(String[] list, String element){
        for (String e: list){
            if(e.equals(element)) return true;
        }
        return false;
    }

    private void countAttempts(){
        if (!reached) {
            attemptsInt += 1;
            attempts.setText(attemptStr.concat(String.valueOf(attemptsInt)));
        }
    }
}
