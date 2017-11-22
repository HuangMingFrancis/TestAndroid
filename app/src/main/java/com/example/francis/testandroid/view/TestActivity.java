package com.example.francis.testandroid.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.CharacterPickerDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.francis.testandroid.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Francis.Huang on 2017/10/19.
 */

public class TestActivity extends AppCompatActivity{

    private List<String> strings;

    private MyAdapter myAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_manager);

        Button btnAdd = (Button) findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strings.add("nihao");
                myAdapter.notifyDataSetChanged();
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_test);

        recyclerView.setLayoutManager(new MyLayoutManager(this));
        strings = new ArrayList<>();


        myAdapter = new MyAdapter(strings);
        recyclerView.setAdapter(myAdapter);
    }

    class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        private List<String> dataList = new ArrayList<>();

        public MyAdapter(List<String> dataList){
            this.dataList = dataList;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(TestActivity.this).inflate(R.layout.item, parent,false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }


        class MyViewHolder extends RecyclerView.ViewHolder{

            public MyViewHolder(View itemView) {
                super(itemView);
            }
        }
    }
}
