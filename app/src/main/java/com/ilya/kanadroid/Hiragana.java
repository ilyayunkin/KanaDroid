package com.ilya.kanadroid;

public class Hiragana implements Charset {
    @Override
    public final Letter[] getMonographs(){
        return monographs;
    }

    @Override
    public Letter[] getDiacritics() {
        return diacritics;
    }

    @Override
    public Letter[] getDigraphs() {
        return new Letter[0];
    }

    final Letter[] diacritics ={
            new Letter("が", "ga"),
            new Letter("ぎ", "gi"),
            new Letter("ぐ", "gu"),
            new Letter("げ", "ge"),
            new Letter("ご", "go"),

            new Letter("ざ", "za"),
            new Letter("じ", "ji"),
            new Letter("ず", "zu"),
            new Letter("ぜ", "ze"),
            new Letter("ぞ", "zo"),

            new Letter("だ", "da"),
            new Letter("ぢ", "ji"),
            new Letter("づ", "zu"),
            new Letter("で", "de"),
            new Letter("ど", "do"),

            new Letter("ば", "ba"),
            new Letter("び", "bi"),
            new Letter("ぶ", "bu"),
            new Letter("べ", "be"),
            new Letter("ぼ", "bo"),

            new Letter("ぱ", "pa"),
            new Letter("ぴ", "pi"),
            new Letter("ぷ", "pu"),
            new Letter("ぺ", "pe"),
            new Letter("ぽ", "po"),
    };

    final Letter[] digraphs ={
            new Letter("きゃ", "kya"),
            new Letter("きゅ", "kyu"),
            new Letter("きょ", "kyo"),

            new Letter("しゃ", "sha"),
            new Letter("しゅ", "shu"),
            new Letter("しょ", "sho"),

            new Letter("ちゃ", "cha"),
            new Letter("ちゅ", "chu"),
            new Letter("ちょ", "cho"),

            new Letter("にゃ", "nya"),
            new Letter("にゅ", "nyu"),
            new Letter("にょ", "nyo"),

            new Letter("ひゃ", "hya"),
            new Letter("ひゅ", "hyu"),
            new Letter("ひょ", "hyo"),

            new Letter("みゃ", "mya"),
            new Letter("みゅ", "myu"),
            new Letter("みょ", "myo"),

            new Letter("りゃ", "rya"),
            new Letter("りゅ", "ryu"),
            new Letter("りょ", "ryo"),

            new Letter("ぎゃ", "gya"),
            new Letter("ぎゅ", "gyu"),
            new Letter("ぎょ", "gyo"),

            new Letter("じゃ", "ja"),
            new Letter("じゅ", "ju"),
            new Letter("じょ", "jo"),

            new Letter("ぢゃ", "ja"),
            new Letter("ぢゅ", "ju"),
            new Letter("ぢょ", "jo"),

            new Letter("びゃ", "bya"),
            new Letter("びゅ", "byu"),
            new Letter("びょ", "byo"),

            new Letter("ぴゃ", "pya"),
            new Letter("ぴゅ", "pyu"),
            new Letter("ぴょ", "pyo"),
    };

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
