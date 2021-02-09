package com.ilya.kanadroid;

import java.util.Random;

public class Alphabet {
    public int getLength(){
        return hiragana.length;
    }

    public boolean isFinished(){
        return finished;
    }

    public Letter[] getNext(){
        Letter[] portion= new Letter[5];

        assert (position < getLength());
        final int least = Math.min(3, hiragana.length - 1 - position);
        assert (least >= 0);

        if(position >= getLength() - 3)
            finished = true;

        if(position == 0){
            for(int i = 0; i < 5; ++i){
                portion[i] = hiragana[position + i];
            }
            position+= 5;
        }else{
            for(int i = 0; i < least; ++i){
                portion[i] = hiragana[position + i];
            }
            for(int i = least; i < 5; ++i){
                portion[i] = hiragana[random.nextInt(position)];
            }
            position+= least;
        }

        return portion;
    }
    Random random = new Random();
    int position = 0;
    boolean finished = false;
    final Letter[] hiragana ={
            new Letter("あ", "a"),
            new Letter("い", "i"),
            new Letter("う", "u"),
            new Letter("え", "e"),
            new Letter("お", "o"),

            new Letter("か", "ka"),
            new Letter("き", "ki"),
            new Letter("く", "ku"),
            new Letter("け", "ke"),
            new Letter("こ", "ko"),

            new Letter("さ", "sa"),
            new Letter("し", "shi"),
            new Letter("す", "su"),
            new Letter("せ", "se"),
            new Letter("そ", "so"),

            new Letter("た", "ta"),
            new Letter("ち", "chi"),
            new Letter("つ", "tsu"),
            new Letter("て", "te"),
            new Letter("と", "to"),

            new Letter("な", "na"),
            new Letter("に", "ni"),
            new Letter("ぬ", "nu"),
            new Letter("ね", "ne"),
            new Letter("の", "no"),

            new Letter("は", "ha"),
            new Letter("ひ", "hi"),
            new Letter("ふ", "fu"),
            new Letter("へ", "he"),
            new Letter("ほ", "ho"),

            new Letter("ま", "ma"),
            new Letter("み", "mi"),
            new Letter("む", "mu"),
            new Letter("め", "me"),
            new Letter("も", "mo"),

            new Letter("や", "ya"),
            new Letter("ゆ", "yu"),
            new Letter("よ", "yo"),

            new Letter("ら", "ra"),
            new Letter("り", "ri"),
            new Letter("る", "ru"),
            new Letter("れ", "re"),
            new Letter("ろ", "ro"),

            new Letter("わ", "wa"),
            new Letter("を", "wo"),

            new Letter("ん", "n"),
    };
}
