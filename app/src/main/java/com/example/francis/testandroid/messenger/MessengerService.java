package com.example.francis.testandroid.messenger;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Francis on 2017-7-9.
 */

public class MessengerService extends Service{

    private static final String TAG = "MessengerService";

    public static final int MSG_FROM_CLIENT = 0;

    private static class MessengerHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MSG_FROM_CLIENT:
                    Log.i(TAG, "handleMessage: receive msg from Client: " + msg.getData().getString("msg"));
                    //收到消息的同时发送一条消息给客户端, 要调用replyTo
                    Messenger client = msg.replyTo;
                    Message replyMessage = Message.obtain(null, MessengerService.MSG_FROM_CLIENT);
                    Bundle bundle = new Bundle();
                    bundle.putString("reply", "你的消息我已经收到, 稍后回复你!");
                    replyMessage.setData(bundle);
                    try {
                        client.send(replyMessage);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }

    private final Messenger mMessenger = new Messenger(new MessengerHandler());

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mMessenger.getBinder();
    }
}
