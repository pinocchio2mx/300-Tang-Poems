package com.pinocchio2mx.threehundredtangpoems.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pinocchio2mx.threehundredtangpoems.PoemPagerActivity;
import com.pinocchio2mx.threehundredtangpoems.R;
import com.pinocchio2mx.threehundredtangpoems.model.Poem;

/**
 * Created by pinocchio2mx on 2016/11/3.
 */

public class PoemListAdapter extends RecyclerViewCursorAdapter<PoemListAdapter.PoemListHolder> {

    public PoemListAdapter(Context context, Cursor c, int flags) {
        super(c);
    }

    @Override
    public PoemListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.poem_list_item, parent, false);
        return new PoemListHolder(v);
    }

    @Override
    public void onBindViewHolderCursor(final  PoemListHolder holder, Cursor cursor) {
        //holder.bindPoem(cursor);
        holder.mTitleTextView.setText(cursor.getString(cursor.getColumnIndex("work_title")));
        holder.mAuthorTextView.setText(cursor.getString(cursor.getColumnIndex("work_author")));
    }

    @Override
    protected void onContentChanged() {
        //intensionally left blank

    }




    public static class PoemListHolder extends RecyclerView.ViewHolder {
        private TextView mTitleTextView;
        private TextView mAuthorTextView;
        private TextView mContenTextView;
        private Cursor mCursor;

        public PoemListHolder(View itemview) {
            super(itemview);
            mTitleTextView = (TextView)itemview.findViewById(R.id.title_textview);
            mAuthorTextView = (TextView)itemview.findViewById(R.id.author_textview);
            //mContenTextView. = (TextView)itemview.findViewById(R.id.content_textview);
        }

        public void bindPoem(final Cursor cursor){
            mTitleTextView.setText(cursor.getString(cursor.getColumnIndex("work_title")));
            mAuthorTextView.setText(cursor.getString(cursor.getColumnIndex("work_author")));
            //mContenTextView.setText(mCursor.getString(mCursor.getColumnIndex("work_content")));
        }

    }


}