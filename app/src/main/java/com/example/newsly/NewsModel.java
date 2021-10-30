package com.example.newsly;

import java.util.ArrayList;

public class NewsModel {
        private int totalResult;
        private  String staus;
    private ArrayList<Articles> articles;


    public NewsModel(int totalResult, String staus, ArrayList<Articles> articles) {
        this.totalResult = totalResult;
        this.staus = staus;
        this.articles = articles;
    }
    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }

    public String getStaus() {
        return staus;
    }

    public void setStaus(String staus) {
        this.staus = staus;
    }

    public ArrayList<Articles> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Articles> articles) {
        this.articles = articles;
    }



}
