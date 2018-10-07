package com.example.hp_pc.sqllite_sharepref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

       public EditText username,password;
       public CheckBox remmeberme;
       public Button login;
       private SharePref   sharePref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username =(EditText) findViewById(R.id.username);
        password =(EditText) findViewById(R.id.password);
        remmeberme=(CheckBox) findViewById(R.id.rememberme);
        login =(Button) findViewById(R.id.login);
        login.setOnClickListener(this);
         remmeberme.setOnCheckedChangeListener(this);
        sharePref =new SharePref(getApplicationContext());

        if(sharePref.getReadData())
        {
            Intent i=new Intent(this,Suceess.class);
            startActivity(i);
            finish();
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.login:
               if(username.getText().toString().equals(getResources().getString(R.string.username1)) && password.getText().toString().equals(getResources().getString(R.string.password1)))
               {
                   Intent i=new Intent(this,Suceess.class);
                   startActivity(i);
                  //  sharePref.getWriteData(true);
                   finish();
               }
               else
               {
                   Toast.makeText(this, "Wrong Username or Password", Toast.LENGTH_SHORT).show();
                   username.setText("");
                   password.setText("");
               }

                break;
            default:
        }
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


        switch (compoundButton.getId())
        {
            case    R.id.rememberme:
                if(username.getText().toString().equals(getResources().getString(R.string.username1)) && password.getText().toString().equals(getResources().getString(R.string.password1)))
                {


                    sharePref.getWriteData(true);

                }
                else
                {
                    Toast.makeText(this, "Please Select Right Username", Toast.LENGTH_SHORT).show();
                }

                break;
             default:
        }
    }
}
