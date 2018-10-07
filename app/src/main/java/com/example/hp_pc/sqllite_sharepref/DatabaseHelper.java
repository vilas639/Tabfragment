package com.example.hp_pc.sqllite_sharepref;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.TabLayout;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

      public static  final  int dbversion=1;
      public static  final  String Tablename="ProfileTable";
      public static  final  String dbname="profile.db";


    private static final String PKID="id";
    private static final String NAME="name";
    private static final String AGE="age";
    private static final String  PROFILEIMAGE="profileimage";

    String CreateProfile ="CREATE TABLE IF NOT EXISTS "+Tablename+"("+PKID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" TEXT, "+AGE+" TEXT, "+PROFILEIMAGE+" BLOB)";


    public DatabaseHelper(Context context) {
        super(context, dbname, null, dbversion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(CreateProfile);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Tablename);
        onCreate(sqLiteDatabase);
    }

    //add profile

    public void addProfile(Profile profile)
    {
        SQLiteDatabase sqLiteDatabase =this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(NAME,profile.getName());
        contentValues.put(AGE,profile.getAge());
        contentValues.put(PROFILEIMAGE,profile.getImage());

        sqLiteDatabase.insert(Tablename,null,contentValues);

        sqLiteDatabase.close();
    }


    //update profile

    public int updateprofile(Profile profile)
    {
        SQLiteDatabase sqLiteDatabase =this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(NAME,profile.getName());
        contentValues.put(AGE,profile.getAge());
        contentValues.put(PROFILEIMAGE,profile.getImage());

        return sqLiteDatabase.update(Tablename,contentValues,PKID+" =? ",new String[]{String.valueOf(profile.getId())});

    }

    //read all data
    public List<Profile> getAllProfile()
    {
        SQLiteDatabase sqLiteDatabase =this.getWritableDatabase();
        //creata arraylist
        List<Profile> profileslist =new ArrayList<>();

        String selectall ="SELECT * FROM "+ Tablename+"";

        Cursor cursor   =sqLiteDatabase.rawQuery(selectall,null);

        if(cursor.moveToFirst())
        {
            do {
                Profile profile =new Profile();
                profile.setId(Integer.parseInt(cursor.getString(0)));
                profile.setName(cursor.getString(1));
                profile.setAge(cursor.getString(2));
                profile.setImage(cursor.getBlob(3));

                profileslist.add(profile);
            }
            while (cursor.moveToNext());
        }
        return profileslist;
    }


    //delete rowe

    public void deleteprofile(Profile profile )
    {
        SQLiteDatabase sqLiteDatabase =this.getWritableDatabase();

        sqLiteDatabase.delete(Tablename,PKID +" =? ",new String [] {String.valueOf(profile.getId())});

        sqLiteDatabase.close();

    }


    // Getting a single computer - read
//    public Computer getComputer(int id) {
//
//        SQLiteDatabase database = this.getReadableDatabase();
//        Cursor cursor = database.query(TABLE_COMPUTER, new String[]{COLUMN_ID,
//                        COLUMN_COMPUTER_NAME, COLUMN_COMPUTER_TYPE},
//                COLUMN_ID + "=?", new String[]{String.valueOf(id)}, null, null, null);
//
//
//        if (cursor != null)  {
//            cursor.moveToFirst();
//        }
//
//        Computer computer = new Computer(Integer.parseInt(cursor.getString(0)),
//                cursor.getString(1), cursor.getString(2));
//        return computer;
//
//
//    }


    // Getting the number of computers

//    public int getComputersCount() {
//        String computersCountQuery = "SELECT * FROM " + TABLE_COMPUTER;
//        SQLiteDatabase database = this.getWritableDatabase();
//        Cursor cursor = database.rawQuery(computersCountQuery, null);
//        cursor.close();
//
//        return cursor.getCount();
//    }


    public byte[] convertbitmaptobyte(ImageView imageView)
    {

        // imageView.setImageResource(R.drawable.ic_launcher_background);

        Bitmap bitmap =((BitmapDrawable)imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream byteArrayOutputStream =new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,byteArrayOutputStream);
        byte[] bytesarray =byteArrayOutputStream.toByteArray();


        return  bytesarray;
    }
}
