package com.example.newsly;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;

public class secondActivity extends AppCompatActivity {
    TextView textView26,textView25;
    commonMethod commonMethod;
    ImageView slide2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView26 = findViewById(R.id.textView_26);
        textView26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commonMethod = new commonMethod();
                commonMethod.intentActivity(secondActivity.this, thirdActivity.class);
            }
        });
        textView25 = findViewById(R.id.textView_25);
        textView25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commonMethod = new commonMethod();
                commonMethod.intentActivity(secondActivity.this,signupActivity.class);
            }
        });

        slide2 = findViewById(R.id.slide2);
        String  url = "https://firebasestorage.googleapis.com/v0/b/newsly-164bb.appspot.com/o/Newsly_Images%2FSlider%202.svg?alt=media&token=5b8bf223-8094-4536-b01b-937c0ef95fdb";
        GlideToVectorYou.justLoadImage(secondActivity.this, Uri.parse(url), slide2);
    }
}