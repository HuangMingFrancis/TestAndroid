package com.example.francis.testandroid.view.event_system;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.francis.testandroid.R;

public class FullScreenSlideActivity extends AppCompatActivity {

    private FullScreenSlideView fullScreenSlide;
    private Button btnScrollTo;
    private RelativeLayout activityFullScreenSlide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_slide);

        fullScreenSlide = (FullScreenSlideView) findViewById(R.id.full_screen_slide);
        btnScrollTo = (Button) findViewById(R.id.btn_scroll_to);
        activityFullScreenSlide = (RelativeLayout) findViewById(R.id.activity_full_screen_slide);

        fullScreenSlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                btnScrollTo.scrollTo(100, 100);
                activityFullScreenSlide.scrollTo(100, 100);
            }
        });

        btnScrollTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) fullScreenSlide.getLayoutParams();
                layoutParams.leftMargin = 600;
                layoutParams.topMargin = 300;
                fullScreenSlide.setLayoutParams(layoutParams);
//                activityFullScreenSlide.scrollTo(100, 100);
            }
        });

    }
}
