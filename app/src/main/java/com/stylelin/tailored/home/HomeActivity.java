package com.stylelin.tailored.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.stylelin.tailored.R;
import com.stylelin.tailored.TestWidgetActivity.TestAppCompatActivity;
import com.stylelin.tailored.TestWidgetActivity.TestMyViewActivity;
import com.taobao.hotfix.HotFixManager;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Jonlin on 2017/3/9.
 * Description:首页
 */

public class HomeActivity extends Activity {

    @Bind(R.id.btn_crash)
    Button btn_crash;
    @Bind(R.id.btn_clean)
    Button btn_clean;
    @Bind(R.id.btn_get)
    Button btn_get;
    @Bind(R.id.btn_my_view)
    Button btn_my_view;
    @Bind(R.id.btn_app_compat)
    Button btn_app_compat;


    @OnClick({R.id.btn_crash, R.id.btn_clean, R.id.btn_get, R.id.btn_my_view, R.id.btn_app_compat})
    void onclick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_crash:
                Toast.makeText(HomeActivity.this, "修复Bug！", Toast.LENGTH_SHORT).show();
//                int i = Integer.parseInt("dwa");
                break;
            case R.id.btn_clean:
                HotFixManager.getInstance().cleanPatches(true);
                break;
            case R.id.btn_get:
                HotFixManager.getInstance().queryNewHotPatch();
                break;
            case R.id.btn_my_view:
                intent.setClass(HomeActivity.this, TestMyViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_app_compat:
                intent.setClass(HomeActivity.this, TestAppCompatActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }
}
