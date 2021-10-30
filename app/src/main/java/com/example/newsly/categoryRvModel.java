package com.example.newsly;

public class categoryRvModel {
    private String category;
    private  String category_imgUrl;

    public categoryRvModel(String category, String category_imgUrl) {
        this.category = category;
        this.category_imgUrl = category_imgUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory_imgUrl() {
        return category_imgUrl;
    }

    public void setCategory_imgUrl(String category_imgUrl) {
        this.category_imgUrl = category_imgUrl;
    }


}
