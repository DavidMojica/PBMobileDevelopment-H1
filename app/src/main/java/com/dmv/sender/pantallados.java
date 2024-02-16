package com.dmv.sender;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class pantallados extends AppCompatActivity {
    TextView text_screen2;
    Button touch1, touch2, touch3, return1;
    String labeltext, volatileText;
    String noIntentMsg = "No data in intent";
    HashMap<Byte, Boolean> pairs = new HashMap<Byte, Boolean>();
    String[] keys = new String[3];
    Boolean ban = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantallados);
        Toast.makeText(getApplicationContext(), "Created", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();

        touch1 = findViewById(R.id.touch1);
        touch2 = findViewById(R.id.touch2);
        touch3 = findViewById(R.id.touch3);

       
    }
    private boolean find(String[] list, String element){
        for (String e: list){
            if(e.equals(element)) return true;
        }
        return false;
    }
}
