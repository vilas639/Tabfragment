package com.example.hp_pc.sqllite_sharepref.TabFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp_pc.sqllite_sharepref.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment2 extends Fragment {


    public TabFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_tab_fragment2, container, false);
        return  rootView;
    }

}