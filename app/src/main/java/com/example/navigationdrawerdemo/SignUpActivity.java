package com.example.navigationdrawerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    EditText username,password,address,phonenumber,email,id,confirmpassword;
    Button signup;

    SharedPreferences prefs ;
    SharedPreferences.Editor editor;
 public  void init()
 {
     prefs = getSharedPreferences("preff",MODE_PRIVATE);
     editor = prefs.edit();
     username = findViewById(R.id.reg_username);
     password = findViewById(R.id.reg_password);
     email = findViewById(R.id.reg_email);
     address = findViewById(R.id.reg_address);
     id = findViewById(R.id.reg_id);
     phonenumber = findViewById(R.id.reg_phonenumber);
     signup = findViewById(R.id.reg_signup);
     confirmpassword = findViewById(R.id.reg_confirmpassword);

 }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name, Email, ID,Address, Password,PhoneNumber,Confirmpassword;
                name = username.getText().toString();
                Email = email.getText().toString();
                ID = id.getText().toString();
                Password = password.getText().toString();
                Confirmpassword = confirmpassword.getText().toString();
                Address = address.getText().toString();
                PhoneNumber = phonenumber.getText().toString();

                if(name.equals("")){
                   username.setError("Please enter name");
                   return;
                }
                editor.putString("id",ID);
                editor.putString("name",name);
                editor.putString("email",Email);
                editor.putString("password",Password);
                editor.putBoolean("auth",true);
                editor.commit();

                StringBuffer buffer = new StringBuffer();
                buffer.append("User Name : " + name + "\n");
                buffer.append("Email : " + Email + "\n");
                buffer.append("ID : " + ID + "\n");
                buffer.append("Password : " + Password + "\n");
                buffer.append("Confirm Password : " + Confirmpassword + "\n");
                //Reg_details.setText(buffer.toString());


                Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(SignUpActivity.this, "SIGNUP SUCCESSFULLY !", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
