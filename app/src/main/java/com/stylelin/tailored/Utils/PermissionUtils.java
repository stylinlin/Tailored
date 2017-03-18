package com.stylelin.tailored.Utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by stylelin on 2017/3/9.
 * 请求权限工具类
 */

public class PermissionUtils {

    /**
     * 6.0以上需要申请读外部存储卡权限才能够使用. 应用内部存储则不受影响
     */
    public static void requestExternalStoragePermission(Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    Config.REQUEST_EXTERNAL_STORAGE_PERMISSION);
        }
    }
}
