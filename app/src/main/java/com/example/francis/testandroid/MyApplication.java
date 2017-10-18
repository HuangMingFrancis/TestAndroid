package com.example.francis.testandroid;

import android.app.Application;

import com.example.francis.testandroid.uitls.CrashHandler;
import com.example.francis.testandroid.uitls.Utils;

/**
 * Created by Francis on 2017-7-20.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);


        CrashHandler crashHandler = CrashHandler.getsInstance();
        crashHandler.init(this);
    }
}
