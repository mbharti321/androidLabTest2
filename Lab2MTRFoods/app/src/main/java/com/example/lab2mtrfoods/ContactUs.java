package com.example.lab2mtrfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class ContactUs extends AppCompatActivity {
    private ImageButton mbtnWebsite, mbtnCall, mbtnLocation, mbtnbtnMail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);


        mbtnWebsite = findViewById(R.id.btnWebsite);
        mbtnCall = findViewById(R.id.btnCall);
        mbtnLocation = findViewById(R.id.btnLocation);
        mbtnbtnMail = findViewById(R.id.btnMail);

        mbtnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ContactUs.this, "Website button clicked.", Toast.LENGTH_SHORT).show();
                String url =  "https://www.mtrfoods.com/";
                Uri webpage = Uri.parse(url);

                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }
            }
        });

        mbtnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ContactUs.this, "Call button clicked", Toast.LENGTH_SHORT).show();
                String contactNum =  "18001037455";

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + contactNum));

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }
            }
        });

        mbtnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ContactUs.this, "Location button clicked", Toast.LENGTH_SHORT).show();
                String location =  "MTR Foods";

                Uri addressUri = Uri.parse("geo:0,0?q=" + location);
                Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }
            }
        });

        mbtnbtnMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ContactUs.this, "Mail button clicked", Toast.LENGTH_SHORT).show();
                String subject = "Greetings from 4MCA!!";
                String[] sendTo = new String[] {"feedback@mtrfoods.com"};
                String content = "Good Morning !, This is a test email sent through the APP";

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_EMAIL, sendTo);
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, content);

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }
            }
        });
    }
}