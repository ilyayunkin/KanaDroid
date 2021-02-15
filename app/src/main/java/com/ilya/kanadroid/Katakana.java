package com.ilya.kanadroid;

public class Katakana implements Charset {
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
            new Letter("ガ", "ga"),
            new Letter("ギ", "gi"),
            new Letter("グ", "gu"),
            new Letter("ゲ", "ge"),
            new Letter("ゴ", "go"),

            new Letter("ザ", "za"),
            new Letter("ジ", "ji"),
            new Letter("ズ", "zu"),
            new Letter("ゼ", "ze"),
            new Letter("ゾ", "zo"),

            new Letter("ダ", "da"),
            new Letter("ヂ", "ji"),
            new Letter("ヅ", "zu"),
            new Letter("デ", "de"),
            new Letter("ド", "do"),

            new Letter("バ", "ba"),
            new Letter("ビ", "bi"),
            new Letter("ブ", "bu"),
            new Letter("ベ", "be"),
            new Letter("ボ", "bo"),

            new Letter("パ", "pa"),
            new Letter("ピ", "pi"),
            new Letter("プ", "pu"),
            new Letter("ペ", "pe"),
            new Letter("ポ", "po"),
    };

    final Letter[] digraphs ={
            new Letter("キャ", "kya"),
            new Letter("キュ", "kyu"),
            new Letter("キョ", "kyo"),

            new Letter("シャ", "sha"),
            new Letter("シュ", "shu"),
            new Letter("ショ", "sho"),

            new Letter("チャ", "cha"),
            new Letter("チュ", "chu"),
            new Letter("チョ", "cho"),

            new Letter("ニャ", "nya"),
            new Letter("ニュ", "nyu"),
            new Letter("ニョ", "nyo"),

            new Letter("ヒャ", "hya"),
            new Letter("ヒュ", "hyu"),
            new Letter("ヒョ", "hyo"),

            new Letter("ミャ", "mya"),
            new Letter("ミュ", "myu"),
            new Letter("ミョ", "myo"),

            new Letter("リャ", "rya"),
            new Letter("リュ", "ryu"),
            new Letter("リョ", "ryo"),

            new Letter("ギャ", "gya"),
            new Letter("ギュ", "gyu"),
            new Letter("ギョ", "gyo"),

            new Letter("ジャ", "ja"),
            new Letter("ジュ", "ju"),
            new Letter("ジョ", "jo"),

            new Letter("ヂャ", "ja"),
            new Letter("ヂュ", "ju"),
            new Letter("ヂョ", "jo"),

            new Letter("ビャ", "bya"),
            new Letter("ビュ", "byu"),
            new Letter("ビョ", "byo"),

            new Letter("ピャ", "pya"),
            new Letter("ピュ", "pyu"),
            new Letter("ピョ", "pyo"),
    };

    final Letter[] monographs ={
            new Letter("ア", "a"),
            new Letter("イ", "i"),
            new Letter("ウ", "u"),
            new Letter("エ", "e"),
            new Letter("オ", "o"),

            new Letter("カ", "ka"),
            new Letter("キ", "ki"),
            new Letter("ク", "ku"),
            new Letter("ケ", "ke"),
            new Letter("コ", "ko"),

            new Letter("サ", "sa"),
            new Letter("シ", "shi"),
            new Letter("ス", "su"),
            new Letter("セ", "se"),
            new Letter("ソ", "so"),

            new Letter("タ", "ta"),
            new Letter("チ", "chi"),
            new Letter("ツ", "tsu"),
            new Letter("テ", "te"),
            new Letter("ト", "to"),

            new Letter("ナ", "na"),
            new Letter("ニ", "ni"),
            new Letter("ヌ", "nu"),
            new Letter("ネ", "ne"),
            new Letter("ノ", "no"),

            new Letter("ハ", "ha"),
            new Letter("ヒ", "hi"),
            new Letter("フ", "fu"),
            new Letter("ヘ", "he"),
            new Letter("ホ", "ho"),

            new Letter("マ", "ma"),
            new Letter("ミ", "mi"),
            new Letter("ム", "mu"),
            new Letter("メ", "me"),
            new Letter("モ", "mo"),

            new Letter("ヤ", "ya"),
            new Letter("ユ", "yu"),
            new Letter("ヨ", "yo"),

            new Letter("ラ", "ra"),
            new Letter("リ", "ri"),
            new Letter("ル", "ru"),
            new Letter("レ", "re"),
            new Letter("ロ", "ro"),

            new Letter("ワ", "wa"),
            new Letter("ヲ", "wo"),

            new Letter("ン", "n"),
    };
}