package com.pinocchio2mx.threehundredtangpoems.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pinocchio2mx.threehundredtangpoems.PoemPagerActivity;
import com.pinocchio2mx.threehundredtangpoems.R;
import com.pinocchio2mx.threehundredtangpoems.model.Poem;

import java.util.List;

/**
 * Created by pinocchio2mx on 2016/11/4.
 */

public class PoemAdapter extends RecyclerView.Adapter<PoemAdapter.PoemHolder>{
    private List<Poem> mPoems;

    public PoemAdapter(List<Poem> poems) {
        mPoems = poems;
    }

    @Override
    public PoemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
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



    public class PoemHolder extends RecyclerView.ViewHolder
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
//            mContenTextView.setTypeface(mTypeface);

        }
        public void bindPoem(Poem poem){
            mPoem = poem;
            mTitleTextView.setText(poem.getTitle());
            mAuthorTextView.setText(poem.getAuthor());
            mContenTextView.setText(poem.getContent());
        }

        @Override
        public void onClick(View v) {
//            Intent i = PoemPagerActivity.newIntent(getActivity());
//            startActivity(i);
            //mListener.onPoemSelected(1);
            //ToastUitl.showToast(getActivity(),mPoem.getTitle()+" clicked !",Toast.LENGTH_SHORT);
        }
    }
}
