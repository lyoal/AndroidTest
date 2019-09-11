package com.example.afworld.networktest;

import android.app.Application;
import android.content.Context;

/**
 * Created by afworld on 2019/9/10.
 */

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
//        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}
