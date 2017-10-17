package com.example.francis.testandroid.view.recycler_view;

import android.content.Context;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.francis.testandroid.R;

import java.util.List;

/**
 * Created by Francis on 2017/10/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater layoutInflater;
    private Context mContext;
    private List<String> dataList;

    public RecyclerViewAdapter(Context mContext, List<String> dataList){
        this.mContext = mContext;
        this.dataList = dataList;
        layoutInflater = LayoutInflater.from(mContext);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0){
            return new Item1ViewHolder(layoutInflater.inflate(R.layout.item_1, parent, false));
        }
        if (viewType == 1){
            return new Item2ViewHolder(layoutInflater.inflate(R.layout.item_2, parent, false));
        }
        if (viewType == 2){
            return new Item3ViewHolder(layoutInflater.inflate(R.layout.item_3, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class Item1ViewHolder extends RecyclerView.ViewHolder{

        public Item1ViewHolder(View itemView) {
            super(itemView);
        }
    }


    public class Item2ViewHolder extends RecyclerView.ViewHolder{

        public Item2ViewHolder(View itemView) {
            super(itemView);
        }
    }


    public class Item3ViewHolder extends RecyclerView.ViewHolder{

        public Item3ViewHolder(View itemView) {
            super(itemView);
        }
    }


    @Override
    public int getItemViewType(int position) {
        if (dataList.get(position).equals("hello1")){
            return 0;

        }
        if (dataList.get(position).equals("hello2")){
            return 1;
        }
        if (dataList.get(position).equals("hello3")){
            return 2;
        }
        return super.getItemViewType(position);
    }
}
