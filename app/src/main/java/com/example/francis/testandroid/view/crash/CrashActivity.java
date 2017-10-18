package com.example.francis.testandroid.view.crash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.francis.testandroid.R;

/**
 * Created by Francis on 2017/10/18.
 * 测试Crash工具类
 */

public class CrashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash);

        Button btnCrash = (Button) findViewById(R.id.btn_crash);

        btnCrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                throw new RuntimeException("自定义异常：这是测试抛出的异常");
            }
        });
    }
}
