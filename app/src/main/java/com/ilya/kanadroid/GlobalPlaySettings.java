package com.ilya.kanadroid;

public class GlobalPlaySettings {
    public enum AlphabetType{
        HIRAGANA,
        KATAKANA,
    }
    public enum LessonType{
        MONOGRAPHS,
        DIGRAPHS,
        DIACRITICS,
    }

    public static AlphabetType getAlphabetType() {
        return alphabetType;
    }

    public static void setAlphabetType(AlphabetType alphabetType) {
        GlobalPlaySettings.alphabetType = alphabetType;
    }

    public static LessonType getLessonType() {
        return lessonType;
    }

    public static void setLessonType(LessonType lessonType) {
        GlobalPlaySettings.lessonType = lessonType;
    }

    static private AlphabetType alphabetType;

    static private LessonType lessonType;
}
