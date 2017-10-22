package com.example.francis.testandroid.glide;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.francis.testandroid.R;

/**
 * Created by Francis.Huang on 2017/10/10.
 */

public class TestGlideActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnLoad;
    private ImageView ivGlide;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test_glide);

        mContext = this;

        initView();
        initListener();
    }

    private void initView() {
        btnLoad = (Button) findViewById(R.id.btn_load);
        ivGlide = (ImageView) findViewById(R.id.iv_glide);
    }

    private void initListener() {
        btnLoad.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_load:
                //基本使用方法  with load into
                String url = "http://img0.imgtn.bdimg.com/it/u=4195805644,827754888&fm=27&gp=0.jpg";
                String gifUrl = "http://p1.pstatp.com/large/166200019850062839d3";
                Glide.with(mContext).load(url).into(ivGlide);

                //占位图
                Glide.with(mContext)
                        .load(url)
                        //加载过程的占位图
                        .placeholder(R.mipmap.ic_launcher)
                        //错误时显示的占位图
                        .error(R.mipmap.ic_launcher)
                        //禁用Glide的缓存功能，否则会从缓存中加载之前显示过的图片
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .into(ivGlide);

                //设置图片格式 默认是允许加载GIF图片的
                Glide.with(mContext)
                        .load(gifUrl)
                        //设置格式 asGif，如果是Gif设置成静态则显示第一帧的图片，如果是静态设置成Gif则显示错误的占位符
                        .asBitmap()
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .into(ivGlide);

                //指定图片大小，默认情况下会根据imageView的大小去显示，也可以手动设置
                Glide.with(mContext)
                        .load(gifUrl)
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        //手动设置图片的大小
                        .override(100, 100)
                        .into(ivGlide);


                break;
        }
    }
}
