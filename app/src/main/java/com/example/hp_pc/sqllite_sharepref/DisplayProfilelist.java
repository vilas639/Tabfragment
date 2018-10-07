package com.example.hp_pc.sqllite_sharepref;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DisplayProfilelist extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    List<Profile> profileList= new ArrayList<>();
    DispalyAdapter dispalyAdapter;
    ImageView imageView ;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_profilelist);

        recyclerView =findViewById(R.id.recyclerview);

        layoutManager =new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);


        databaseHelper =new DatabaseHelper(this);
        profileList =databaseHelper.getAllProfile();
        if(profileList.size()>0)
        {
            dispalyAdapter =new DispalyAdapter(profileList,this);
            recyclerView.setAdapter(dispalyAdapter);
            dispalyAdapter.notifyDataSetChanged();
        }
        else
        {
            Toast.makeText(this,"No record found",Toast.LENGTH_LONG).show();
        }



    }
}
