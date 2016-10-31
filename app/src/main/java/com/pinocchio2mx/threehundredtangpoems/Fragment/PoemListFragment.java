package com.pinocchio2mx.threehundredtangpoems.Fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.MenuPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.pinocchio2mx.threehundredtangpoems.Activity.PoemPagerActivity;
import com.pinocchio2mx.threehundredtangpoems.CommnenUtils;
import com.pinocchio2mx.threehundredtangpoems.Model.Poem;
import com.pinocchio2mx.threehundredtangpoems.Model.PoemLab;
import com.pinocchio2mx.threehundredtangpoems.R;

import org.w3c.dom.Text;

import java.util.List;

import static android.R.attr.autoAdvanceViewId;
import static android.R.attr.onClick;
import static android.R.attr.typeface;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static android.os.Build.VERSION_CODES.M;
import static com.pinocchio2mx.threehundredtangpoems.CommnenUtils.showToast;

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
    private PoemAdapter mAdapter;
    private Button mButton;


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
        View view = inflater.inflate(R.layout.fragment_poem_list, container, false);

        mButton = (Button) view.findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                DatePickerFragment dialog = new DatePickerFragment();
                dialog.show(fm,"Date");

                //mListener.onPoemSelected(1);
            }
        });

        mPoemListRecyclerView = (RecyclerView)view.findViewById(R.id.poem_list_recyclerview);
        mPoemListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        if (mTypeface == null) {
            mTypeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/simsun.ttc");
        }
        updateUI();
        return  view;
    }

    private void updateUI() {
        PoemLab poemlab = PoemLab.get(getActivity());
        List<Poem> poems = poemlab.getPoems();
        if(mAdapter == null ){
            mAdapter = new PoemAdapter(poems);
            mPoemListRecyclerView.setAdapter(mAdapter);
        }else{
            mPoemListRecyclerView.setAdapter(mAdapter);
        }
    }

    private class PoemHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener{
        private TextView mTitleTextView;
        private TextView mAuthorTextView;
        private TextView mContenTextView;
        private Poem mPoem;


        public PoemHolder(View itemview){
            super(itemview);
            itemview.setOnClickListener(this);
            mTitleTextView = (TextView)itemview.findViewById(R.id.title_textview);
            mAuthorTextView = (TextView)itemview.findViewById(R.id.author_textview);
            mContenTextView = (TextView)itemview.findViewById(R.id.content_textview);
            mContenTextView.setTypeface(mTypeface);

        }
        public void bindPoem(Poem poem){
            mPoem = poem;
            mTitleTextView.setText(poem.getTitle());
            mAuthorTextView.setText(poem.getAuthor());
            mContenTextView.setText(poem.getContent());
        }

        @Override
        public void onClick(View v) {
            Intent i = PoemPagerActivity.newIntent(getActivity());
            startActivity(i);
            //mListener.onPoemSelected(1);
            //CommnenUtils.showToast(getActivity(),mPoem.getTitle()+" clicked !",Toast.LENGTH_SHORT);
        }
    }
    private class PoemAdapter extends RecyclerView.Adapter<PoemHolder>{
        private List<Poem> mPoems;

        public PoemAdapter(List<Poem> poems) {
            mPoems = poems;
        }

        @Override
        public PoemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.poem_list_item,parent,false);
            return new PoemHolder(view);
        }

        @Override
        public void onBindViewHolder(PoemHolder holder, int position) {
            Poem poem = mPoems.get(position);
            holder.bindPoem(poem);

        }

        @Override
        public int getItemCount() {
            return mPoems.size();
        }
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onPoemSelected(1);
        }
    }

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
    }


    public interface OnPoemSelectedListener {
        // TODO: Update argument type and name
        void onPoemSelected(int PoemID);
    }


}
