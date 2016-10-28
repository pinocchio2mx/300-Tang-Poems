package com.pinocchio2mx.threehundredtangpoems.Model;

import java.util.UUID;

/**
 * Created by pinocchio2mx on 2016/10/28.
 */

public class Poem {
    private UUID mId;

    private String mString1;
    private String mString2;
    private String mString3;
    private String mString4;
    private Boolean mFavorited;

    public UUID getId() {
        return mId;
    }

    public String getString1() {
        return mString1;
    }

    public void setString1(String string1) {
        mString1 = string1;
    }


    public String getString2() {
        return mString2;
    }

    public void setString2(String string2) {
        mString2 = string2;
    }

    public String getString3() {
        return mString3;
    }

    public void setString3(String string3) {
        mString3 = string3;
    }

    public String getString4() {
        return mString4;
    }

    public void setString4(String string4) {
        mString4 = string4;
    }

    public Boolean isFavorited() {
        return mFavorited;
    }

    public void setFavorited(Boolean favorited) {
        mFavorited = favorited;
    }


}
