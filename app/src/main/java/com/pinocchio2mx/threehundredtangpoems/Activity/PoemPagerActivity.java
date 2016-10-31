package com.pinocchio2mx.threehundredtangpoems.Activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.ShareCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.pinocchio2mx.threehundredtangpoems.Fragment.PoemFragment;
import com.pinocchio2mx.threehundredtangpoems.Model.Poem;
import com.pinocchio2mx.threehundredtangpoems.Model.PoemLab;
import com.pinocchio2mx.threehundredtangpoems.R;

import java.util.List;

public class PoemPagerActivity extends AppCompatActivity
        implements PoemFragment.OnTextSelectedListener{
    private ViewPager mViewPager;
    private List<Poem> mPoems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poem_pager);
        mViewPager = (ViewPager)findViewById(R.id.activity_poem_pager_view_pager);
        mPoems = PoemLab.get(this).getPoems();

        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                return new PoemFragment();
            }

            @Override
            public int getCount() {
                return mPoems.size();
            }
        });
    }

    public static Intent newIntent(Context context){
        Intent i = new Intent(context,PoemPagerActivity.class);
        return i;
    }

    @Override
    public void onTextSelected(int TextID) {
        // intensionallt left blank
    }
}
