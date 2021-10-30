package com.example.newsly;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class fNews_adepter extends RecyclerView.Adapter<fNews_adepter.ViewHolder>{
    private ArrayList<Articles> articlesArrayList;
    private Context context;

    public fNews_adepter(ArrayList<Articles> articlesArrayList, Context context) {
        this.articlesArrayList = articlesArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.freshnews_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Articles articles = articlesArrayList.get(position);
//        holder.subTitleTv.setText(articles.getDescription());
        holder.titleTV.setText(articles.getTitle());
        Picasso.get().load(articles.getUrlToImage()).into(holder.newsIV);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, newsDetails.class);
                intent.putExtra("title",articles.getTitle());
                intent.putExtra("content",articles.getContent());
                intent.putExtra("image",articles.getUrlToImage());
                intent.putExtra("des",articles.getDescription());
                intent.putExtra("url",articles.getUrl());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return articlesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTV,subTitleTv;
        private ImageView newsIV;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.headlines);
//            subTitleTv= itemView.findViewById(R.id.sub_heading);
            newsIV = itemView.findViewById(R.id.news_image);
        }
    }
}
