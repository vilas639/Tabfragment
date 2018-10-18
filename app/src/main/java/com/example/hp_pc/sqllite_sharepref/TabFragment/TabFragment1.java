package com.example.hp_pc.sqllite_sharepref.TabFragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.hp_pc.sqllite_sharepref.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment1 extends Fragment {

    private EditText editText;
    private Button btnSendData;

    SendMessage1 SM;

    public interface SendMessage1{
        public void SendData(String msg);
    }

    public TabFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_fragment1, container, false);
        editText = (EditText) view.findViewById(R.id.et_name);
        btnSendData = (Button) view.findViewById(R.id.btn_send);
        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TabFragment2 tabFragment2 =new TabFragment2();

                //Bundle bundle = new Bundle();
                //bundle.putString("username",editText.getText().toString());
                //tabFragment2.setArguments(bundle);
                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.second_frag,tabFragment2).commit();
                SM.SendData(editText.getText().toString());
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            SM = (SendMessage1) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again");
        }
    }
}
