package com.example.afworld.uiwidgettest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.icu.text.DateFormat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Boolean flag = false;

    private EditText editText;

    private ImageView imageView;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.edit_text);
        imageView = (ImageView)findViewById(R.id.image_view);
        progressBar = (ProgressBar)findViewById(R.id.progress_bar);

        Button button = (Button)findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //添加逻辑代码
//            }
//        });
        //也可以这样子写鼠标的单击事件, 下面这样的写法, 需要在类声明中实现View.OnClickListener接口
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                //窗口下方显示提示信息
//                String inputText = editText.getText().toString();
//                Toast.makeText(MainActivity.this,inputText,Toast.LENGTH_SHORT).show();

                //动态显示图片
//                if(flag){
//                    imageView.setImageResource(R.drawable.img_1);
//                    flag = false;
//                }else{
//                    imageView.setImageResource(R.drawable.img_2);
//                    flag = true;
//                }

                //变换进度条的状态
//                if(progressBar.getVisibility() == View.GONE){
//                    progressBar.setVisibility(View.VISIBLE);
//                }else{
//                    progressBar.setVisibility(View.GONE);
//                }

                //进度条变成水平状态时的操作
//                int progress = progressBar.getProgress();
//                if(progress==100){
//                    progress = 0;
//                    progressBar.setProgress(progress);
//                }else{
//                    progress = progress + 10;
//                    progressBar.setProgress(progress);
//                }

                //警告对话框的操作
//                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
//                dialog.setTitle("This is Dialog");
//                dialog.setMessage("Something important.");
//                dialog.setCancelable(false);
//                dialog.setPositiveButton("OK",new DialogInterface.OnClickListener(){
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                dialog.setNegativeButton("Cancel",new DialogInterface.OnClickListener(){
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                dialog.show();
                //setCancelable() 表示是可以通过 Back键进行取消掉该弹出窗口

                //带进度条的提示框
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Loading......");
                progressDialog.setCancelable(true);
                progressDialog.show();
                //当数据加载完后, 必须调用ProgressDialog的dismiss() 方法关闭该对话框,否则ProgressBar将会一直存在.

                break;
            default:
                break;
        }

    }
}
