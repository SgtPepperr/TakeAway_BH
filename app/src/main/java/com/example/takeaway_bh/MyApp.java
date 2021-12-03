package com.example.takeaway_bh;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePal;

public class MyApp extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        LitePal.initialize(context);
    }

    public static Context getContext() {
        return context;
    }
}
