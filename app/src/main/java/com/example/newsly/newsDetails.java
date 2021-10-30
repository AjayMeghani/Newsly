package com.example.newsly;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class newsDetails extends AppCompatActivity {
   private TextView titleTV,contentTV,subTitileTV;
   private Button readmore;
   private ImageView newsIV;
String title,desc,content,imageURL,url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        title = getIntent().getStringExtra("title");
        desc = getIntent().getStringExtra("des");
        content = getIntent().getStringExtra("content");
        url = getIntent().getStringExtra("url");
        imageURL = getIntent().getStringExtra("image");

        titleTV = findViewById(R.id.news_title);
        subTitileTV = findViewById(R.id.sub_detais);
        contentTV = findViewById(R.id.content_news);
        readmore = findViewById(R.id.readMore);
        newsIV = findViewById(R.id.last_image);

        titleTV.setText(title);
        subTitileTV.setText(desc);
        contentTV.setText(content);
        Picasso.get().load(imageURL).placeholder(R.drawable.firstone).into(newsIV);

        readmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

    }
}