package com.example.francis.testandroid.parcelable;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.francis.testandroid.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Francis on 2017/6/11.
 */

public class Parcelable1Activity extends AppCompatActivity{

    @BindView(R.id.btn_skip)
    Button btnSkip;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable1);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_skip)
    public void onClick() {
        MyParcelable my = new MyParcelable(0, "francis");
        Intent intent = new Intent(this, Parcelable2Activity.class);
        intent.putExtra("par", my);
        startActivity(intent);
    }
}
