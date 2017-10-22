package com.example.francis.testandroid.view.test_scroll;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.francis.testandroid.R;
import com.example.francis.testandroid.view.event_system.ScrollerView;

/**
 * Created by Francis on 2017/10/20.
 */

public class TestScrollActivity extends AppCompatActivity {

    private static final String TAG = "TestScrollActivity";

    private RelativeLayout rlytTop;
    private RelativeLayout rlyBottom;
    private ScrollView scrollerContent;
    private TextView tvContent;
    private RelativeLayout rlytMy;

    private int lastY;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_scroll);


        initView();

    }

    private void initView() {
        rlyBottom = (RelativeLayout) findViewById(R.id.rlyt_bottom);
        rlytTop = (RelativeLayout) findViewById(R.id.rlyt_top);
        rlytMy = (RelativeLayout) findViewById(R.id.rlyt_my);

        scrollerContent = (ScrollView) findViewById(R.id.scroll_content);
        tvContent = (TextView) findViewById(R.id.tv_content);

        scrollerContent.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        lastY = (int) event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int currentY = (int) event.getY();
                        Log.i(TAG, "onTouch: " + (currentY - lastY));
                        int destY = currentY - lastY;
                        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) scrollerContent.getLayoutParams();
                        ViewGroup.MarginLayoutParams paramsTop = (ViewGroup.MarginLayoutParams) rlytTop.getLayoutParams();
                        ViewGroup.MarginLayoutParams paramsBottom = (ViewGroup.MarginLayoutParams) rlyBottom.getLayoutParams();

                        if (currentY - lastY < 0){
                            //上滑隐藏头部和底部

                            if (paramsTop.topMargin > (-paramsTop.height)){
                                destY = (paramsTop.topMargin + destY < (-paramsTop.height) ? (-paramsTop.height - paramsTop.topMargin) : destY);
                                paramsTop.topMargin += destY;
                                paramsBottom.bottomMargin += destY;
                                rlytTop.requestLayout();
                                rlyBottom.requestLayout();
                            }

                        }else{
                            //下滑显示头部和底部

                            if (paramsTop.topMargin <= 0){
                                destY = (paramsTop.topMargin + destY > 0 ? 0 - paramsTop.topMargin : destY);
                                paramsTop.topMargin += destY;
                                paramsBottom.bottomMargin += destY;
                                rlytTop.requestLayout();
                                rlyBottom.requestLayout();
                            }
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return false;
            }
        });

    }
}
