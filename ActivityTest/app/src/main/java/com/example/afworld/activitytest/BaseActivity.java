package com.example.afworld.activitytest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by afworld on 2019/8/23.
 * 这个类的作用是, 可以随时查看当前是哪个活动,将其作为其它活动的基类
 * 使用ActivityCollector类管理程序中的所有活动
 */

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: "+getClass().getSimpleName());
        ActivityCollector.addActivity(this); //将所有的活动都添加到活动管理器类中
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
