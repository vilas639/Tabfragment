package com.example.hp_pc.sqllite_sharepref.TabFragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import com.example.hp_pc.sqllite_sharepref.DatabaseHelper;
import com.example.hp_pc.sqllite_sharepref.Profile;
import com.example.hp_pc.sqllite_sharepref.R;
import com.example.hp_pc.sqllite_sharepref.Showimg;

import java.util.ArrayList;
import java.util.List;

public class DispalyEmpAdapter extends RecyclerView.Adapter<DispalyEmpAdapter.MyViewHolder> {


    List<Emp> emplist= new ArrayList<>();
    Context context;
    DatabaseHelper databaseHelper;


    public DispalyEmpAdapter(List<Emp> emplist, Context context) {
        this.emplist = emplist;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.emp_row,parent,false);

        MyViewHolder myViewHolder =new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        databaseHelper =new DatabaseHelper(context);
                 final Emp emp ;
                 emp=   emplist.get(position);
                 holder.empname.setText(emp.getEmpname());
                 holder.empemail.setText(emp.getEmpemail());



//                  holder.listrow1.setOnClickListener(new View.OnClickListener() {
//                      @Override
//                      public void onClick(View view) {
//
//                          Intent i =new Intent(context,Showimg.class);
//                          i.putExtra("imgobj", profileList.get(position));
//                          context.startActivity(i);
//
//                      }
//                  });

                 holder.listrow1.setOnLongClickListener(new View.OnLongClickListener() {
                     @Override
                     public boolean onLongClick(View view) {

                         Toast.makeText(context,"hmmm!"+emplist.get(position).getEmpname(),Toast.LENGTH_LONG).show();
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


                                      Emp emp2 =   emplist.get(position);

                                        emp2.setEmpname("vilas");
                                        emp2.setEmpemail("vilasjdhv639@gmail.com");

                                         databaseHelper.updateemp(emp2);
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

                                         databaseHelper.deleteemp(emp);
                                         emplist.remove(position);
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
        return emplist.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //ImageView profileimg;
        TextView empname,empemail;
        RelativeLayout listrow1;


        public MyViewHolder(View view) {
            super(view);

            empname= view.findViewById(R.id.empname);
            empemail = view.findViewById(R.id.empemail);
               // profileimg =view.findViewById(R.id.profileimg);
            listrow1  =view.findViewById(R.id.listrow1);
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
