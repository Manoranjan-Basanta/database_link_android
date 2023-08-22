package com.example.database_pract;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {

   private static final String DATABASE_NAME="demo_db";
    private static final int DATABASE_VERSION=1;

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_QUERY="CREATE TABLE register(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT,email TEXT, password TEXT,gender TEXT)";
     db.execSQL(CREATE_TABLE_QUERY);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS register" );
    onCreate(db);
    }
    public boolean registerUserHelper(String name1,String email1,String pass1,String gender1)
    {
    SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
     ContentValues contentValues=new ContentValues();
     contentValues.put("name",name1);
     contentValues.put("email",email1);
     contentValues.put("password",pass1);
     contentValues.put("gender",gender1);
  Long l= sqLiteDatabase.insert("register",null,contentValues);
   sqLiteDatabase.close();
   //if you can do it boolean type
  if (l>0)
  {
  return true;
  }
   else {
   return false;
  }

    }
    boolean loggedin;
    public  boolean login(String email1,String pass1)
    {
       SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();
     Cursor cursor= sqLiteDatabase.rawQuery("SELECT * FROM register WHERE email='"+email1+"'AND password='"+pass1+"'" ,null);
     if (cursor.moveToFirst())
     {
    loggedin=true;
     }
     else
     {
       loggedin=false;
     }
     return loggedin;
    }
    public ArrayList<UserModel> getLoggedInUserDetails(String email1)
    {
        ArrayList<UserModel>al=new ArrayList<>();
     SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();
     String query="SELECT * FROM register WHERE email='"+email1+"'";
     Cursor cursor=sqLiteDatabase.rawQuery(query,null);
     if (cursor.moveToFirst())
     {
       String name=  cursor.getString(1);
       String email=  cursor.getString(2);
       String gender=  cursor.getString(4);
       UserModel userModel=new UserModel();
       userModel.setName(name);
       userModel.setEmail(email);
       userModel.setGender(gender);
  al.add(userModel);
     }
return al;
    }
    public void getAllUserDetailsHelper() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM register", null);
        cursor.moveToFirst();
        {
            do {
                String name = cursor.getString(1);
                String email = cursor.getString(2);
                String gender = cursor.getString(4);
            }
            while (cursor.moveToNext());
        }
    }
}
