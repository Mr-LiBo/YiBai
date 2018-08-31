package libo.com.yibai;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import libo.com.yibai.services.MyService;

public class MainActivity extends Activity implements View.OnClickListener {

    Button btn_TestActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_TestActivity=  findViewById(R.id.btn_TestActivity);
        btn_TestActivity.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_TestActivity:
                    startActivity(new Intent(MainActivity.this,TestActivity.class));
                break;
        }
    }
}
