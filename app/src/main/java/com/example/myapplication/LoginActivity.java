package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
    EditText txt1,txt2;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txt1 = (EditText)findViewById(R.id.usernametext);
        txt2 = (EditText)findViewById(R.id.sifretext);
        btn1 = (Button)findViewById(R.id.loginbutton);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txt1.getText().toString().equals("admin") && txt2.getText().toString().equals("password")){
                    Intent i = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(i);
                }else{
                    txt1.setText("");
                    txt2.setText("");
                    Toast.makeText(getApplicationContext(),"Kullanıcı adı yada şifre yanlış",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
