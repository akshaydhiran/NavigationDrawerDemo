package com.example.navigationdrawerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    EditText username,password,address,phonenumber,email,id,confirmpassword;
    Button signup;
 public  void init()
 {
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
                String Name, Email, ID,Address, Password,PhoneNumber,Confirmpassword;
                Name = username.getText().toString();
                Email = email.getText().toString();
                ID = id.getText().toString();
                Password = password.getText().toString();
                Confirmpassword = confirmpassword.getText().toString();
                Address = address.getText().toString();
                PhoneNumber = phonenumber.getText().toString();


                StringBuffer buffer = new StringBuffer();
                buffer.append("User Name : " + Name + "\n");
                buffer.append("Email : " + Email + "\n");
                buffer.append("ID : " + ID + "\n");
                buffer.append("Password : " + Password + "\n");
                buffer.append("Confirm Password : " + Confirmpassword + "\n");
                //Reg_details.setText(buffer.toString());


                Intent intent = new Intent(SignUpActivity.this,StorePreferenceActivity.class);
                startActivity(intent);
                Toast.makeText(SignUpActivity.this, "SIGNUP SUCCESSFULLY !", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
