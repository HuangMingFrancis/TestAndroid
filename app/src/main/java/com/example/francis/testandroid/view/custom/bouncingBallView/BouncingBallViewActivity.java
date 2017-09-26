package com.example.francis.testandroid.view.custom.bouncingBallView;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.francis.testandroid.R;

/**
 * Created by Francis.Huang on 2017/9/26.
 */

public class BouncingBallViewActivity extends AppCompatActivity {

    private BouncingBallView bouncingBallView1;
    private BouncingBallView bouncingBallView2;
    private LinearLayout linearLayout;
    private Button button1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bouncingball_view);

        bouncingBallView1 = (BouncingBallView) findViewById(R.id.view);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bouncingBallView1.letUsAnimate();
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
}
