package com.example.francis.testandroid.view.test_scroll;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by Francis.Huang on 2017/11/23.
 */

public class MyScrollView extends ScrollView {
    private static final String TAG = "MyScrollView";
    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i(TAG, "onInterceptTouchEvent: " + ev.getAction() + " return: " + super.onInterceptTouchEvent(ev));
        return super.onInterceptTouchEvent(ev);
//        return false;
//        return true;
    }
}
