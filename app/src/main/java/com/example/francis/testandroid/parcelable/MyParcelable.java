package com.example.francis.testandroid.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Francis on 2017/6/11.
 * 测试Parcelable
 */

public class MyParcelable implements Parcelable {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyParcelable(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static final Creator<MyParcelable> CREATOR = new Creator<MyParcelable>() {
        @Override
        public MyParcelable createFromParcel(Parcel in) {
            //读数据进行恢复
            return new MyParcelable(in.readInt(),in.readString()
            );
        }

        @Override
        public MyParcelable[] newArray(int size) {
            return new MyParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    // 写数据进行保存
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }
}
