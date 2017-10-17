package com.example.francis.testandroid.view.recycler_view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.francis.testandroid.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Francis on 2017/10/17.
 * 测试不同的item的recyclerview
 */

public class TestRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        initView();
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_test);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        List<String> dataList = new ArrayList<>();
        dataList.add("hello1");
        dataList.add("hello2");
        dataList.add("hello3");
        dataList.add("hello2");
        dataList.add("hello3");

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, dataList);

        recyclerView.setAdapter(adapter);

    }
}
