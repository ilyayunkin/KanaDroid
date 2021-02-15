package com.ilya.kanadroid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        String rightAnswer = currentLetter.reading;
        if(answer.equals(rightAnswer)){
            ++right;
            rightLetter[currentIndex] = true;

            System.out.println("Answers: " + Arrays.toString(rightLetter));

            if(isAllTrue()){
                boolean finished = abc.isFinished();
                System.out.println("Update level");
                updateLevel();
                if(finished) {
                    playUi.showCongratsWin();
                }else {
                    playUi.showCongratsLevel(level);
                }
            }else{
                System.out.println("Update letters");
                updateLetter();
            }
            return true;
        }else{
            updateLetter();
            ++wrong;
            for(int i = 0; i < 5; ++i){
                rightLetter[i] = false;
            }
            return false;
        }
    }

    public Letter getCurrentLetter() {
        return currentLetter;
    }

    public ArrayList<Letter> getLettersSet() {
        return lettersSet;
    }

    public ArrayList<Letter> getButtonsSet() {
        return buttonsSet;
    }

    public int getRight() {
        return right;
    }

    public int getWrong() {
        return wrong;
    }

    // private:
    private void updateLetter(){
        Letter oldLetter = currentLetter;
        currentIndex = (currentIndex + 1) % lettersSet.size();
        Letter newLetter = lettersSet.get(currentIndex);

        currentLetter = newLetter;
    }
    private void updateLevel(){
        loadLetters();
        ++level;
    }
    private void loadLetters(){
        lettersSet = abc.getNext();
        Collections.shuffle(lettersSet);
        buttonsSet = new ArrayList<Letter>(lettersSet);
        Collections.shuffle(buttonsSet);

        for(int i = 0; i < 5; ++i){
            rightLetter[i] = false;
        }
        updateLetter();
    }

    private boolean isAllTrue() {
        boolean allTrue = true;
        for(int i = 0; i < 5; ++i) {
            if(rightLetter[i] == false) {
                allTrue = false;
            }
        }
        return allTrue;
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

    private ArrayList<Letter> lettersSet = new ArrayList<Letter>(5);

    private ArrayList<Letter> buttonsSet = new ArrayList<Letter>(5);
    private Letter currentLetter;

    private int level = 1;
    private int right = 0;
    private int wrong = 0;
    private int currentIndex = 0;
    private boolean[] rightLetter = new boolean[5];
}
