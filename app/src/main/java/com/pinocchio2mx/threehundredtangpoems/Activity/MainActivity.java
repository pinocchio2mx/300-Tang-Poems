package com.pinocchio2mx.threehundredtangpoems.Activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.pinocchio2mx.threehundredtangpoems.Fragment.PoemFragment;
import com.pinocchio2mx.threehundredtangpoems.Fragment.PoemListFragment;
import com.pinocchio2mx.threehundredtangpoems.R;


import static android.R.attr.fragment;
import static com.pinocchio2mx.threehundredtangpoems.R.id.fragment_container;

public class MainActivity extends BaseFragmentActivity
        implements PoemListFragment.OnPoemSelectedListener,
        PoemFragment.OnTextSelectedListener{

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //setContentView(R.layout.activity_main);
//        initWindow();
//
////        if(findViewById(R.id.fragment_poem_list) != null) {
////            if (savedInstanceState != null) {
////                return;
////            }
////        }
//
//
////        Fragment poemListFragment = new PoemListFragment();
////        poemListFragment.setArguments(getIntent().getExtras());
////        getSupportFragmentManager().beginTransaction()
////                .add(R.id.fragment_container,poemListFragment)
////                .commit();
//
//    }
//    @TargetApi(19)
//    private void initWindow(){
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
////            //  设置根布局的参数
////            ViewGroup rootView = (ViewGroup) ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
////            ViewCompat.setFitsSystemWindows(rootView,true);
////            rootView.setClipToPadding(true);
//        }
//    }

    @Override
    protected int getLayoutResID() {

        return R.layout.activity_main;
    }
    @Override
    protected Fragment getFragment() {
        return new PoemListFragment();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPoemSelected(int PoemID) {

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentByTag("1");
        if (fragment == null) {
            fragment = new PoemFragment();
            fm.beginTransaction()
                    .replace(fragment_container, fragment)
                    .addToBackStack("1")
                    .commit();
        }

//        Fragment fragment = new PoemFragment();
//        fm.beginTransaction()
//                .replace(fragment_container, fragment)
//                .addToBackStack("1")
//                .commit();
    }
    @Override
    public void onTextSelected(int TextID) {
        FragmentManager fm=getSupportFragmentManager();
        Fragment fragment=fm.findFragmentByTag("2");
        if(fragment == null) {
            fragment = new PoemListFragment();
            fm.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack("2")
                    .commit();
        }

    }
}
