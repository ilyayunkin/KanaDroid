package com.ilya.kanadroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<Button> buttons = new ArrayList<Button>();
    Alphabet abc = new Alphabet();
    TextView textView;
    TextView rightView;
    TextView wrongView;

    final Random random = new Random();
    Letter[] portion= new Letter[5];
    Letter currentLetter;
    int right = 0;
    int wrong = 0;
    int currentIndex = 0;
    boolean[] rightLetter = new boolean[5];

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        String answer = b.getText().toString();
        String rightAnswer = currentLetter.reading;
        if(answer.equals(rightAnswer)){
            Toast.makeText(this , "Right!", Toast.LENGTH_SHORT).show();
            ++right;
            rightLetter[currentIndex] = true;
            rightView.setText(String.valueOf(right));

            System.out.println("Answers: " + Arrays.toString(rightLetter));
            boolean allTrue = true;
            for(int i = 0; i < 5; ++i) {
                if(rightLetter[i] == false) {
                    allTrue = false;
                }
            }

            if(allTrue){
                System.out.println("Update level");
                updateLevel();
            }else{
                System.out.println("Update letters");
                updateLetter();
            }
        }else{
            updateLetter();
            Toast.makeText(this , "Wrong!", Toast.LENGTH_SHORT).show();
            ++wrong;
            wrongView.setText(String.valueOf(wrong));
            for(int i = 0; i < 5; ++i){
                rightLetter[i] = false;
            }
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
        loadLetters();
    }
    void updateLetter(){
        Letter oldLetter = currentLetter;
        currentIndex = random.nextInt(5);
        Letter newLetter = portion[currentIndex];

        while(newLetter == oldLetter){
            currentIndex = random.nextInt(5);
            newLetter = portion[currentIndex];
        };

        currentLetter = newLetter;
        textView.setText(currentLetter.letter);
        for(int i = 0; i < 5; ++i){
            buttons.get(i).setText(portion[i].reading);
        }
    }
    void updateLevel(){
        loadLetters();
    }
    void loadLetters(){
        portion = abc.getNext();
        for(int i = 0; i < 5; ++i){
            rightLetter[i] = false;
        }
        updateLetter();
    }
}