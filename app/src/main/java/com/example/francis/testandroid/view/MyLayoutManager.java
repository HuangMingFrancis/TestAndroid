package com.example.francis.testandroid.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Francis.Huang on 2017/10/19.
 */

public class MyLayoutManager extends LinearLayoutManager {
    public MyLayoutManager(Context context) {
        super(context);
    }

    @Override
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec) {
        if (state.getItemCount() > 0) {
            View view = recycler.getViewForPosition(0);
            if (view != null) {
                measureChild(view, widthSpec, heightSpec);
                int measuredWidth = View.MeasureSpec.getSize(widthSpec);
                int measuredHeight = view.getMeasuredHeight();
                setMeasuredDimension(measuredWidth, measuredHeight * (state.getItemCount() > 2 ? 2 : state.getItemCount()));
//                setMeasuredDimension(measuredWidth, measuredHeight);
            }
        } else {
            super.onMeasure(recycler, state, widthSpec, heightSpec);
        }
    }
}
