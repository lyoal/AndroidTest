package com.example.afworld.servicebestpractice;

/**
 * Created by afworld on 2019/9/6.
 */

public interface DownloadListener {
    void onProgress(int progress);
    void onSuccess();
    void onFailed();
    void onPaused();
    void onCanceled();
}
