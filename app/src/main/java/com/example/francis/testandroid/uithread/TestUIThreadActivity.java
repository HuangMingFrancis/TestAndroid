package com.example.francis.testandroid.uithread;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.francis.testandroid.R;

/**
 * Created by Francis on 2017-6-22.
 * 测试非UI线程中更新界面
 */

public class TestUIThreadActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_thread);
        final TextView tvShow = (TextView) findViewById(R.id.tv_show);
        new Thread(){
            @Override
            public void run() {
                super.run();
                tvShow.setText("非UI线程中更新界面元素");
            }
        }.start();
    }
}
