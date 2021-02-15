package com.ilya.kanadroid;

public class GlobalPlaySettings {
    public enum AlphabetType{
        HIRAGANA,
        KATAKANA,
    }

    public static AlphabetType getAlphabetType() {
        return alphabetType;
    }

    public static void setAlphabetType(AlphabetType alphabetType) {
        GlobalPlaySettings.alphabetType = alphabetType;
    }

    static private AlphabetType alphabetType;
}
