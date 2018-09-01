package com.libo.yibai.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    private static final String TAG = "MyService";
    /**
     * indicates how to behave if the service is killed
     */
    int mStartMode;
    /**
     * interface for clients that bind
     */
    IBinder mBinder;
    /**
     * indicates whether onRebind should be used
     */
    boolean mAllowRebind;

    /**
     * Called when the service is being created.
     */
    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate");
    }

    /**
     * The service is starting, due to a call to startService()
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onStartCommand");
        return mStartMode;
    }



    /**
     * A client is binding to the service with bindService()
     */
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        return mBinder;
    }


    /**
     * Called when all clients have unbound with unbindService()
     */
    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind");
        return mAllowRebind;
    }

    /**
     * Called when a client is binding to the service with bindService()
     */
    @Override
    public void onRebind(Intent intent) {
        Log.d(TAG, "onRebind");
    }

    /**
     * Called when The service is no longer used and is being destroyed
     */
    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onDestroy");
    }


    //此方法是为了可以在Acitity中获得服务的实例
    public class ServiceBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }
    }

}