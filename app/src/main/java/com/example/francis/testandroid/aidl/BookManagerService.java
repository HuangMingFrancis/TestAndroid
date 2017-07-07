package com.example.francis.testandroid.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Francis on 2017-7-4.
 */

public class BookManagerService extends Service {

    private static final String TAG = "BookManagerService";

    private AtomicBoolean mIsServiceDestoryed = new AtomicBoolean(false);

    private CopyOnWriteArrayList<Book> mBookList = new CopyOnWriteArrayList<>();

    private CopyOnWriteArrayList<IOnNewBookArrivedListener> mListenerList = new CopyOnWriteArrayList<>();

//    private RemoteCallbackList<IOnNewBookArrivedListener> mListenerList = new RemoteCallbackList<>();



    private Binder mBinder = new IBookManager.Stub(){

        @Override
        public List<Book> getBookList() throws RemoteException {
            return mBookList;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            mBookList.add(book);
        }

        @Override
        public void registerListener(IOnNewBookArrivedListener listener) throws RemoteException {
            if (!mListenerList.contains(listener)){
                if (listener == null){
                    Log.d(TAG, "registerListener: listener is null");
                }
                mListenerList.add(listener);
            }else{
                Log.d(TAG, "registerListener: already exists");
            }
            Log.d(TAG, "registerListener: size: " + mListenerList.size());

//            mListenerList.register(listener);
        }

        @Override
        public void unregisterListener(IOnNewBookArrivedListener listener) throws RemoteException {
            if (mListenerList.contains(listener)){
                mListenerList.remove(listener);
                Log.d(TAG, "unregisterListener: unregister success");
            }else{
                Log.d(TAG, "unregisterListener: not found");
            }
            Log.d(TAG, "unregisterListener: size: " + mListenerList.size());

//            mListenerList.unregister(listener);
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        mBookList.add(new Book(1, "Android"));
        mBookList.add(new Book(2, "IOS"));
        new Thread(new ServiceWorker()).start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mIsServiceDestoryed.set(true);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private void onNewBookArrived(Book book) throws RemoteException {
        mBookList.add(book);
        Log.d(TAG, "onNewBookArrived: notify listeners: " + mListenerList.size() + " book:" + book.toString());
        for (int i = 0; i < mListenerList.size(); i++){
            IOnNewBookArrivedListener listener = mListenerList.get(i);
            if (listener == null){
                Log.d(TAG, "onNewBookArrived: listener is null");
            }else{
                listener.onNewBookArrived(book);
            }
        }

//        final int N = mListenerList.beginBroadcast();
//        for (int i = 0; i < N; i++){
//            IOnNewBookArrivedListener l = mListenerList.getBroadcastItem(i);
//            if (l != null){
//                l.onNewBookArrived(book);
//            }else{
//                Log.d(TAG, "onNewBookArrived: listener is null");
//            }
//        }
//        mListenerList.finishBroadcast();
    }

    private class ServiceWorker implements Runnable{

        @Override
        public void run() {
            while (!mIsServiceDestoryed.get()){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int bookId = mBookList.size() + 1;
                Book newBook = new Book(bookId, "new Book#" + bookId);
                try {
                    onNewBookArrived(newBook);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
