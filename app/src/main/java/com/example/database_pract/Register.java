package com.example.database_pract;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class Register extends AppCompatActivity {
   EditText reg_name,reg_email,reg_pass,reg_gender;
    DbHelper dbHelper;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        reg_name=(EditText) findViewById(R.id.reg_name);
        reg_email=(EditText) findViewById(R.id.reg_email);
        reg_pass=(EditText) findViewById(R.id.reg_pass);
        reg_gender=(EditText) findViewById(R.id.reg_gender);
         dbHelper=new DbHelper(getApplicationContext());
    }
    public  void registerUser(View view) {
        String name1 = reg_name.getText().toString();
        String email1 = reg_email.getText().toString();
        String pass1 = reg_pass.getText().toString();
        String gender1 = reg_gender.getText().toString();
        boolean b=dbHelper.registerUserHelper(name1,email1,pass1,gender1);
        if (b==true)
        {
            Toast.makeText(this, "user register successfully", Toast.LENGTH_SHORT).show();
            reg_name.setText("");
            reg_email.setText("");
            reg_pass.setText("");
            reg_gender.setText("");
        }
      else {
            Toast.makeText(this, "Error.....", Toast.LENGTH_SHORT).show();
        }
    }

}