package com.example.hp_pc.sqllite_sharepref.TabFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp_pc.sqllite_sharepref.DatabaseHelper;
import com.example.hp_pc.sqllite_sharepref.Profile;
import com.example.hp_pc.sqllite_sharepref.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment2 extends Fragment {

    String value="";
    TextView txt2;
    DatabaseHelper databaseHelper;
    List<Emp> emplist =new ArrayList<>();
    DispalyEmpAdapter dispalyEmpAdapter;
    public TabFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_tab_fragment2, container, false);
        txt2 = (TextView) view.findViewById(R.id.txtname);
        Button btnsendthird = (Button) view.findViewById(R.id.btnsend2);
        databaseHelper =new DatabaseHelper(getActivity());

        btnsendthird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEmp();

            }
        });
        return  view;
    }


    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getContext(),"onResume gets called",Toast.LENGTH_LONG).show();
    }

    public void displayReceivedData(String message)
    {
        txt2.setText("Data received: "+message);
    }



    public void  addEmp()
    {
        try
        {

            Emp emp =new Emp(txt2.getText().toString(),"ok");
            emplist.add(emp);
            databaseHelper.addEmp(emp);

            Toast.makeText(getContext(),"added sucessfully emp",Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            e.printStackTrace();

            Log.e("sqliteerror", "exception", e);
            Toast.makeText(getContext(),"error",Toast.LENGTH_LONG).show();
        }

    }
}
