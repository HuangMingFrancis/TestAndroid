package com.ylz.readcard;

/**
 * Created by zhuanghz on 2017/6/26.
 */

public class CardRead {

    static {
        try {
            System.loadLibrary("cardRead");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public int getCard()
    {

        return iRead_IdInfo("str");
    }

    public static native int iRead_IdInfo(String str);

    public static native int iRead_CardInfo(String str);

    public static native int iRead_BankNo(String str);

}
