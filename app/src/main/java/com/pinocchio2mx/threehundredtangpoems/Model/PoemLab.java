package com.pinocchio2mx.threehundredtangpoems.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pinocchio2mx on 2016/10/29.
 */

public class PoemLab {
    private static PoemLab sPoemLab;
    private List<Poem> mPoems;

    private PoemLab(Context context) {
        mPoems = new ArrayList<>();
        for (int i=1;i < 21 ; i++){
            Poem poem = new Poem("标题"+i,"作者"+i,"正文"+i);
            mPoems.add(poem);
        }
    }

    public static PoemLab get(Context context) {
        if(sPoemLab == null){
            sPoemLab = new PoemLab(context);
        }
        return  sPoemLab;
    }

    public List<Poem> getPoems() {
        return mPoems;
    }

}
