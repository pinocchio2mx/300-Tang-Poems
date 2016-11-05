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

<<<<<<< HEAD
import com.pinocchio2mx.threehundredtangpoems.MainActivity;
import com.pinocchio2mx.threehundredtangpoems.PoemPagerActivity;
import com.pinocchio2mx.threehundredtangpoems.R;
import com.pinocchio2mx.threehundredtangpoems.fragment.PoemListFragment;
import com.pinocchio2mx.threehundredtangpoems.model.Poem;

import static com.pinocchio2mx.threehundredtangpoems.PoemPagerActivity.newIntent;

=======
import com.pinocchio2mx.threehundredtangpoems.PoemPagerActivity;
import com.pinocchio2mx.threehundredtangpoems.R;
import com.pinocchio2mx.threehundredtangpoems.model.Poem;

>>>>>>> 024d67cd515d96232e18032ed2bea7456a52441f
/**
 * Created by pinocchio2mx on 2016/11/3.
 */

public class PoemListAdapter extends RecyclerViewCursorAdapter<PoemListAdapter.PoemListHolder> {

<<<<<<< HEAD
    private Context mContext;

    public PoemListAdapter(Context context, Cursor c, int flags) {
        super(c);
        mContext =context;
=======
    public PoemListAdapter(Context context, Cursor c, int flags) {
        super(c);
>>>>>>> 024d67cd515d96232e18032ed2bea7456a52441f
    }

    @Override
    public PoemListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.poem_list_item, parent, false);
        return new PoemListHolder(v);
    }

    @Override
    public void onBindViewHolderCursor(final  PoemListHolder holder, Cursor cursor) {
<<<<<<< HEAD
        holder.bindPoem(cursor);
//        holder.mTitleTextView.setText(cursor.getString(cursor.getColumnIndex("work_title")));
//        holder.mAuthorTextView.setText(cursor.getString(cursor.getColumnIndex("work_author")));
=======
        //holder.bindPoem(cursor);
        holder.mTitleTextView.setText(cursor.getString(cursor.getColumnIndex("work_title")));
        holder.mAuthorTextView.setText(cursor.getString(cursor.getColumnIndex("work_author")));
>>>>>>> 024d67cd515d96232e18032ed2bea7456a52441f
    }

    @Override
    protected void onContentChanged() {
        //intensionally left blank

    }




<<<<<<< HEAD
    public  class PoemListHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{
=======
    public static class PoemListHolder extends RecyclerView.ViewHolder {
>>>>>>> 024d67cd515d96232e18032ed2bea7456a52441f
        private TextView mTitleTextView;
        private TextView mAuthorTextView;
        private TextView mContenTextView;
        private Cursor mCursor;
<<<<<<< HEAD
        private Poem mPoem;

        public PoemListHolder(View itemview) {
            super(itemview);
            itemview.setOnClickListener(this);
=======

        public PoemListHolder(View itemview) {
            super(itemview);
>>>>>>> 024d67cd515d96232e18032ed2bea7456a52441f
            mTitleTextView = (TextView)itemview.findViewById(R.id.title_textview);
            mAuthorTextView = (TextView)itemview.findViewById(R.id.author_textview);
            //mContenTextView. = (TextView)itemview.findViewById(R.id.content_textview);
        }

        public void bindPoem(final Cursor cursor){
<<<<<<< HEAD
            mCursor = cursor;

            String title = mCursor.getString(mCursor.getColumnIndex("work_title"));
            String author = mCursor.getString(mCursor.getColumnIndex("work_author"));
            String content = mCursor.getString(mCursor.getColumnIndex("work_content"));
            mPoem = new Poem(title , author , content);
            mTitleTextView.setText(cursor.getString(cursor.getColumnIndex("work_title")));
            mAuthorTextView.setText(cursor.getString(cursor.getColumnIndex("work_author")));
            //mContenTextView.setText(cursor.getString(cursor.getColumnIndex("work_content")));
        }

        @Override
        public void onClick(View v) {

            PoemListFragment.OnPoemSelectedListener mListener = (PoemListFragment.OnPoemSelectedListener) mContext;
            mListener.onPoemSelected(mPoem);
//            Intent i = new Intent(mContext,PoemPagerActivity.class);
//            mContext.startActivity(i);

            //ToastUitl.showToast(getActivity(),mPoem.getTitle()+" clicked !",Toast.LENGTH_SHORT);
=======
            mTitleTextView.setText(cursor.getString(cursor.getColumnIndex("work_title")));
            mAuthorTextView.setText(cursor.getString(cursor.getColumnIndex("work_author")));
            //mContenTextView.setText(mCursor.getString(mCursor.getColumnIndex("work_content")));
>>>>>>> 024d67cd515d96232e18032ed2bea7456a52441f
        }

    }


}