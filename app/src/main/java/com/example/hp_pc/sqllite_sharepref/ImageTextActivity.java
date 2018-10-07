package com.example.hp_pc.sqllite_sharepref;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.drm.DrmStore;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.security.Permission;
import java.util.ArrayList;
import java.util.List;

public class ImageTextActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imgphot;
    Button btnadd,btnlist;
    EditText editname,editdetails;

    DatabaseHelper databaseHelper;
    public  static  int REQUESTGALLERY_CODE=100;

    List<Profile> profileList =new ArrayList<Profile>() ;
    ArrayList<String> Profilename =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_text);

        imgphot =(ImageView) findViewById(R.id.imgphoto);
        editdetails =(EditText) findViewById(R.id.editdetail);
        editname =(EditText) findViewById(R.id.editname) ;
        btnadd =(Button) findViewById(R.id.btnadd);
        btnlist =(Button) findViewById(R.id.btnlist);

        imgphot.setOnClickListener(this);
        btnadd.setOnClickListener(this);
        btnlist.setOnClickListener(this);

         databaseHelper =new DatabaseHelper(ImageTextActivity.this);



    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.btnadd:
                //insert rows
                try
                {
                    Profile  profile =new Profile(editname.getText().toString(),editdetails.getText().toString(),databaseHelper.convertbitmaptobyte(imgphot));
                    profileList.add(profile);
                    databaseHelper.addProfile(profile);
                    Toast.makeText(this,"added sucessfully",Toast.LENGTH_LONG).show();
                }
                catch (Exception e)
                {
                    e.printStackTrace();

                    Log.e("sqliteerror", "exception", e);
                    Toast.makeText(this,"error",Toast.LENGTH_LONG).show();
                }

                break;

            case  R.id.btnlist:
                //show list

                Intent i =new Intent(this,DisplayProfilelist.class);
                startActivity(i);
                break;

            case R.id.imgphoto:
                //pick photo from gallary need permission read
                //access permission in runtime

                ActivityCompat.requestPermissions(
                        ImageTextActivity.this,new String[]{
                                Manifest.permission.READ_EXTERNAL_STORAGE
                        },
                        REQUESTGALLERY_CODE
                );

                break;
            default:
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == REQUESTGALLERY_CODE)
        {
            if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED)
            {
                Intent NewGallary = new Intent(Intent.ACTION_GET_CONTENT);
                NewGallary.setType("image/*");
                startActivityForResult(NewGallary,REQUESTGALLERY_CODE);
            }
            else
            {
                Toast.makeText(this, "Permission Denied Bro! What Happen", Toast.LENGTH_SHORT).show();
            }
            return;
        }


        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUESTGALLERY_CODE && resultCode ==RESULT_OK)
        {
            Uri imguri= data.getData();
            CropImage.activity(imguri).setGuidelines(CropImageView.Guidelines.ON)
                    .setAspectRatio(1,1)
                    .start(this);

        }
        if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE)
        {
            CropImage.ActivityResult activityResult=CropImage.getActivityResult(data);
            if(resultCode == RESULT_OK)
            {
                Uri imguri= activityResult.getUri();
                imgphot.setImageURI(imguri);
            }
            else if(resultCode ==  CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE)
            {
                Exception exception = activityResult.getError();
            }
        }


        super.onActivityResult(requestCode, resultCode, data);
    }



}
