package com.example.hp_pc.sqllite_sharepref.TabFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp_pc.sqllite_sharepref.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment2 extends Fragment {

    String value="";
    public TabFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_tab_fragment2, container, false);
        TextView txt2 = (TextView) view.findViewById(R.id.txtname);
        Button btnsendthird = (Button) view.findViewById(R.id.btnsend2);
        Bundle bundle = getArguments();
        if(bundle!= null)
        {
            value = getArguments().getString("username");
            txt2.setText(value);
        }

        btnsendthird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),""+value,Toast.LENGTH_LONG).show();
            }
        });
        return  view;
    }


    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getContext(),"onResume gets called",Toast.LENGTH_LONG).show();
    }
}
