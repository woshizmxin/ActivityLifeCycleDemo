package com.test.activitylifedemo;

import android.util.Log;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

public class OrientationActivity extends Activity {

    private static final String TAG = "OrientationActivity";
    private int param = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orientation_portrait);
        Log.i(TAG, "onCreate called.");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart called.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart called.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume called.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause called.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop called.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestory called.");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("param", param);
        Log.i(TAG, "onSaveInstanceState called. put param: " + param);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        param = savedInstanceState.getInt("param");
        Log.i(TAG, "onRestoreInstanceState called. get param: " + param);
        super.onRestoreInstanceState(savedInstanceState);
    }

    //当指定了android:configChanges="orientation"后,方向改变时onConfigurationChanged被调用
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i(TAG, "onConfigurationChanged called.");
        switch (newConfig.orientation) {
            case Configuration.ORIENTATION_PORTRAIT:
                setContentView(R.layout.orientation_portrait);
                break;
            case Configuration.ORIENTATION_LANDSCAPE:
                setContentView(R.layout.orientation_landscape);
                break;
        }
    }
}