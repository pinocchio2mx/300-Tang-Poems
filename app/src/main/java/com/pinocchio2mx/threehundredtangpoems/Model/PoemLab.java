package com.pinocchio2mx.threehundredtangpoems.Model;

import android.content.Context;
import android.support.v4.app.FragmentActivity;

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
        for (int i=0;i < 200 ; i++){
            Poem poem = new Poem("title"+i,"author"+i);
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
