package com.reverse5minds.qilla.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.reverse5minds.qilla.R;

/**
 * Created by Varun on 23-08-2016.
 */
public class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    public static String ARG_SECTION_NUMBER = "section_number";

    int imagess[] = {R.drawable.pic3, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5};

    public PlaceholderFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_shops_list, container, false);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.menupic);
        imageView.setImageResource(imagess[getArguments().getInt(ARG_SECTION_NUMBER) - 1]);
        return rootView;
    }
}
