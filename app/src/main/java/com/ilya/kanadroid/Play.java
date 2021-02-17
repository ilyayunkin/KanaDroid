package com.ilya.kanadroid;

import java.util.ArrayList;
import java.util.Random;

public class Play {
    //public:
    public Play(IPlayUi playUi, final int level, Alphabet abc) {
        assert (level >= 1);

        System.out.println("Play(IPlayUi playUi, int position, int level)");
        this.playUi = playUi;
        this.level = level;
        this.abc = abc;
        loadLetters();
    }

    public boolean checkAnswer(String answer) {
        boolean ok = levelObject.checkAnswer(answer);
        if(ok){
            ++right;
            if(levelObject.isFinished()){
                boolean finished = abc.isFinished();
                if(finished) {
                    playUi.showCongratsWin();
                }else {
                    playUi.showCongratsLevel(level + 1);
                }
                updateLevel();
            }else{
                System.out.println("Update letters");
                levelObject.updateLetter();
            }
        }else{
            ++wrong;
            levelObject.updateLetter();
        }
        return ok;
    }

    public Letter getCurrentLetter() {
        return levelObject.getCurrentLetter();
    }

    public ArrayList<Letter> getLettersSet() {
        return levelObject.getLettersSet();
    }

    public ArrayList<Letter> getButtonsSet() {
        return levelObject.getButtonsSet();
    }

    public int getRight() {
        return right;
    }

    public int getWrong() {
        return wrong;
    }

    public int[] getRightLetter() {
        return levelObject.getRightLetter();
    }

    // private:
    private void updateLevel(){
        loadLetters();
        ++level;
    }
    private void loadLetters(){
        levelObject = abc.getNext();
    }

    public int getLevel() {
        return level;
    }

    public int getPosition() {
        return abc.getPosition();
    }

    //private data:
    private IPlayUi playUi;
    private Alphabet abc;

    private final Random random = new Random();

    private Level levelObject;

    private int level = 1;
    private int right = 0;
    private int wrong = 0;
}
