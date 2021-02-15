package com.ilya.kanadroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("MainActivity onCreate");
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        Button button = (Button)view;
        Button hiraganaButton = findViewById(R.id.hiraganaButton);
        if(button == hiraganaButton){
            GlobalPlaySettings.setAlphabetType(GlobalPlaySettings.AlphabetType.HIRAGANA);
        }else{
            GlobalPlaySettings.setAlphabetType(GlobalPlaySettings.AlphabetType.KATAKANA);
        }
        Intent intent = new Intent(this, PlayActivity.class);
        startActivity(intent);
    }
}