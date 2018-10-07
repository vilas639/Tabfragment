package com.example.hp_pc.sqllite_sharepref;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.Display;

public class SharePref {

   private SharedPreferences   sharedPreferences;
   private Context context;

    public SharePref(Context context) {

        this.context = context;
        this.sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.save_key),Context.MODE_PRIVATE);
    }


    public void getWriteData(boolean status)
    {

        SharedPreferences.Editor   editor =sharedPreferences.edit();
        editor.putBoolean(context.getResources().getString(R.string.save_status),status);
        editor.commit();

    }


    public boolean getReadData()
    {
        boolean status =false;

        status= sharedPreferences.getBoolean(context.getResources().getString(R.string.save_status),false);
        return  status;
    }


}
