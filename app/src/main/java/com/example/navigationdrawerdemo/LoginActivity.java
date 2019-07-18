package com.example.navigationdrawerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
EditText editText,editText2;
Button btn;
String name;
String pass;
    SharedPreferences prefs ;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText = findViewById(R.id.log_username);
        editText2 = findViewById(R.id.log_password);
        btn = findViewById(R.id.log_login);
        prefs = getSharedPreferences("preff",MODE_PRIVATE);
        editor = prefs.edit();
        name = prefs.getString("name","");
        pass = prefs.getString("password","");
        findViewById(R.id.signUpBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u_name,u_pass;
                u_name = editText.getText().toString();
                u_pass = editText2.getText().toString();
                if(u_name.equals("") | u_pass.equals("")){
                    editText.setError("Please enter username");
                    editText2.setError("Please enter password");
                    return;
                }
                if(u_name.equals(name)){

                    if(u_pass.equals(pass)){
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                        editor.putBoolean("auth",true);
                        editor.commit();
                        finish();
                        Toast.makeText(LoginActivity.this,"Successfully Login",Toast.LENGTH_LONG).show();
                    }
                    else{

                        Toast.makeText(LoginActivity.this,"Wrong password",Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Log.d("TAG","SUCCESS5");
                    Toast.makeText(LoginActivity.this, "Wrong Username : "+u_name+" , "+name+" , "+name.equals(u_name), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    /*public void login(View view){
        String u_name,u_pass;
        u_name = editText.getText().toString();
        u_pass = editText2.getText().toString();
    if(u_name.equals(name)){
        if(u_pass.equals(pass)){
            Toast.makeText(LoginActivity.this,"Successfully Login",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(LoginActivity.this,"Wrong password",Toast.LENGTH_LONG).show();
        }
    }
    else{
        Toast.makeText(LoginActivity.this, "Wrong Username", Toast.LENGTH_SHORT).show();
    }

    }*/
}
