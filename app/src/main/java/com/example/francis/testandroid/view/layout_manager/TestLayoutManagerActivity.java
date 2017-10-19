package com.example.francis.testandroid.view.layout_manager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.francis.testandroid.R;
import com.example.francis.testandroid.view.recycler_view.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Francis on 2017/10/18.
 */

public class TestLayoutManagerActivity extends AppCompatActivity {
    private Button btnAdd;
    private RecyclerView recyclerView;

    private List<String> dataList;

    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_layout_manager);


        initView();
    }

    private void initView() {
        btnAdd = (Button) findViewById(R.id.btn_add);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_test);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataList.add("hello1");
                adapter.notifyDataSetChanged();
            }
        });


        dataList = new ArrayList<>();



        adapter = new RecyclerViewAdapter(this, dataList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new MyLayoutManager(this));
    }


}
