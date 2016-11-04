package com.pinocchio2mx.threehundredtangpoems;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.pinocchio2mx.threehundredtangpoems.fragment.PoemFragment;
import com.pinocchio2mx.threehundredtangpoems.fragment.PoemListFragment;
import com.pinocchio2mx.threehundredtangpoems.model.Poem;


import static android.R.attr.fragment;
import static com.pinocchio2mx.threehundredtangpoems.R.id.fragment_container;

public class MainActivity extends BaseFragmentActivity
        implements PoemListFragment.OnPoemSelectedListener,
        PoemFragment.OnTextSelectedListener {
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

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
////        fragment poemListFragment = new PoemListFragment();
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
    public void onPoemSelected(Poem poem) {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment = fm.findFragmentByTag("2");

        if (fragment == null) {
//            fragment = new PoemFragment();
              fragment = PoemFragment.newInstance(poem);
        }

//        ft.setCustomAnimations( android.R.anim.fade_in,android.R.anim.fade_out);
        ft.addToBackStack(null);
        ft.hide(fm.findFragmentByTag("1"));
        ft.add(fragment_container, fragment,"2");
        ft.commit();
    }

    @Override
    public void onTextSelected(int TextID) {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentByTag("2");
        if (fragment == null) {
            fragment = new PoemListFragment();
        }
        fm.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack("2")
                .commit();
    }
}

