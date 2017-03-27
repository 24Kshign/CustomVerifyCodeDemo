package com.share.jack.customverifycodeviewdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.share.jack.customverifycodeviewdemo.widget.CustomVerifyCodeView;

public class MainActivity extends Activity {

    private CustomVerifyCodeView customVerifyCodeView;
    private Button btnToRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customVerifyCodeView = (CustomVerifyCodeView) findViewById(R.id.am_verify_code);
        btnToRecyclerView = (Button) findViewById(R.id.am_btn_to_recyclerview);
        customVerifyCodeView.setTimeCount(60);
        customVerifyCodeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击了按钮", Toast.LENGTH_SHORT).show();
                customVerifyCodeView.startAnim();
            }
        });
        btnToRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
            }
        });
    }
}
