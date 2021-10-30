package com.example.newsly;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

public class homePage extends AppCompatActivity implements cat_adepter.catClickInterface{
    private RecyclerView newsRV,catRV;
    private ArrayList<Articles> articlesArrayList;
    private ArrayList<categoryRvModel> categoryRvModelArrayList;
    private cat_adepter cat_adepter;
    private fNews_adepter fNews_adepter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        catRV = findViewById(R.id.categories);
        newsRV= findViewById(R.id.freshNews);
        articlesArrayList = new ArrayList<>();
        categoryRvModelArrayList = new ArrayList<>();
        fNews_adepter = new fNews_adepter(articlesArrayList,this);
        cat_adepter = new cat_adepter(categoryRvModelArrayList,this,this::oncatclick);
//        newsRV.setLayoutManager(new LinearLayoutManager(this));
        newsRV.setLayoutManager(new GridLayoutManager(this,2));
        newsRV.setAdapter(fNews_adepter);
        catRV.setAdapter(cat_adepter);
        getCats();
        getNews("All");
        fNews_adepter.notifyDataSetChanged();

    }
    private void getCats(){
        categoryRvModelArrayList.add(new categoryRvModel("All","https://unsplash.com/photos/zAjP6XUrqeQ"));
        categoryRvModelArrayList.add(new categoryRvModel("Technology","https://images.unsplash.com/photo-1518770660439-4636190af475?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1050&q=80"));
        categoryRvModelArrayList.add(new categoryRvModel("Science","https://images.unsplash.com/photo-1511174511562-5f7f18b874f8?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1050&q=80"));
        categoryRvModelArrayList.add(new categoryRvModel("Sports","https://images.unsplash.com/photo-1474546652694-a33dd8161d66?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1062&q=80"));
        categoryRvModelArrayList.add(new categoryRvModel("General","https://images.unsplash.com/photo-1621503236463-3d812b12ea22?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80"));
        categoryRvModelArrayList.add(new categoryRvModel("Business","https://images.unsplash.com/photo-1522202176988-66273c2fd55f?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTB8fGJ1c2luZXNzfGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=300&q=60"));
        categoryRvModelArrayList.add(new categoryRvModel("Entertainment","https://images.unsplash.com/photo-1567593810070-7a3d471af022?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTN8fGVudGVydGFpbm1lbnR8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=300&q=60"));
        categoryRvModelArrayList.add(new categoryRvModel("Health","https://images.unsplash.com/photo-1445384763658-0400939829cd?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjN8fGhlYWx0aHxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=300&q=60"));
        cat_adepter.notifyDataSetChanged();
    }
    private  void getNews(String category) {
//        progressBar.setVisibility(View.VISIBLE);
        articlesArrayList.clear();
String catURL = "https://newsapi.org/v2/top-headlines?country=in&category=" + category + "&apiKey=657fce15aa024adc810a3f01b8ca283e";
//        String catURL = "https://newsapi.org/v2/everything?q=" + category + "&from=2021-08-13&language=en&sortBy=publishedAt&apiKey=657fce15aa024adc810a3f01b8ca283e";
        String newsUrl = "http://newsapi.org/v2/top-headlines?country=in&excludeDomains=stackoverflow.com&sortBy=publishedAt&language=en&apiKey=657fce15aa024adc810a3f01b8ca283e";
        String BASE_URL = "http://newsapi.org/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofiApi retrofiApi = retrofit.create(retrofiApi.class);
        Call<NewsModel> call;
        if (category.equals("All")) {
            call = retrofiApi.getAllnews(newsUrl);
        } else {
            call = retrofiApi.getNewsByCategory(catURL);
        }
        call.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                NewsModel newsModel = response.body();


//                progressBar.setVisibility(View.GONE);
                ArrayList<Articles> articles = newsModel.getArticles();

                    for (int i = 0; i < articles.size(); i++) {

                        articlesArrayList.add(new Articles(articles.get(i).getTitle(), articles.get(i).getDescription(), articles.get(i).getUrlToImage(), articles.get(i).getContent(), articles.get(i).getUrl()));



                }
                fNews_adepter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
                Toast.makeText(homePage.this, "Fail to get news", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void oncatclick(int posoition) {
        String cat = categoryRvModelArrayList.get(posoition).getCategory();
        getNews(cat);
    }
}
