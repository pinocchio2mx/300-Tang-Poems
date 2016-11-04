package com.pinocchio2mx.threehundredtangpoems;

import android.content.res.Resources;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pinocchio2mx.threehundredtangpoems.R;

public abstract class BaseFragmentActivity extends AppCompatActivity {
    protected abstract Fragment getFragment();
    @LayoutRes
    protected int getLayoutResID(){
        return R.layout.actvity_base_fragment;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if(fragment == null){
            fragment = getFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container,fragment,"1")
                    .commit();
        }

    }
}
