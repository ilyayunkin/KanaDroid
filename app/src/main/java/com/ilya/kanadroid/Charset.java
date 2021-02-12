package com.ilya.kanadroid;

public interface Charset {
    public abstract Letter[] getMonographs();
    public abstract Letter[] getDiacritics();
    public abstract Letter[] getDigraphs();
}
