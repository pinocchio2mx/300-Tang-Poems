package com.pinocchio2mx.threehundredtangpoems.fragment;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pinocchio2mx.threehundredtangpoems.R;
import com.pinocchio2mx.threehundredtangpoems.model.Poem;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PoemFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PoemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PoemFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private Poem mPoem;
    private String mParam2;

    private OnTextSelectedListener mListener;

    private static Typeface mTypeface;

    private TextView vTitle;
    private TextView vAuthor;
    private TextView vContent;



    public PoemFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PoemFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PoemFragment newInstance(Poem poem) {
        PoemFragment fragment = new PoemFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1 , poem);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPoem = (Poem)getArguments().getSerializable(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_poem, container, false);
        vTitle = (TextView)v.findViewById(R.id.work_title);
        vAuthor =(TextView)v.findViewById(R.id.work_info);

        vContent =(TextView)v.findViewById(R.id.work_content);


        updateUI();




        return  v;
    }

    private void updateUI() {
        if (mTypeface == null) {
            mTypeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/simsun.ttc");
        }
        vContent.setTypeface(mTypeface);


        vTitle.setText(mPoem.getTitle());
        vAuthor.setText(mPoem.getAuthor());
        vContent.setText(mPoem.getContent());
    }

    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onTextSelected(uri);
//        }
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PoemFragment.OnTextSelectedListener) {
            mListener = (PoemFragment.OnTextSelectedListener) context;
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnTextSelectedListener {
        // TODO: Update argument type and name
        void onTextSelected(int TextID);
    }
}
