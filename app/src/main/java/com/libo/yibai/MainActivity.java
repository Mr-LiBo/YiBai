package com.libo.yibai;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.libo.yibai.services.TestActivity;

import com.libo.yibai.R;

public class MainActivity extends Activity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    Button btn_TestActivity, btn_broadcast_receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_TestActivity = findViewById(R.id.btn_TestActivity);
        btn_TestActivity.setOnClickListener(this);

        btn_broadcast_receiver = findViewById(R.id.btn_broadcast_receiver);
        btn_broadcast_receiver.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_TestActivity:
                Log.d(TAG, "btn_TestActivity onClick");
                startActivity(new Intent(MainActivity.this, TestActivity.class));
                break;
            case R.id.btn_broadcast_receiver:
                Log.d(TAG, "btn_broadcast_receiver onClick 正在发送广播");
                sendBroadcast(new Intent().setAction("com.libo.yibai.Broadcast.MyReceiver"));
                break;
        }
    }
}
