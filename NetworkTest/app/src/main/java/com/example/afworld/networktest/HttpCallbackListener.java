package com.example.afworld.networktest;

/**
 * Created by afworld on 2019/9/5.
 */


public interface HttpCallbackListener {

    void onFinish(String response);

    void onError(Exception e);

}
