package com.stylelin.tailored.TestWidgetActivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.stylelin.tailored.R;

/**
 * Created by Jonlin on 2017/3/17.
 * Description:测试AppCompat
 */

public class TestAppCompatActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_compat_widget_layout);
    }
}
