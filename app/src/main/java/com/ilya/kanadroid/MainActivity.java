package com.ilya.kanadroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<Button> buttons = new ArrayList<Button>();
    TextView textView;
    TextView rightView;
    TextView wrongView;

    Letter[] hiragana ={
            new Letter("あ", "a"),
            new Letter("い", "i"),
            new Letter("う", "u"),
            new Letter("え", "e"),
            new Letter("お", "o")
    };
    final Random random = new Random();
    Letter currentLetter;
    int right = 0;
    int wrong = 0;

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        String answer = b.getText().toString();
        String rightAnswer = currentLetter.reading;
        if(answer.equals(rightAnswer)){
            updateLetter();
            Toast.makeText(this , "Right!", Toast.LENGTH_SHORT).show();
            ++right;
            rightView.setText(String.valueOf(right));
        }else{
            updateLetter();
            Toast.makeText(this , "Wrong!", Toast.LENGTH_SHORT).show();
            ++wrong;
            wrongView.setText(String.valueOf(wrong));
        }
    }

    public class Letter{
        String letter;
        String reading;

        public Letter(String letter, String reading) {
            this.letter = letter;
            this.reading = reading;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.letterTextView);
        rightView = findViewById(R.id.rightView);
        wrongView = findViewById(R.id.wrongView);
        buttons.add((Button)findViewById(R.id.button1));
        buttons.add((Button)findViewById(R.id.button2));
        buttons.add((Button)findViewById(R.id.button3));
        buttons.add((Button)findViewById(R.id.button4));
        buttons.add((Button)findViewById(R.id.button5));
        for(int i = 0; i < 5; ++i){
            buttons.get(i).setOnClickListener(this);
        }
        updateLetter();
    }
    void updateLetter(){
        Letter oldLetter = currentLetter;
        Letter newLetter = hiragana[random.nextInt(5)];
        while(newLetter == oldLetter){
            newLetter = hiragana[random.nextInt(5)];
        };
        currentLetter = newLetter;
        textView.setText(currentLetter.letter);
        for(int i = 0; i < 5; ++i){
            buttons.get(i).setText(hiragana[i].reading);
        }
    }
}