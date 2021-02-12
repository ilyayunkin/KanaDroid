package com.ilya.kanadroid;

public class Hiragana implements Charset {
    //@overrides
    public final Letter[] getMonographs(){
        return monographs;
    }
    final Letter[] monographs ={
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
