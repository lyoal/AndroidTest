package com.example.afworld.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class HelloWorldActivity extends AppCompatActivity {
    private static final String TAG = "HelloWorldActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_world_layout);
        Log.d(TAG,"onCreate Execute");
        Log.e(TAG, "onCreate: Loge");
        Log.i(TAG, "onCreate: Logi");
        Log.w(TAG, "onCreate: Logw" );
        Log.d(TAG, "onCreate() returned: " + 2);
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
    }
}
