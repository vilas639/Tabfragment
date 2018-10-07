package com.example.hp_pc.sqllite_sharepref;

import android.arch.core.executor.TaskExecutor;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Suceess extends AppCompatActivity implements View.OnClickListener {


    private TextView Profilename;
    private Button logout,btnSqllite;
  private SharePref  sharePref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suceess);

        Profilename =(TextView) findViewById(R.id.profilename);
        logout =(Button) findViewById(R.id.logout);
        btnSqllite =(Button) findViewById(R.id.btnsqllite);

        sharePref =new SharePref(getApplicationContext());


        logout.setOnClickListener(this);
        btnSqllite.setOnClickListener(this);

           Profilename.setText("Welcome"+getResources().getString(R.string.username1));
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.logout:
                Intent i=new Intent(this,MainActivity.class);
                   startActivity(i);
                   sharePref.getWriteData(false);
                   finish();
                break;
            case R.id.btnsqllite:
                Intent j =new Intent(this,ImageTextActivity.class);
                startActivity(j);
                break;
              default:
        }

    }
}
