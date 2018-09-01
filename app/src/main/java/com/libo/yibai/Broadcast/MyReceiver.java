package com.libo.yibai.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * @Author LiBo on 2018/9/1.
 * @Email libo205@qq.com
 * @Describe : 创建广播接收器
 */
public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Intent Detected.", Toast.LENGTH_LONG).show();
        Log.d("MyReceiver","onReceive 广播被拦截了");
    }
}
