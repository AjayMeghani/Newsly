package com.example.newsly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.squareup.picasso.Picasso;

public class splashActivity extends AppCompatActivity {
ImageView imageView;
  String url = "https://firebasestorage.googleapis.com/v0/b/newsly-164bb.appspot.com/o/Newsly_Images%2FApp%20logo.svg?alt=media&token=1dcf8fc2-ccf1-434e-9675-7a80ba7e8f9b";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView = findViewById(R.id.spalashPic);
//        Picasso.get().load(url).into(imageView);
        GlideToVectorYou.justLoadImage(splashActivity.this, Uri.parse(url), imageView);

        AlphaAnimation animation = new AlphaAnimation(0,1);
        animation.setDuration(3500);
        animation.setRepeatCount(1);
        imageView.startAnimation(animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            Intent intent = new Intent(splashActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
            }
        }, 7000);
    }
}