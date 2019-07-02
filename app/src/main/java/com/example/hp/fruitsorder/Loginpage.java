package com.example.hp.fruitsorder;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginpage extends AppCompatActivity {
    Button login;
    EditText username;
    EditText password;
    TextView newuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        username=findViewById(R.id.etusername);
        newuser=findViewById(R.id.tvnew);
        password=findViewById(R.id.etpassword);
        login=findViewById(R.id.blogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u =username.getText().toString();
                String p=password.getText().toString();
                if(u.isEmpty()||p.isEmpty())
                    Toast.makeText(loginpage.this,"All the fields are required",Toast.LENGTH_LONG).show();
                else
                    {
                        Toast.makeText(loginpage.this,"Logging to "+u,Toast.LENGTH_LONG).show();
                        showcustomdialog();
                    }
            }
        });
        newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(loginpage.this,Registration_page.class);
                        startActivity(intent);
                    }
                },2000);
            }
        });
    }
    private void showcustomdialog(){
        final ProgressDialog dialog=new ProgressDialog(this);
        dialog.setMessage("wait a sec.");
        dialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
                Intent intent=new Intent(loginpage.this,Homepage.class);
                startActivity(intent);
            }
        },2000);
    }
}
