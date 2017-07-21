package com.example.francis.testandroid.view.event_system;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.francis.testandroid.R;
import com.example.francis.testandroid.uitls.ScreenUtils;

import java.util.ArrayList;

public class NestedSlidingActivity extends AppCompatActivity {
    private static final String TAG = "NestedSlidingActivity";
    private HorizontalScrollViewEx mListContainer;

    private LinearLayout activityNestedSliding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_sliding);
        initView();
    }

    private void initView() {
        activityNestedSliding = (LinearLayout) findViewById(R.id.activity_nested_sliding);

        LayoutInflater inflater = getLayoutInflater();
        mListContainer = (HorizontalScrollViewEx) findViewById(R.id.container);
        final int screenWidth = ScreenUtils.getScreenWidth();
        final int screenHeight = ScreenUtils.getScreenHeight();
        for (int i = 0; i < 3; i++){
            ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.content_layout, mListContainer, false);
            layout.getLayoutParams().width = screenWidth;
            TextView textView = (TextView) layout.findViewById(R.id.title);
            textView.setText("page " + (i + 1));
            layout.setBackgroundColor(Color.rgb(255 / (i+1), 255 / (i+1), 0));
            createList(layout);
            mListContainer.addView(layout);
        }

    }

    private void createList(ViewGroup layout) {
        ListView listView = (ListView) layout.findViewById(R.id.list);
        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            datas.add("name " + 1);
        }
        ArrayAdapter<String> adpter = new ArrayAdapter<String>(this, R.layout.content_list_item, R.id.name, datas);
        listView.setAdapter(adpter);
    }
}
