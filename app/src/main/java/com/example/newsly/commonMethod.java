package com.example.newsly;

import android.content.Context;
import android.content.Intent;

public class commonMethod {
    public void intentActivity(Context context, Class<?> nextclass)
    {
        Intent intent = new Intent(context,nextclass);
        context.startActivity(intent);
    }
}
