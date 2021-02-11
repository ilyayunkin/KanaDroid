package com.ilya.kanadroid;

import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

public class Play {
    //public:
    public Play() {
        loadLetters();
    }

    public boolean checkAnswer(String answer) {
        String rightAnswer = currentLetter.reading;
        if(answer.equals(rightAnswer)){
            ++right;
            rightLetter[currentIndex] = true;

            System.out.println("Answers: " + Arrays.toString(rightLetter));

            if(isAllTrue()){
                System.out.println("Update level");
                updateLevel();
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

    public Letter[] getPortion() {
        return portion;
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
        currentIndex = random.nextInt(5);
        Letter newLetter = portion[currentIndex];

        while(newLetter == oldLetter){
            currentIndex = random.nextInt(5);
            newLetter = portion[currentIndex];
        };

        currentLetter = newLetter;
    }
    private void updateLevel(){
        loadLetters();
    }
    private void loadLetters(){
        portion = abc.getNext();
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

    //private data:
    private Alphabet abc = new Alphabet();

    private final Random random = new Random();

    private Letter[] portion= new Letter[5];
    private Letter currentLetter;

    private int right = 0;
    private int wrong = 0;
    private int currentIndex = 0;
    private boolean[] rightLetter = new boolean[5];
}
