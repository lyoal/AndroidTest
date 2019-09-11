package com.example.afworld.activitylifecycletest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

//AndroidManifest.xml 中 <activity android:name=".DialogActivity"android:theme="@android:style/Theme.Dialog"></activity>
//其中属性 android:theme="@android:style/Theme.Dialog" 导致以下
//异常: java.lang.IllegalStateException: You need to use a Theme.AppCompat theme (or descendant) with this a
//修改属性为:android:theme="@style/Theme.AppCompat.Dialog" 可解决
public class ActivityLifeCycleTest extends AppCompatActivity {
    private static final String TAG = "ActivityLifeCycleTest";

    //解决因活动页面处于停止状态时被系统回收资源,导致该页面的临时数据丢失.
    //通过重写 onSaveInstanceState() 方法进行保存
    //该方法可保证在活动被回收之前一定会被调用,换言之,活动没有没被回收时是不会被调用的.
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData = "Something you just typed";
        outState.putString("data_key",tempData);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        Log.d(TAG, "onCreate: ");

        //取上个方法onSaveInstanceState中临时保存的数据
        if(null != savedInstanceState){
            String tempData = savedInstanceState.getString("data_key");
            Log.d(TAG, "onCreate: " + tempData);
        }

        Button startNormalActivity = (Button)findViewById(R.id.start_normal_activity);
        Button startDialogActivity = (Button)findViewById(R.id.start_dialog_activity);

        startNormalActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLifeCycleTest.this,NormalActivity.class);
                startActivity(intent);
            }
        });
        startDialogActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLifeCycleTest.this,DialogActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }
}
