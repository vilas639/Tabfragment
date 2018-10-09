package com.example.hp_pc.sqllite_sharepref;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class FragmentListActivity extends AppCompatActivity {

    FrameLayout fram1,frame2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_list);

        if(findViewById(R.id.frame1)!=null)
        {
            if(savedInstanceState!=null)
            {
                return;
            }


               FragmentPersonForm fragmentPersonForm =new FragmentPersonForm();

               getSupportFragmentManager().beginTransaction().add(R.id.frame1,fragmentPersonForm).commit();


        }
        else if(findViewById(R.id.frame2)!=null)
        {

        }
    }
}
