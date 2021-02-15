package com.ilya.kanadroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity implements View.OnClickListener, IPlayUi {
    // public:
    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        String answer = b.getText().toString();
        System.out.println("onClick " + answer);

        final int oldLevel = play.getLevel();
        boolean ok = play.checkAnswer(answer);
        if (ok) {
            System.out.println("onClick: Right!");
        }else {
            System.out.println("onClick: Wrong!");
        }

        rightView.setText(String.valueOf(play.getRight()));
        wrongView.setText(String.valueOf(play.getWrong()));

        updateInterface();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("PlayActivity onCreate");

        final GlobalPlaySettings.AlphabetType alphabetType = GlobalPlaySettings.getAlphabetType();
        final int level = 0;
        int position = (level > 1) ? (5 + (level - 2) * 3) : 0;
        Alphabet abc;
        if(alphabetType == GlobalPlaySettings.AlphabetType.HIRAGANA){
            abc = new Alphabet(new Hiragana().getMonographs(), position);
        }else{
            abc = new Alphabet(new Katakana().getMonographs(), position);
        }
        play = new Play(this, 1, abc);

        setContentView(R.layout.activity_play);
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
        updateInterface();
    }

    public void showCongratsLevel(final int level){
        System.out.println("showCongratsLevel: " + level);
        Intent intent = new Intent(this, CongratsActivity.class);
        String congrat = "You reached level " + play.getLevel();
        System.out.println("showCongratsLevel: " + congrat);
        intent.putExtra("text", congrat);
        startActivity(intent);
    }

    public void showCongratsWin(){
        Intent intent = new Intent(this, CongratsActivity.class);
        String congrat = "You win!";
        intent.putExtra("text", congrat);
        startActivity(intent);
    }

    // private:
    private void updateInterface() {
        Letter portion[] = play.getPortion();
        for(int i = 0; i < 5; ++i){
            buttons.get(i).setText(portion[i].reading);
        }
        textView.setText(play.getCurrentLetter().letter);
    }

    // private data:
    private ArrayList<Button> buttons = new ArrayList<Button>();
    private TextView textView;
    private TextView rightView;
    private TextView wrongView;
    private Play play;
}