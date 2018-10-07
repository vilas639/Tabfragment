package com.example.hp_pc.sqllite_sharepref;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Showimg extends AppCompatActivity {

   Profile profile;

    ImageView showimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showimg);

        showimg =(ImageView) findViewById(R.id.showimg);

        profile= (Profile)getIntent().getSerializableExtra("imgobj");


        byte[] bitmapimg= profile.getImage();
        Bitmap bitmap1   = BitmapFactory.decodeByteArray(bitmapimg,0,bitmapimg.length);
        showimg.setImageBitmap(bitmap1);


    }
}
