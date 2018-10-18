package com.example.hp_pc.sqllite_sharepref.TabFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp_pc.sqllite_sharepref.DatabaseHelper;
import com.example.hp_pc.sqllite_sharepref.DispalyAdapter;
import com.example.hp_pc.sqllite_sharepref.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment3 extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    DatabaseHelper databaseHelper;
    List<Emp> emplist =new ArrayList<>();
    DispalyEmpAdapter dispalyEmpAdapter;
    public TabFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_tab_fragment3, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview1);

        layoutManager =new LinearLayoutManager(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);


        databaseHelper =new DatabaseHelper(getActivity());
        emplist =databaseHelper.getAllEmp();
        if(emplist.size()>0)
        {
            dispalyEmpAdapter =new DispalyEmpAdapter(emplist,getContext());
            recyclerView.setAdapter(dispalyEmpAdapter);
            dispalyEmpAdapter.notifyDataSetChanged();
        }
        else
        {
            Toast.makeText(getContext(),"No record found",Toast.LENGTH_LONG).show();
        }


        return  view;
    }

}
