package com.example.afworld.androidthreadtest;

import android.app.ActionBar;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by afworld on 2019/9/6.
 */

public class DownloadTask extends AsyncTask<Void,Integer,Boolean> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
//        progressDialog.show();
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        try{
            while (true){
                int downloadPercent = doDowload();
                publishProgress(downloadPercent);
                if(downloadPercent>=100){
                    break;
                }
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

    private int doDowload() {
        return 0;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
//        progressDialog.setMessage("Downloaded "+values[0]+"%");
    }

    @Override
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);
//        progressDialog.dismiss();
//        if(result){
//            Toast.makeText(context,"Download succeeded",Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(context,"Download failed",Toast.LENGTH_SHORT).show();
//        }
    }
}
