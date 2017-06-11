package com.example.francis.testandroid.parcelable;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.francis.testandroid.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Francis on 2017/6/11.
 */

public class Parcelable2Activity extends AppCompatActivity {

    @BindView(R.id.tv_id)
    TextView tvId;
    @BindView(R.id.tv_name)
    TextView tvName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable2);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        MyParcelable myParcelable = getIntent().getParcelableExtra("par");
        tvId.setText(Integer.toString(myParcelable.getId()));
        tvName.setText(myParcelable.getName());
    }
}
