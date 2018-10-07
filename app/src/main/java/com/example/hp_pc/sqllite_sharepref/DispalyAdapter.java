package com.example.hp_pc.sqllite_sharepref;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DispalyAdapter extends RecyclerView.Adapter<DispalyAdapter.MyViewHolder> {


    List<Profile> profileList= new ArrayList<>();
    Context context;
    DatabaseHelper databaseHelper;


    public DispalyAdapter(List<Profile> profileList, Context context) {
        this.profileList = profileList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_row,parent,false);

        MyViewHolder myViewHolder =new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        databaseHelper =new DatabaseHelper(context);
                 final Profile profile ;
                 profile=   profileList.get(position);
                 holder.proflilename.setText(profile.getName());
                 holder.details.setText(profile.getAge());

                 byte[] bitmapimg= profile.getImage();
                 Bitmap bitmap   = BitmapFactory.decodeByteArray(bitmapimg,0,bitmapimg.length);
                 holder.profileimg.setImageBitmap(bitmap);

                  holder.listrow.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View view) {

                          Intent i =new Intent(context,Showimg.class);
                          i.putExtra("imgobj", profileList.get(position));
                          context.startActivity(i);

                      }
                  });

                 holder.listrow.setOnLongClickListener(new View.OnLongClickListener() {
                     @Override
                     public boolean onLongClick(View view) {

                         Toast.makeText(context,"hmmm!"+profileList.get(position).getName(),Toast.LENGTH_LONG).show();
                         //display dialog
                         CharSequence[] charSequences={"Update","Delete"};
                         AlertDialog.Builder builder =new AlertDialog.Builder(context);
                         builder.setTitle("Choose Option");
                         builder.setItems(charSequences, new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialogInterface, int i) {

                                 if(i==0)
                                 {
                                     //update

                                     try
                                     {


                                      Profile profile12 =   profileList.get(position);

                                        profile12.setName("Ram");
                                        profile12.setAge("Jay");
                                        profile12.setImage(profile12.getImage());
                                        // profile12=new Profile("Ram","Jay",profile12.getImage());
                                         databaseHelper.updateprofile(profile12);
                                         Toast.makeText(context,"data updated",Toast.LENGTH_LONG).show();
                                         notifyDataSetChanged();
                                     }
                                     catch (Exception e)
                                     {
                                         e.printStackTrace();

                                         Log.e("sqliteerror", "exception", e);
                                         Toast.makeText(context,"error",Toast.LENGTH_LONG).show();
                                     }

                                 }
                                 else if(i==1)
                                 {
                                     //delete

                                     try
                                     {


                                        // profile=   profileList.get(position);

                                         databaseHelper.deleteprofile(profile);
                                         profileList.remove(position);
                                         Toast.makeText(context,"delted",Toast.LENGTH_LONG).show();
                                         notifyDataSetChanged();
                                     }
                                     catch (Exception e)
                                     {
                                         e.printStackTrace();

                                         Log.e("sqliteerror", "exception", e);
                                         Log.e("sqliteerror", "exception", e);
                                         Toast.makeText(context,"error",Toast.LENGTH_LONG).show();
                                     }



                                 }

                             }
                         });

                         builder.show();
                         return true;
                     }
                 });


    }

    @Override
    public int getItemCount() {
        return profileList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView profileimg;
        TextView proflilename,details;
        RelativeLayout listrow;


        public MyViewHolder(View view) {
            super(view);

                proflilename= view.findViewById(R.id.profilename);
                details = view.findViewById(R.id.Details);
                profileimg =view.findViewById(R.id.profileimg);
                listrow  =view.findViewById(R.id.listrow);
                view.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {

//            Intent j= new Intent(context,Showimg.class);
//            Bundle bundle =new Bundle();
//                      profileList.get(i);
//
//            bundle.putByteArray();
//            context.startActivity(j);
        }


    }


}
