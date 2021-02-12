package com.ilya.kanadroid;

import java.util.Random;

public class Alphabet {
    public Alphabet(Letter[] charset, int position) {
        this.position = position;
        this.charset = charset;
    }

    public Alphabet() {
    }

    public int getLength(){
        return charset.length;
    }

    public boolean isFinished(){
        return finished;
    }

    public Letter[] getNext(){
        Letter[] portion= new Letter[5];

        assert (position <= getLength());
        final int least = Math.min(3, charset.length - position);
        assert (least >= 0);

        if(position >= getLength() - 3)
            finished = true;

        if(position == 0){
            for(int i = 0; i < 5; ++i){
                portion[i] = charset[position + i];
            }
            position+= 5;
        }else{
            for(int i = 0; i < least; ++i){
                portion[i] = charset[position + i];
            }
            for(int i = least; i < 5; ++i){
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
