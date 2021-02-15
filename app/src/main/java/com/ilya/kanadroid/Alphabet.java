package com.ilya.kanadroid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alphabet {
    public Alphabet(ArrayList<Letter> charset, int position) {
        this.position = position;
        this.charset = charset;
    }

    public int getLength(){
        return charset.size();
    }

    public boolean isFinished(){
        return finished;
    }

    public ArrayList<Letter> getNext(){
        assert (position <= getLength());
        final int portionSize = 5;
        final int newCharactersInPortion = 3;

        if(position >= getLength() - newCharactersInPortion)
            finished = true;

        ArrayList<Letter> portion= new ArrayList<Letter>();
        if(position == 0){
            for(int i = 0; i < portionSize; ++i){
                portion.add(charset.get(i));
            }
            position+= portionSize;
        }else{
            final int least = Math.min(newCharactersInPortion, charset.size() - position);
            assert (least >= 0);

            for(int i = 0; i < least; ++i){
                portion.add(charset.get(position + i));
            }
            {
                List<Letter> learnedSubrange = charset.subList(0, position);
                Collections.shuffle(learnedSubrange);
                for(int i = 0; i < portionSize - least; ++i){
                    portion.add(learnedSubrange.get(i));
                }
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
    int position = 0;
    boolean finished = false;
    ArrayList<Letter> charset;
}
