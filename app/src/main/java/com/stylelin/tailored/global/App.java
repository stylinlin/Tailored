package com.stylelin.tailored.global;

import android.app.Application;

import com.stylelin.tailored.Utils.Config;

/**
 * Created by stylelin on 2017/3/9.
 */

public class App extends Application {
    public static String pkName = ""; // App包名
    public static String appVersionName = ""; // App版本号
    public static int appVersionCode; // App版本号
    private static App mInstance; // Application实例

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
        initApp();
    }

    public static App getInstance() {
        return mInstance;
    }

    /**
     * 初始化App基本信息
     */
    private void initApp(){
        try{
            pkName = this.getPackageName();

            this.appVersionName = this.getPackageManager().getPackageInfo(pkName, 0).versionName; // flags 该ApplicationInfo是此flags标记，通常可以直接赋予常数0即可
            this.appVersionCode = this.getPackageManager().getPackageInfo(pkName, 0).versionCode;
            Config.appVersionName = appVersionName; // 将值存入Config中
//            Toast.makeText(this, Config.appVersionName, Toast.LENGTH_SHORT).show();
        }catch (Exception ex){
            this.appVersionName = Config.appVersionName;
        }
    }
}
