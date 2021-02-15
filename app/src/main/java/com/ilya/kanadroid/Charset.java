package com.ilya.kanadroid;

import java.util.ArrayList;

public interface Charset {
    public abstract ArrayList<Letter> getMonographs();
    public abstract ArrayList<Letter> getDiacritics();
    public abstract ArrayList<Letter> getDigraphs();
}
