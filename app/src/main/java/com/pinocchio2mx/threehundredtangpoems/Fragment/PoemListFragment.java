package com.pinocchio2mx.threehundredtangpoems.fragment;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.pinocchio2mx.threehundredtangpoems.PoemPagerActivity;
import com.pinocchio2mx.threehundredtangpoems.adapter.PoemAdapter;
import com.pinocchio2mx.threehundredtangpoems.adapter.PoemListAdapter;
import com.pinocchio2mx.threehundredtangpoems.adapter.RecyclerViewCursorAdapter;
import com.pinocchio2mx.threehundredtangpoems.databse.PoemDatabase;
import com.pinocchio2mx.threehundredtangpoems.model.Poem;
import com.pinocchio2mx.threehundredtangpoems.model.PoemLab;
import com.pinocchio2mx.threehundredtangpoems.R;

import java.util.List;

import static com.pinocchio2mx.threehundredtangpoems.R.id.toolbar;

public class PoemListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Typeface mTypeface;

    private OnPoemSelectedListener mListener;
    private RecyclerView mPoemListRecyclerView;
    //private PoemAdapter mAdapter;
    private PoemListAdapter mAdapter;
    private Button mButton;
    private Toolbar mToolbar;
    AppCompatActivity mAppCompatActivity;

    private PoemDatabase db;
    private Cursor cursor;




    public PoemListFragment() {
        // Required empty public constructor
    }


    public static PoemListFragment newInstance(String param1, String param2) {
        PoemListFragment fragment = new PoemListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_poem_list, container, false);


        setHasOptionsMenu(true);
        mToolbar = (Toolbar)v.findViewById(R.id.toolbar);
        AppCompatActivity mAppCompatActivity = (AppCompatActivity)getActivity();
        mAppCompatActivity.setSupportActionBar(mToolbar);




        mPoemListRecyclerView = (RecyclerView)v.findViewById(R.id.poem_list_recyclerview);
        mPoemListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        if (mTypeface == null) {
//            mTypeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/simsun.ttc");
//        }
        updateUI();
        return  v;
    }

    private void updateUI() {
//        PoemLab poemlab = PoemLab.get(getActivity());
//        List<Poem> poems = poemlab.getPoems();
        if(mAdapter == null ){
            db = new PoemDatabase(getContext());
            cursor= db.getPoems();
            mAdapter = new PoemListAdapter(getContext(),cursor,0);
            //mAdapter = new PoemAdapter(poems);
            mPoemListRecyclerView.setAdapter(mAdapter);
        }else{
            mPoemListRecyclerView.setAdapter(mAdapter);
        }
    }

<<<<<<< HEAD


=======


>>>>>>> 024d67cd515d96232e18032ed2bea7456a52441f


    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onPoemSelected( );
//        }
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnPoemSelectedListener) {
            mListener = (OnPoemSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        //updateUI();
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        cursor.close();
        db.close();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_fragment_poem_list,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public interface OnPoemSelectedListener {
        // TODO: Update argument type and name
        void onPoemSelected(Poem poem);
    }


}
