package com.example.francis.testandroid.view.event_system;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Scroller;

/**
 * 实现弹性滑动
 * Created by Francis on 2017-7-18.
 */

public class ScrollerView extends View{
    private Scroller scroller;
    private Context mContext;
    public ScrollerView(Context context) {
        super(context);
        this.mContext = context;
    }

    public ScrollerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        scroller = new Scroller(mContext);

    }

    //慢慢滑动到指定位置
    private void smoothScrollTo(int destX, int destY){
        int scrollX = getScrollX();
        int delta = destX - scrollX;
        //1000ms 内滑向destX, 效果就是慢慢滑动
        scroller.startScroll(scrollX, 0, delta, 0, 1000);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (scroller.computeScrollOffset()){
            scrollTo(scroller.getCurrX(), scroller.getCurrY());
            postInvalidate();
        }
    }
}
