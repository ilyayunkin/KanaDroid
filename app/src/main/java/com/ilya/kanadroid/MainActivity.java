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

public class MainActivity extends AppCompatActivity implements View.OnClickListener, IPlayUi {
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
        System.out.println("MainActivity onCreate");

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
    private Play play = new Play(this, 1);
}