package com.ilya.kanadroid;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

        Charset charset;
        if(alphabetType == GlobalPlaySettings.AlphabetType.HIRAGANA){
            charset = new Hiragana();
        }else{
            charset = new Katakana();
        }

        ArrayList<Letter> letters;
        switch (GlobalPlaySettings.getLessonType()){
            case DIACRITICS:
                letters = charset.getDiacritics();
                break;
            case DIGRAPHS:
                letters = charset.getDigraphs();
                break;
            default:
                letters = charset.getMonographs();
                break;
        }

        Alphabet abc = new Alphabet(letters, position);;
        play = new Play(this, 1, abc);

        setContentView(R.layout.activity_play);
        textView = findViewById(R.id.letterTextView);
        rightView = findViewById(R.id.rightView);
        wrongView = findViewById(R.id.wrongView);
        {
            buttons.add((Button) findViewById(R.id.button1));
            buttons.add((Button) findViewById(R.id.button2));
            buttons.add((Button) findViewById(R.id.button3));
            buttons.add((Button) findViewById(R.id.button4));
            buttons.add((Button) findViewById(R.id.button5));
        }
        {
            stars.add((ImageView) findViewById(R.id.starImageView1));
            stars.add((ImageView) findViewById(R.id.starImageView2));
            stars.add((ImageView) findViewById(R.id.starImageView3));
            stars.add((ImageView) findViewById(R.id.starImageView4));
            stars.add((ImageView) findViewById(R.id.starImageView5));
        }
        for(int i = 0; i < 5; ++i){
            buttons.get(i).setOnClickListener(this);
        }
        updateInterface();
    }

    public void showCongratsLevel(final int level){
        System.out.println("showCongratsLevel: " + level);
        Intent intent = new Intent(this, CongratsActivity.class);
        String congrat = "You reached level " + level;
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
        ArrayList<Letter> lettersSet = play.getLettersSet();
        ArrayList<Letter> buttonsSet = play.getButtonsSet();
        int[] rightAnswers = play.getRightLetter();
        assert (lettersSet.size() == buttonsSet.size());
        assert (lettersSet.size() == rightAnswers.length);

        for(int i = 0; i < 5; ++i){
            buttons.get(i).setText(buttonsSet.get(i).reading);
            ImageView star = stars.get(i);
            switch (rightAnswers[i]) {
                case 0:
                    star.setImageResource(R.drawable.star_empty);
                    break;
                case 1:
                    star.setImageResource(R.drawable.star_quart);
                    break;
                case 2:
                    star.setImageResource(R.drawable.star_half);
                    break;
                default:
                    star.setImageResource(R.drawable.star_full);
            }
        }
        textView.setText(play.getCurrentLetter().letter);
    }

    // private data:
    private ArrayList<Button> buttons = new ArrayList<Button>();
    private ArrayList<ImageView> stars = new ArrayList<ImageView>();
    private TextView textView;
    private TextView rightView;
    private TextView wrongView;
    private Play play;
}