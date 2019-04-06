package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends Activity {

    TextView tv;
    ImageView imgpp;
    Button dersButonu,callbutonu,mailbutonu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv = (TextView)findViewById(R.id.nameArea);
        imgpp = (ImageView)findViewById(R.id.ppic);
        imgpp.setImageDrawable(MainActivity.imageDrawable);

        dersButonu = (Button)findViewById(R.id.dersButton);
        callbutonu = (Button)findViewById(R.id.callButton);
        mailbutonu = (Button)findViewById(R.id.mailbutton);

        final Intent secondActivityIntent = getIntent();
        tv.setText(secondActivityIntent.getStringExtra("name")+ "\n"
                + secondActivityIntent.getStringExtra("Sname")+ "\n"
                + secondActivityIntent.getStringExtra("yer")+"\n"
                + secondActivityIntent.getStringExtra("tc")+"\n"
                + secondActivityIntent.getStringExtra("telefonNo")+"\n"
                + secondActivityIntent.getStringExtra("mailler"));


        callbutonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phno=secondActivityIntent.getStringExtra("telefonNo");

                Intent i=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0"+phno));
                startActivity(i);

            }
        });

        mailbutonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mailtexti = secondActivityIntent.getStringExtra("mailler");
                Intent i = new Intent(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_EMAIL,mailtexti);
                i.setType("message/rfc822");
                startActivity(Intent.createChooser(i,"Choose a mail client"));
            }
        });

        dersButonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(i);
            }
        });
    }
}
