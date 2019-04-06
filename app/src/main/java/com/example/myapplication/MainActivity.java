package com.example.myapplication;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Calendar;

/*6. madde eksik */
public class MainActivity extends AppCompatActivity {

    EditText firstname,lname,place,tcNo,tarih,telefon,mailim;
    Button tsec,submitButton,clrbtn;
    Context context = this;
    ImageView imageView;
    public static Drawable imageDrawable;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        firstname = (EditText) findViewById(R.id.name);
        lname = (EditText) findViewById(R.id.lastname);
        place = (EditText) findViewById(R.id.birthplace);
        tcNo = (EditText) findViewById(R.id.tc);
       // tarih = (EditText) findViewById(R.id.edittext_tarih);//tsec = (Button) findViewById(R.id.button_tarih_sec);
        telefon = (EditText)findViewById(R.id.tel);
        mailim = (EditText)findViewById(R.id.mail);
        submitButton = (Button)findViewById(R.id.button);
        clrbtn = (Button)findViewById(R.id.clearbutton);
        imageView = (ImageView)findViewById(R.id.imageView);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitAUser();

            }
        });

        /*tsec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar takvim = Calendar.getInstance();
                int yil = takvim.get(Calendar.YEAR);
                int ay = takvim.get(Calendar.MONTH);
                int gun = takvim.get(Calendar.DAY_OF_MONTH);
                Toast.makeText(getApplicationContext(),"Tarih Seç", Toast.LENGTH_LONG ).show();



                DatePickerDialog dpd = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        tarih.setText(dayOfMonth + "/" + month + "/" + year);

                    }
                },yil,ay,gun);
                dpd.setButton(DatePickerDialog.BUTTON_POSITIVE, "Seç", dpd);
                dpd.setButton(DatePickerDialog.BUTTON_NEGATIVE, "İptal", dpd);
                dpd.show();

            }
        });*/

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, 1);
            }
        });

        clrbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstname.setText("");
                lname.setText("");
                place.setText("");
                tcNo.setText("");
                mailim.setText("");
                telefon.setText("");
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                imageView.setImageBitmap(selectedImage);
                imageDrawable = imageView.getDrawable();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(this, "You haven't picked Image",Toast.LENGTH_LONG).show();
        }


    }

    private void submitAUser() {
        Intent submitIntent = new Intent(MainActivity.this,SecondActivity.class);
        submitIntent.putExtra("name",firstname.getText().toString());
        submitIntent.putExtra("Sname",lname.getText().toString());
        submitIntent.putExtra("yer",place.getText().toString());
        submitIntent.putExtra("tc",tcNo.getText().toString());
        submitIntent.putExtra("mailler",mailim.getText().toString());
        submitIntent.putExtra("telefonNo",telefon.getText().toString());

        startActivity(submitIntent);

    }
}
