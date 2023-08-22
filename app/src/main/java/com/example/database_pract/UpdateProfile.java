package com.example.database_pract;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class UpdateProfile extends AppCompatActivity {

    TextView up_email;
    EditText up_name;
    EditText up_gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        up_email=(TextView) findViewById(R.id.up_email);
        up_name= (EditText) findViewById(R.id.up_name);
        up_gender=(EditText) findViewById(R.id.up_gender);
    }
    public  void updateMyProfile()
    {

    }
}