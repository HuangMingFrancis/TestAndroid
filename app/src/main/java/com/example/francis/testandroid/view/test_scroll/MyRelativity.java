package com.example.francis.testandroid.view.test_scroll;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.Scroller;

/**
 * Created by Francis on 2017/10/21.
 */

public class MyRelativity extends RelativeLayout {

    private Scroller scroller = null;

    public MyRelativity(Context context) {
        super(context);
        scroller = new Scroller(context);
    }

    public MyRelativity(Context context, AttributeSet attrs) {
        super(context, attrs);
        scroller = new Scroller(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    public void computeScroll() {
        super.computeScroll();
    }

    public void smoothScrollTo(int destX, int destY){
        int scrollX = getScrollX();
        int deltaX = destX - scrollX;
        scroller.startScroll(scrollX, 0, deltaX, 0, 1000);
    }
}
