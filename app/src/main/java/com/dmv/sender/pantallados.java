package com.dmv.sender;

import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class pantallados extends AppCompatActivity {
    TextView text_screen2;
    Button touch1, touch2, touch3, return1;
    String labeltext;
    HashMap<Byte, Byte> pairs = new HashMap<Byte, Byte>();

    @Override
    protected void onStart() {
        super.onStart();

        try{
            labeltext = getIntent().getStringExtra("labelText");
            pairs = (HashMap<Byte, Byte>) getIntent().getSerializableExtra("hashMap");



        } catch (Exception e) {

        }
    }
}
