package com.share.jack.customverifycodeviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.share.jack.customverifycodeviewdemo.http.callback.CygSubscriberApi;
import com.share.jack.customverifycodeviewdemo.model.RecyclerViewModel;
import com.share.jack.customverifycodeviewdemo.model.entity.RecyclerViewBean;

import java.util.List;

/**
 *
 */

public class RecyclerViewActivity extends Activity {

    private TextView tvText;
    private Button btnApply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        initView();
    }

    private void initView() {
        tvText = (TextView) findViewById(R.id.ar_tv_text);
        btnApply = (Button) findViewById(R.id.ar_btn_apply);
        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerViewModel.getInstance().executeGet(new CygSubscriberApi<List<RecyclerViewBean>>(RecyclerViewActivity.this, "加载中...") {
                    @Override
                    protected void onBaseNext(List<RecyclerViewBean> data) {
                        tvText.setText("size---->" + data.size());
                    }
                });
            }
        });
    }
}
