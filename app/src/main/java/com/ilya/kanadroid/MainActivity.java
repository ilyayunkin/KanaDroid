package com.ilya.kanadroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // public:
    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        String answer = b.getText().toString();

        boolean ok = play.checkAnswer(answer);
        if (ok)
            Toast.makeText(this , "Right!", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this , "Wrong!", Toast.LENGTH_SHORT).show();

        rightView.setText(String.valueOf(play.getRight()));
        wrongView.setText(String.valueOf(play.getWrong()));

        updateInterface();
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
        updateInterface();
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
    private Play play = new Play();
}