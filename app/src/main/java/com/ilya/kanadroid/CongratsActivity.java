package com.ilya.kanadroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CongratsActivity extends AppCompatActivity {

    public void onOkClicked(View v) {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("MainActivity onCreate");
        setContentView(R.layout.activity_congrats);

        Intent intent = getIntent();
        TextView textView = (TextView)findViewById(R.id.congratsTextView);
        String text = intent.getStringExtra("text");
        System.out.println("text =" + text);
        textView.setText(text);
    }
}