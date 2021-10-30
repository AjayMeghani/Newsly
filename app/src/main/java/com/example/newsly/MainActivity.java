package com.example.newsly;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;

public class MainActivity extends AppCompatActivity {
    ImageView imageView,slide1;
    TextView textView16 ,textView15;
    commonMethod commonMethod;
    Button button1;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.firstpic);
        button1 = findViewById(R.id.button1);
         button1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {


             }
         });
        textView16 = findViewById(R.id.textview_16);
        textView16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                     commonMethod = new commonMethod();
                    commonMethod.intentActivity(MainActivity.this,secondActivity.class);
            }
        });
        textView15 = findViewById(R.id.textview_15);
        textView15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commonMethod = new commonMethod();
                commonMethod.intentActivity(MainActivity.this,signupActivity.class);
            }
        });
       slide1 = findViewById(R.id.slide1);
       String  url = "https://firebasestorage.googleapis.com/v0/b/newsly-164bb.appspot.com/o/Newsly_Images%2FSlider%201.svg?alt=media&token=fbc1e166-c74f-4553-baac-9f8c9b340877";
       GlideToVectorYou.justLoadImage(MainActivity.this, Uri.parse(url), slide1);
    }
}