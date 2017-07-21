package com.example.francis.testandroid.view.event_system;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;

/**
 * 跟着手指全屏滑动的View
 * Created by Francis on 2017-7-18.
 */

public class FullScreenSlideView extends TextView{

    private int mLastX;
    private int mLastY;
    private Scroller scroller;
    private static final String TAG = "FullScreenSlideView";

    public FullScreenSlideView(Context context) {
        super(context);
        scroller = new Scroller(context);
    }

    public FullScreenSlideView(Context context, AttributeSet attrs) {
        super(context, attrs);
        scroller = new Scroller(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x - mLastX;
                int deltaY = y - mLastY;

                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
                layoutParams.leftMargin = deltaX;
                layoutParams.topMargin = deltaY;
                setLayoutParams(layoutParams);

//                int translationX = (int) (ViewHelper.getTranslationX(this) + deltaX);
//                int translationY = (int)ViewHelper.getTranslationY(this) + deltaY;
//                ViewHelper.setTranslationX(this, translationX);
//                ViewHelper.setTranslationY(this, translationY);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }
        mLastX = x;
        mLastY = y;
        return true;
    }
}
