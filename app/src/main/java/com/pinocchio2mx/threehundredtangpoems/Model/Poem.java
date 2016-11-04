package com.pinocchio2mx.threehundredtangpoems.model;

import java.io.Serializable;

/**
 * Created by pinocchio2mx on 2016/10/28.
 */

public class Poem implements Serializable {
    private String mTitle;
    private String mAuthor;
    private String mContent;

    public Poem(String title,String author,String content) {
        mTitle = title;
        mAuthor = author;
        mContent = content;
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
    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }
}
