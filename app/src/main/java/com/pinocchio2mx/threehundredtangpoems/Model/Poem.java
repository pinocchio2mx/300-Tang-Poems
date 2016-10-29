package com.pinocchio2mx.threehundredtangpoems.Model;

import java.util.UUID;

/**
 * Created by pinocchio2mx on 2016/10/28.
 */

public class Poem {
    private String mTitle;
    private String mAuthor;

    public Poem(String author, String title) {
        mAuthor = author;
        mTitle = title;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
