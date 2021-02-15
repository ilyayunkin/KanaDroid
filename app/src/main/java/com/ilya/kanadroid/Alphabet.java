package com.ilya.kanadroid;

import java.util.Random;

public class Alphabet {
    public Alphabet(Letter[] charset, int position) {
        this.position = position;
        this.charset = charset;
    }

    public int getLength(){
        return charset.length;
    }

    public boolean isFinished(){
        return finished;
    }

    public Letter[] getNext(){
        final int portionSize = 5;
        final int newCharactersInPortion = 3;
        Letter[] portion= new Letter[portionSize];

        assert (position <= getLength());
        final int least = Math.min(newCharactersInPortion, charset.length - position);
        assert (least >= 0);

        if(position >= getLength() - newCharactersInPortion)
            finished = true;

        if(position == 0){
            for(int i = 0; i < portionSize; ++i){
                portion[i] = charset[position + i];
            }
            position+= portionSize;
        }else{
            for(int i = 0; i < least; ++i){
                portion[i] = charset[position + i];
            }
            for(int i = least; i < portionSize; ++i){
                portion[i] = charset[random.nextInt(position)];
            }
            position+= least;
        }

        return portion;
    }
    // private:
    public int getPosition() {
        return position;
    }

    // private data:
    Random random = new Random();
    int position = 0;
    boolean finished = false;
    Letter[] charset;
}
