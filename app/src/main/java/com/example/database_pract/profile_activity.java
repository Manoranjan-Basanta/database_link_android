package com.example.database_pract;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class profile_activity extends AppCompatActivity {
   private  String email1;
    TextView profile_name,profile_email,profile_gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profile_name=(TextView) findViewById(R.id.profile_name);
        profile_email=(TextView) findViewById(R.id.profile_email);
        profile_gender=(TextView) findViewById(R.id.profile_gender);
       email1= getIntent().getStringExtra("key_email");
        getUserDetails();
    }
    public  void getUserDetails()
    {
   DbHelper dbHelper=new DbHelper(this);
        ArrayList<UserModel>al=dbHelper.getLoggedInUserDetails(email1);
        dbHelper.getLoggedInUserDetails(email1);
       UserModel userModel= al.get(0);
       profile_name.setText(userModel.getName());
       profile_email.setText(userModel.getEmail());
       profile_gender.setText(userModel.getGender());
    }
    public void logoutUser()
    {
        startActivity(new Intent(profile_activity.this,Login.class));
    }
    public void GetAllUsers(View view)
    {
        DbHelper dbHelper=new DbHelper(this);
    }

    public void profileUpdate(View view )
    {
  startActivity(new Intent(profile_activity.this,UpdateProfile.class));
    }
}