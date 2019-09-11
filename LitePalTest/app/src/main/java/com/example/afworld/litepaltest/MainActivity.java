package com.example.afworld.litepaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createDatabase = (Button)findViewById(R.id.create_database);
        Button addData = (Button)findViewById(R.id.add_data);
        Button updateData = (Button)findViewById(R.id.update_data);
        Button deleteData = (Button)findViewById(R.id.delete_data);
        Button queryData = (Button)findViewById(R.id.query_data);

        queryData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                List<Book> bookList = DataSupport.findAll(Book.class);
                for(Book book: bookList){
                    Log.d(TAG, "book name is "+book.getName());
                    Log.d(TAG, "book author is "+book.getAuthor());
                    Log.d(TAG, "book pages is "+book.getPages());
                    Log.d(TAG, "book price is "+book.getPrice());
                    Log.d(TAG, "book press is "+book.getPress());
                }
            }
        });

        deleteData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DataSupport.deleteAll(Book.class,"Price<?","15");
            }
        });

        updateData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setPrice(14.55);
                book.setPress("Anchor");
                book.updateAll("name=? and author=?","The Lost Symbol","Dan Brown");
//                book.setName("The Lost Symbol");
//                book.setAuthor("Dan Brown");
//                book.setPages(550);
//                book.setPrice(89.44);
//                book.save();
//                book.setPrice(10.98);
//                book.save();
            }
        });

        addData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setName("The Da Vinci Code");
                book.setAuthor("Dan Brown");
                book.setPages(454);
                book.setPrice(16.99);
                book.setPress("Unknown");
                book.save();
            }
        });

        createDatabase.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Connector.getDatabase();
            }
        });
    }
}
