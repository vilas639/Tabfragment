package com.example.hp_pc.sqllite_sharepref;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.hp_pc.sqllite_sharepref.TabFragment.TabFragment1;
import com.example.hp_pc.sqllite_sharepref.TabFragment.TabFragment2;

public class FragmentTabActivity extends AppCompatActivity  implements TabFragment1.SendMessage1{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_tab);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page

          PagerAdapter pagerAdapter =new com.example.hp_pc.sqllite_sharepref.TabFragment.PagerAdapter(getSupportFragmentManager(),this);

        // Set the adapter onto the view pager
        viewPager.setAdapter(pagerAdapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);

        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void SendData(String msg) {

        String tag = "android:switcher:" + R.id.viewpager  + ":" + 1;

        TabFragment2 tabFragment2 =(TabFragment2) getSupportFragmentManager().findFragmentByTag(tag);

        tabFragment2.displayReceivedData(msg);
    }
}
