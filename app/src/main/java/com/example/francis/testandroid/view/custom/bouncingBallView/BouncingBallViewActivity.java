package com.example.francis.testandroid.view.custom.bouncingBallView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.francis.testandroid.R;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.filter.Filter;

import java.util.List;

/**
 * Created by Francis.Huang on 2017/9/26.
 */

public class BouncingBallViewActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_CHOOSE = 0;
    private BouncingBallView bouncingBallView1;
    private BouncingBallView bouncingBallView2;
    private LinearLayout linearLayout;
    private Button button1;

    List<Uri> mSelected;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bouncingball_view);

        bouncingBallView1 = (BouncingBallView) findViewById(R.id.view);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                bouncingBallView1.letUsAnimate();

                Matisse.from(BouncingBallViewActivity.this)
                        .choose(MimeType.allOf())
                        .countable(true)
                        .maxSelectable(9)
//                        .addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
//                        .gridExpectedSize(getResources().getDimensionPixelSize(R.dimen.grid_expected_size))
                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                        .thumbnailScale(0.85f)
                        .imageEngine(new GlideEngine())
                        .forResult(REQUEST_CODE_CHOOSE);

            }
        });
        BouncingBallConfig config = new BouncingBallConfig();
        config = new BouncingBallConfig.Builder()
                .setballColor(Color.BLUE)
                .setBallCount(6)
                .setBallRadius(30)
                .create();
        bouncingBallView2 = new BouncingBallView(this);
        bouncingBallView2.setLayoutParams(new LinearLayout.LayoutParams(600, 600));
        bouncingBallView2.init(config);
        bouncingBallView2.letUsAnimate();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
            mSelected = Matisse.obtainResult(data);
            Log.d("Matisse", "mSelected: " + mSelected);
        }
    }
}
