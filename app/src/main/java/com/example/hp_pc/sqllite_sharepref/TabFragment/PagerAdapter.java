package com.example.hp_pc.sqllite_sharepref.TabFragment;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.hp_pc.sqllite_sharepref.R;

public class PagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    public PagerAdapter(FragmentManager fm,Context context) {
        super(fm);
        mContext = context;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new TabFragment1();
        } else if (position == 1){
            return new TabFragment2();
        } else if (position == 2){
            return new TabFragment3();
        } else {
            return new TabFragment4();
        }
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 4;
    }

    // This determines the title for each tab


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.tab1);
            case 1:
                return mContext.getString(R.string.tab2);
            case 2:
                return mContext.getString(R.string.tab3);
            case 3:
                return mContext.getString(R.string.tab4);
            default:
                return null;
        }
    }
}
