package com.example.francis.testandroid.aidl;

import android.os.RemoteException;

/**
 * Created by Francis on 2017-7-9.
 */

public class ComputeImpl extends ICompute.Stub {
    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}
