package com.example.hp_pc.sqllite_sharepref;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPersonForm extends Fragment implements View.OnClickListener {

    private static final int REQUEST_CAPTURE_IMAGE = 100;
    EditText person_url;
    ImageView personimg;
    String imageFilePath;
    Context context;
    public FragmentPersonForm() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         EditText personname,personemail;
        Button personInsert,personUpdate,personDelete,persondisplay,personcamera,persongallary;

        View view =inflater.inflate(R.layout.fragment_fragment_person_form, container, false);
        personname= view.findViewById(R.id.person_name);
        personemail= view.findViewById(R.id.person_email);
        person_url= view.findViewById(R.id.person_url);
        personInsert= view.findViewById(R.id.person_insert);
        personUpdate= view.findViewById(R.id.person_update);
        personDelete= view.findViewById(R.id.person_delete);
        persondisplay= view.findViewById(R.id.person_display);
        personcamera= view.findViewById(R.id.person_camera);
        persongallary= view.findViewById(R.id.person_gallary);
        personimg  = view.findViewById(R.id.person_img);

        personcamera.setOnClickListener(this);
        personInsert.setOnClickListener(this);
        personUpdate.setOnClickListener(this);
        personDelete.setOnClickListener(this);
        persondisplay.setOnClickListener(this);
        persongallary.setOnClickListener(this);



        return  view;
    }

    private void openCameraIntent() {
        Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (pictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            //Create a file to store the image
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File

            }
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(getActivity(), "com.example.hp_pc.sqllite_sharepref.provider", photoFile);
                pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(pictureIntent, REQUEST_CAPTURE_IMAGE);
            }
            else
            {
                Toast.makeText(context,"whats wrong",Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(context,"whats wrong",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == REQUEST_CAPTURE_IMAGE && resultCode == RESULT_OK) {
//            if (data != null && data.getExtras() != null) {
//                Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
//                personimg.setImageBitmap(imageBitmap);
//            }
//        }

        if (resultCode == Activity.RESULT_OK) {
            Bitmap bmImg = BitmapFactory.decodeFile(imageFilePath);
            person_url.setText(imageFilePath);
            personimg.setImageBitmap(bmImg);
        }
        else if(resultCode == Activity.RESULT_CANCELED) {
            // User Cancelled the action
        }
    }


    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        String imageFileName = "IMG_" + timeStamp + "_";
        File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        imageFilePath = image.getAbsolutePath();
        return image;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.person_insert:
                break;
            case R.id.person_update:
                break;
            case R.id.person_delete:
                break;
            case R.id.person_display:
                break;
            case R.id.person_camera:
                openCameraIntent();
                break;
            case R.id.person_gallary:
                break;

        }
    }
}
