package com.example.francis.testandroid.loadapk;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.francis.testandroid.R;

/**
 * Created by Francis.Huang on 2017/11/22.
 */

public class HostProgramActivity extends AppCompatActivity {
    private Button btnLoad;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_program);


        btnLoad = (Button) findViewById(R.id.btn_load);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HostProgramActivity.this, ProxyActivity.class);
                intent.putExtra(ProxyActivity.EXTRA_DEX_PATH, "/mnt/sdcard/DynamicLoadHost/plugin.apk");
                startActivity(intent);
            }
        });
    }
}
