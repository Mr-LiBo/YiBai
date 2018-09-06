package com.libo.yibai.ContentProviderunder;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;

/**
 * @Author LiBo on 2018/9/5.
 * @Email libo205@qq.com
 * @Describe :
 */
public class MyContentObserver extends ContentObserver {
    private Context mContext;


    /**
     * Creates a content observer.
     *
     * @param handler The handler to run {@link #onChange} on, or null if none.
     */
    public MyContentObserver(Context context, Handler handler) {
        super(handler);
        this.mContext = context;

    }

    @Override
    public void onChange(boolean selfChange) {
        super.onChange(selfChange);

            Log.e("MyContentObserver:","观察者监听到数据有变化了"+selfChange);


    }
}
