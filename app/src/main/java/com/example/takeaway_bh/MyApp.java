package com.example.takeaway_bh;

import android.app.Application;
import android.content.Context;

import com.example.takeaway_bh.Bean.TakeOrder;

import org.litepal.LitePal;

public class MyApp extends Application {
    private static Context context;
    private static String UserName;
    private static boolean isRider;

    public static String getUserName() {
        return UserName;
    }

    public static void setUserName(String userName) {
        UserName = userName;
    }

    public static int getId() {
        return LitePal.where("customer_user is ?", UserName).find(TakeOrder.class).size() + 1;
    }

    public static Context getContext() {
        return context;
    }

    public static boolean isIsRider() {
        return isRider;
    }

    public static void setIsRider(boolean isRider) {
        MyApp.isRider = isRider;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        LitePal.initialize(context);
    }
}
