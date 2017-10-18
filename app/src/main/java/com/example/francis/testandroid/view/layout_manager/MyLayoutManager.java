package com.example.francis.testandroid.view.layout_manager;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Francis on 2017/10/18.
 */

public class MyLayoutManager extends LinearLayoutManager{
    public MyLayoutManager(Context context) {
        super(context);
    }


    @Override
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec) {
        if (state.getItemCount() > 0){

            View view = recycler.getViewForPosition(0);
            if(view != null){
                measureChild(view, widthSpec, heightSpec);
                int measuredWidth = View.MeasureSpec.getSize(widthSpec);
                int measuredHeight = view.getMeasuredHeight();
//                int measuredHeight = 50;
                setMeasuredDimension(measuredWidth, (state.getItemCount() > 4 ? 4 : state.getItemCount()) * measuredHeight);
            }

        }else{
            super.onMeasure(recycler, state, widthSpec, heightSpec);
        }
    }
}
