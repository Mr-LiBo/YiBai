package libo.com.yibai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import libo.com.yibai.services.MyService;


public class TestActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnStartService;
    Button btnStopService;
    Button btnBindService;
    Button btnUnBindService;
    private static final String TAG = "TestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Log.d(TAG, "onCreate");


        btnStartService = findViewById(R.id.btn_start);
        btnStopService = findViewById(R.id.btn_stop);


        btnBindService = findViewById(R.id.btn_bind);
        btnUnBindService = findViewById(R.id.btn_unbind);

        btnStopService.setOnClickListener(this);
        btnStartService.setOnClickListener(this);

        btnBindService.setOnClickListener(this);
        btnUnBindService.setOnClickListener(this);
    }

//1.通过startservice开启的服务.一旦服务开启, 这个服务和开启他的调用者之间就没有任何的关系了.
//    调用者不可以访问 service里面的方法. 调用者如果被系统回收了或者调用了ondestroy方法, service还会继续存在
//2.通过bindService开启的服务,服务开启之后,调用者和服务之间 还存在着联系 ,
//    一旦调用者挂掉了.service也会跟着挂掉 .


//    。如 一个intent想要播放音乐，通过startService() 方法启动后台播放音乐的service。然后，也许用户想要操作播放器或者获取当前正在播放的乐曲的信息，一个activity就会通过 bindService()建立一个到此service的连接. 这种情况下 stopService() 在全部的连接关闭后才会真正停止service。
//onCreate()方法和onDestroy()方法是针对所有的services，
//只有通过startService()方法启动service服务时才会调用onStart()方法。

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                // startService  ——>  onCreate  ——>  onStartCommand  ——>  onDestroy  ——>stopService
                startService(new Intent(getBaseContext(), MyService.class));
                break;

            case R.id.btn_stop:
                //只要调用一次stopService()方法便可以停止服务，无论之前它被调用了多少次的启动服务方法。
                stopService(new Intent(getBaseContext(), MyService.class));
                break;

            //过Context.bindService()方法来绑定服务，Context.unbindService()方法来关闭服务。
            // 多个客户端可以绑定同一个服务，如果Service还未被启动，bindService()方法可以启动服务。
//            bindService()  ——> onCreate()  ——> onBind()  ——> Service running  ——> onUnbind()  ——> onDestroy()  ——> Service stop
            case R.id.btn_bind:
                Intent intent = new Intent(TestActivity.this, MyService.class);
                bindService(intent, conn, Context.BIND_AUTO_CREATE);

                break;
            case R.id.btn_unbind:
                unbindService(conn);
                break;
        }
    }

    /**
     * 参数设置
     */
    MyService myService;
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myService = ((MyService.ServiceBinder) service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            myService = null;
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "The onPause() event");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "The onStop() event");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "The onDestroy() event");
    }
}
