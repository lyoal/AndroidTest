package com.example.afworld.activitytest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BaseActivity {
    private static final String TAG = "SecondActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Task id is "+getTaskId());
        setContentView(R.layout.second_layout);

        //接收 第一个活动页面传递过来的数据并打印出来
        Intent intent = getIntent();
        String data1 = intent.getStringExtra("param1");
        String data2 = intent.getStringExtra("param2");
        Log.d(TAG, "第1个参数: "+data1+",第2个参数: "+data2);

        //第一活动页面发送的请求码是1, 这个值必须是唯一的.
        //在当前页面点击事件中添加返回数据的逻辑代码
        Button button2 = (Button)findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.putExtra("data_return","Hello FirstActivity");
//                setResult(RESULT_OK,intent);
//                finish();
                //演示活动的启动模式 singleTop
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    //现实开发中,当你负责的部分需要有启动SecondActivity这个功能,而又不清楚启动这个活动需要传递哪些数据时
    public static void actionStart(Context context, String data1, String data2) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        context.startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Log.d(TAG, "onDestroy: SecondActivity");
    }

    //如果用户不是点击按钮, 而是点击了 Back 返回键时,如果需要返回数据,则要重写onBackPressed()
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent = new Intent();
        intent.putExtra("data_return","Hello FirstActivity For Back");
        setResult(RESULT_OK,intent);
        finish();
    }
}
