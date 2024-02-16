package com.dmv.sender;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_change1, btn_change2, btn_nosend, btn_send;
    TextView text_screen1;
    String Tag = "test";


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

    }
}