package com.example.takeaway_bh;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePal;

public class MyApp extends Application {
    private static Context context;
    private static int id=0;
    private static String UserName;

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        LitePal.initialize(context);
    }

    public static String getUserName() {
        return UserName;
    }

    public static void setUserName(String userName) {
        UserName = userName;
    }

    public static int getId() {
        return ++id;
    }

    public static Context getContext() {
        return context;
    }
}
