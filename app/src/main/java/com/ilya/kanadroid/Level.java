package com.ilya.kanadroid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Level {
    public Level() {
        for(int i = 0; i < 5; ++i){
            rightLetter[i] = 0;
        }
    }

    public void add(Letter letter, final boolean isNew){
        lettersSet.add(new LetterStruct(letter, isNew));
        buttonsSet.add(letter);
        assert (lettersSet.size() == buttonsSet.size());
    }

    public void shuffle(){
        assert (lettersSet.size() == buttonsSet.size());
        Collections.shuffle(lettersSet);
        Collections.shuffle(buttonsSet);
        setLetter(0);
    }

    public boolean checkAnswer(String answer) {
        String rightAnswer = currentLetter.letter.reading;
        if(answer.equals(rightAnswer)){
            ++rightLetter[currentIndex];

            System.out.println("Answers: " + Arrays.toString(rightLetter));

            if(isFinished()){
                System.out.println("Update level");
            }else{
                System.out.println("Update letters");
                updateLetter();
            }
            return true;
        }else{
            rightLetter[currentIndex] = 0;
            updateLetter();
            return false;
        }
    }
    public void updateLetter(){
        currentIndex = (currentIndex + 1) % lettersSet.size();
        setLetter(currentIndex);
    }

    public int[] getRightLetter() {
        return rightLetter;
    }

    public Letter getCurrentLetter() {
        return currentLetter.letter;
    }

    public boolean isFinished() {
        boolean allTrue = true;
        for(int i = 0; i < 5; ++i) {
            if(rightLetter[i] < 3) {
                allTrue = false;
            }
        }
        return allTrue;
    }

    public ArrayList<Letter> getLettersSet() {
        ArrayList<Letter> letters = new ArrayList<Letter>();
        for(LetterStruct letter : lettersSet){
            letters.add(letter.letter);
        }
        return letters;
    }

    public ArrayList<Letter> getButtonsSet() {
        return buttonsSet;
    }
    // private:
    private class LetterStruct{
        public LetterStruct(Letter letter, boolean isNew) {
            this.letter = letter;
            IsNew = isNew;
        }

        Letter letter;
        boolean IsNew;
    }

    private void setLetter(int index) {
        LetterStruct newLetter = lettersSet.get(index);

        currentLetter = newLetter;
    }
    ArrayList<LetterStruct> lettersSet = new ArrayList<LetterStruct>();
    private int currentIndex = 0;

    private int[] rightLetter = new int[5];

    private ArrayList<Letter> buttonsSet = new ArrayList<Letter>(5);

    private LetterStruct currentLetter;
}
