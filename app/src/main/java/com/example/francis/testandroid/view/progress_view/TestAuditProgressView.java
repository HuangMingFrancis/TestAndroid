package com.example.francis.testandroid.view.progress_view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.example.francis.testandroid.R;

/**
 * Created by Francis.Huang on 2017/11/16.
 */

public class TestAuditProgressView extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audit_progress);

        LinearLayout content = (LinearLayout) findViewById(R.id.ll_audit_content);


        HandleAuditProgressView handleAuditProgressView = new HandleAuditProgressView(this);
        content.addView(handleAuditProgressView.createView(5, true, true, true, false, "提交申请"));
        content.addView(handleAuditProgressView.createView(5, true, true, false, false, "审查"));
        content.addView(handleAuditProgressView.createView(5, true, true, false, false, "审核"));
        content.addView(handleAuditProgressView.createView(5, true, false, false, false, "退款"));
        content.addView(handleAuditProgressView.createView(5, false, false, false, false, "完成"));
        content.addView(handleAuditProgressView.createView(5, false, false, false, true, "关闭"));

    }

}
