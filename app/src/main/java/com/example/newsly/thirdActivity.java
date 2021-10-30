package com.example.newsly;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;

public class thirdActivity extends AppCompatActivity {
        TextView textView36,textView35;
        ImageView slide3;
        commonMethod commonMethod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdone);
        textView36 = findViewById(R.id.textView_36);
        textView36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            commonMethod =  new commonMethod();
            commonMethod.intentActivity(thirdActivity.this,signupActivity.class);
            }
        });
        textView35 = findViewById(R.id.textView_35);
        textView35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commonMethod = new commonMethod();
                commonMethod.intentActivity(thirdActivity.this,signupActivity.class);
            }
        });
        slide3 = findViewById(R.id.slide3);
        String  url = "https://firebasestorage.googleapis.com/v0/b/newsly-164bb.appspot.com/o/Newsly_Images%2FSlider%203.svg?alt=media&token=cfe132c0-43ff-43a5-ab0b-b9d0cb4c014f";
        GlideToVectorYou.justLoadImage(thirdActivity.this, Uri.parse(url), slide3);
    }
}