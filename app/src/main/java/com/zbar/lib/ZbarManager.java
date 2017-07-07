package com.zbar.lib;

/**
 * Created by Francis on 2017-6-27.
 * 测试调用so文件
 */

public class ZbarManager {
    static {
        System.loadLibrary("zbar");
    }

    public native String decode(byte[] data, int width, int height,
                                boolean isCrop, int x, int y, int cwidth, int cheight);
}
