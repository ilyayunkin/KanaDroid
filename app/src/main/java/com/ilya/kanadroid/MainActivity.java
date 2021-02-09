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
    TextView textView;
    TextView rightView;
    TextView wrongView;

    final Random random = new Random();
    Letter[] portion= new Letter[5];
    Letter currentLetter;
    int position = 0;
    int right = 0;
    int wrong = 0;
    int currentIndex = 0;
    boolean[] rightLetter = new boolean[5];

    final Letter[] hiragana ={
            new Letter("あ", "a"),
            new Letter("い", "i"),
            new Letter("う", "u"),
            new Letter("え", "e"),
            new Letter("お", "o"),

            new Letter("か", "ka"),
            new Letter("き", "ki"),
            new Letter("く", "ku"),
            new Letter("け", "ke"),
            new Letter("こ", "ko"),

            new Letter("さ", "sa"),
            new Letter("し", "shi"),
            new Letter("す", "su"),
            new Letter("せ", "se"),
            new Letter("そ", "so"),

            new Letter("た", "ta"),
            new Letter("ち", "chi"),
            new Letter("つ", "tsu"),
            new Letter("て", "te"),
            new Letter("と", "to"),

            new Letter("な", "na"),
            new Letter("に", "ni"),
            new Letter("ぬ", "nu"),
            new Letter("ね", "ne"),
            new Letter("の", "no"),

            new Letter("は", "ha"),
            new Letter("ひ", "hi"),
            new Letter("ふ", "hu"),
            new Letter("へ", "he"),
            new Letter("ほ", "ho"),

            new Letter("ま", "ma"),
            new Letter("み", "mi"),
            new Letter("む", "mu"),
            new Letter("め", "me"),
            new Letter("も", "mo"),

            new Letter("や", "ya"),
            new Letter("ゆ", "yu"),
            new Letter("よ", "yo"),

            new Letter("ら", "ra"),
            new Letter("り", "ri"),
            new Letter("る", "ru"),
            new Letter("れ", "re"),
            new Letter("ろ", "ro"),

            new Letter("ら", "wa"),
            new Letter("ろ", "wo"),

            new Letter("ん", "n"),
    };

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
        if(position == 0)
            position+= 5;
        else
            position+= 3;
        loadLetters();
    }
    void loadLetters(){
        if(position == 0){
            for(int i = 0; i < 5; ++i){
                portion[i] = hiragana[position + i];
            }
        }else{
            for(int i = 0; i < 3; ++i){
                portion[i] = hiragana[position + i];
            }
            portion[3] = hiragana[random.nextInt(position)];
            portion[4] = hiragana[random.nextInt(position)];
        }
        for(int i = 0; i < 5; ++i){
            rightLetter[i] = false;
        }
        updateLetter();
    }
}