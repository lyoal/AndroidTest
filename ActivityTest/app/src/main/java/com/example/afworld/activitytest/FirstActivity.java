package com.example.afworld.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileFilter;

public class FirstActivity extends BaseActivity {
    private static final String TAG = "FirstActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Task id is "+getTaskId());
        setContentView(R.layout.first_layout);
        
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                SecondActivity.actionStart(FirstActivity.this,"data1","data2");

                //研究活动的启动模式, 默认是standard, 还有singleTop, singleTask, singleInstance
                //standard 模式下,每次单击按钮都会创建一个实际,返回时也需要返回多次
                //singleTop 模式下,只有一个实例,但是如果发活动跳转再返回,则会新建实例
//                Intent intent = new Intent(FirstActivity.this,FirstActivity.class);
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                startActivity(intent);

                //当前点击按钮时,在屏幕下方显示短时提示信息,自动消失
//                Toast.makeText(FirstActivity.this,"You clicked Button 1",Toast.LENGTH_SHORT).show();

                //方法1: 显式intent进行活动切换
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);

                //方法2: 隐式intent进行活动切换
//                Intent intent = new Intent("com.example.afworld.activitytest.ACTION_START");

                //为intent增加一个category
//                intent.addCategory("com.example.afworld.activitytest.MY_CATEGORY");

                //使用隐式intent来调用系统浏览器
                //实例操作中, 添加了第三个活动页面,并在主配置文件中加入了隐式跳转的 action,category 和 data
                //但是实现操作中没有像示例操作中那样弹出选择何各种方式浏览的效果, 可能跟我的真机配置有关吧
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("https://www.baidu.com"));

                //调用电话拨号界面
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:10086"));

                //向下一个活动传递数据 - 字符串
//                String data = "Hello SecondActivity";
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                intent.putExtra("extra_data",data);
//                startActivity(intent);

                //startActivityForResult() 方法作用是期望活动销毁时能够返回一个结果给上一个活动
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                startActivityForResult(intent,1);
            }
        });

        //销毁当前活动
//        button1.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                finish(); //销毁当前活动
//            }
//        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
//        Log.d(TAG, "onRestart: FirstActivity");
    }

    //下一个活动页面被销毁后返回的数据的处理,重写onActivityResult()
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//            super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            case 1:
                if(resultCode == RESULT_OK){
                    String returnedData = data.getStringExtra("data_return");
                    Log.d(TAG, returnedData);
                }
                break;
            default:
        }
    }

    //加载菜单项
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //对菜单项进行单击事件处理
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You clicked Remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
}
