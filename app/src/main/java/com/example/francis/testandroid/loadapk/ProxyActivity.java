package com.example.francis.testandroid.loadapk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

/**
 * Created by Francis.Huang on 2017/11/22.
 */

public class ProxyActivity extends AppCompatActivity {

    private static final String TAG = "ProxyActivity";

    public static final String FROM = "extra.from";
    public static final int FROM_EXTERNAL = 0;
    public static final int FROM_INTERNAL = 1;

    private String mClass;
    private String mDexPath;
    public static final String EXTRA_DEX_PATH = "extra.dex.path";
    public static final String EXTRA_CLASS = "extra.class";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDexPath = getIntent().getStringExtra(EXTRA_DEX_PATH);
        mClass = getIntent().getStringExtra(EXTRA_CLASS);

        Log.d(TAG, "mClass=" + mClass + " mDexPath=" + mDexPath);
        if (mClass == null) {
            launchTargetActivity();
        } else {
            launchTargetActivity(mClass);
        }
    }
    private void launchTargetActivity() {

        PackageInfo packageInfo = getPackageManager().getPackageArchiveInfo(mDexPath, 1);
        if ((packageInfo.activities != null) && packageInfo.activities.length > 0){
            String activityName = packageInfo.activities[0].name;
            mClass = activityName;
            launchTargetActivity(mClass);
        }
    }
    private void launchTargetActivity(String className) {
        Log.d(TAG, "start launchTargetActivity, className=" + className);
        File dexOutputDir = this.getDir("dex", 0);
        final String dexOutputPath = dexOutputDir.getAbsolutePath();
        ClassLoader localClassLoader = ClassLoader.getSystemClassLoader();
        DexClassLoader dexClassLoader = new DexClassLoader(mDexPath,
                dexOutputPath, null, localClassLoader);
        try {
            Class<?> localClass = dexClassLoader.loadClass(className);
            Constructor<?> localConstructor = localClass
                    .getConstructor(new Class[] {});
            Object instance = localConstructor.newInstance(new Object[] {});
            Log.d(TAG, "instance = " + instance);

//            Method setProxy = localClass.getMethod("setProxy",
//                    new Class[] { Activity.class });
//            setProxy.setAccessible(true);
//            setProxy.invoke(instance, new Object[] { this });

            Method onCreate = localClass.getDeclaredMethod("onCreate",
                    new Class[] { Bundle.class });
            onCreate.setAccessible(true);
            Bundle bundle = new Bundle();
//            bundle.putInt(FROM, FROM_EXTERNAL);
            onCreate.invoke(instance, bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
