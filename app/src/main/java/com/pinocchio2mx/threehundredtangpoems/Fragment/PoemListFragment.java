package com.pinocchio2mx.threehundredtangpoems.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
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

import com.pinocchio2mx.threehundredtangpoems.Model.Poem;
import com.pinocchio2mx.threehundredtangpoems.Model.PoemLab;
import com.pinocchio2mx.threehundredtangpoems.R;

import org.w3c.dom.Text;

import java.util.List;

import static android.R.attr.onClick;

public class PoemListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnPoemSelectedListener mListener;
    private Toolbar mToolbarContainer;
    private Button mButton;
    private RecyclerView mPoemListRecyclerView;
    private PoemAdapter mAdapter;


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
        //mToolbarContainer = (Toolbar) view.findViewById(R.id.toolbar);
        mPoemListRecyclerView = (RecyclerView)view.findViewById(R.id.poem_list_recyclerview);
        mPoemListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));














        updateUI();











        return  view;
    }

    private void updateUI() {
        PoemLab poemlab = PoemLab.get(getActivity());
        List<Poem> poems = poemlab.getPoems();
        mAdapter = new PoemAdapter(poems);
        mPoemListRecyclerView.setAdapter(mAdapter);
    }

    private class PoemHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener{
        public TextView mTitleTextView;

        public PoemHolder(View itemview){
            super(itemview);
            itemview.setOnClickListener(this);
            mTitleTextView=(TextView)itemview;

        }

        @Override
        public void onClick(View v) {
            mListener.onPoemSelected(1);
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
            holder.mTitleTextView.setText(poem.getTitle());

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
