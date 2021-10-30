package com.example.newsly;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class cat_adepter extends RecyclerView.Adapter<cat_adepter.ViewHolder> {


    private ArrayList<categoryRvModel> categoryRvModelArrayList;
    private Context context;
    private catClickInterface catClickInterface;

    public cat_adepter(ArrayList<categoryRvModel> categoryRvModelArrayList, Context context, cat_adepter.catClickInterface catClickInterface) {
        this.categoryRvModelArrayList = categoryRvModelArrayList;
        this.context = context;
        this.catClickInterface = catClickInterface;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_item,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    categoryRvModel categoryRvModel = categoryRvModelArrayList.get(position);
    holder.catTv.setText(categoryRvModel.getCategory());
        Picasso.get().load(categoryRvModel.getCategory_imgUrl()).into(holder.catIV);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                catClickInterface.oncatclick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryRvModelArrayList.size();
    }
    public interface catClickInterface{
        void oncatclick(int posoition);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView catTv;
        ImageView catIV;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            catTv = itemView.findViewById(R.id.categories_name);
            catIV = itemView.findViewById(R.id.cat_image);
        }
    }
}
