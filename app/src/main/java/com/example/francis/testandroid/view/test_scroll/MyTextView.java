package com.example.francis.testandroid.view.test_scroll;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by Francis.Huang on 2017/11/23.
 */

public class MyTextView extends android.support.v7.widget.AppCompatTextView {
    private static final String TAG = "MyTextView";
    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "onTouchEvent: down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(TAG, "onTouchEvent: move");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "onTouchEvent: up");
                break;
        }

        return true;
    }
}
