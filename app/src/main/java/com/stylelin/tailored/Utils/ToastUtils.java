package com.stylelin.tailored.Utils;

import android.widget.Toast;

import com.stylelin.tailored.global.App;

/**
 * 创建人:Jonlin
 * 创建时间:2016年7月14日 下午4:27:12
 * 类描述:Toast统一管理类
 */
public class ToastUtils {
    private ToastUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isShow = true;

    /**
     * 短时间显示Toast
     *
     * @param message 提示信息
     */
    public static void showShort(CharSequence message) {
        if (isShow)
            Toast.makeText(App.getInstance().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 短时间显示Toast
     *
     * @param message 提示信息资源ID
     */
    public static void showShort(int message) {
        if (isShow)
            Toast.makeText(App.getInstance().getApplicationContext(), App.getInstance().getString(message), Toast.LENGTH_SHORT).show();
    }

    /**
     * 长时间显示Toast
     *
     * @param message 提示信息
     */
    public static void showLong(CharSequence message) {
        if (isShow)
            Toast.makeText(App.getInstance().getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    /**
     * 长时间显示Toast
     *
     * @param message 提示信息资源ID
     */
    public static void showLong(int message) {
        if (isShow)
            Toast.makeText(App.getInstance().getApplicationContext(), App.getInstance().getString(message), Toast.LENGTH_LONG).show();
    }

    /**
     * 自定义显示Toast时间
     *
     * @param message  提示信息
     * @param duration 显示时间
     */
    public static void show(CharSequence message, int duration) {
        if (isShow)
            Toast.makeText(App.getInstance().getApplicationContext(), message, duration).show();
    }

    /**
     * 自定义显示Toast时间
     *
     * @param message  提示信息资源ID
     * @param duration 显示时间
     */
    public static void show(int message, int duration) {
        if (isShow)
            Toast.makeText(App.getInstance().getApplicationContext(), message, duration).show();
    }
}