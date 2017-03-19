package com.stylelin.tailored;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.stylelin.tailored.Utils.Config;
import com.stylelin.tailored.Utils.PermissionUtils;
import com.stylelin.tailored.home.HomeActivity;
import com.taobao.hotfix.HotFixManager;
import com.taobao.hotfix.PatchLoadStatusListener;
import com.taobao.hotfix.util.PatchStatusCode;

import static com.stylelin.tailored.Utils.Config.REQUEST_EXTERNAL_STORAGE_PERMISSION;

/**
 * 引导页
 */
public class GuideActivity extends Activity {
//    private Subscription subscription;
//    private Subscription subscription;

//    @Bind(R.id.tv_show)
//    TextView tv_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);


//        ButterKnife.bind(this);
        init();
        initHotfix();
    }

    /**
     * 建议在Application.onCreate方法中执行initialize和queryNewHotPatch操作, 尽可能早的执行
     */
    private void initHotfix(){
        //此处不再需要调用queryNewHotPatch方法, initialize方法内部会调用queryNewHotPatch方法.
        HotFixManager.getInstance().setContext(GuideActivity.this.getApplication())
                .setAppVersion(Config.appVersionName)
                .setAppId(Config.ALiAppId)
                .setAesKey(null)
                .setSupportHotpatch(true)
                .setEnableDebug(true)
                .setPatchLoadStatusStub(new PatchLoadStatusListener() {
                    @Override
                    public void onload(final int mode, final int code, final String info, final int handlePatchVersion) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Mode:").append(mode).append(" Code:").append(code).append(" Info:").append(info).append(" HandlePatchVersion:").append(handlePatchVersion);
                                ((TextView)findViewById(R.id.tv_show)).setText(stringBuilder.toString());
//                                tv_show.setText(stringBuilder.toString());
                            }
                        });

                        // 补丁加载回调通知
                        if (code == PatchStatusCode.CODE_SUCCESS_LOAD) {
                            // TODO: 10/24/16 表明补丁加载成功
                        } else if (code == PatchStatusCode.CODE_ERROR_NEEDRESTART) {
                            // TODO: 10/24/16 表明新补丁生效需要重启. 业务方可自行实现逻辑, 提示用户或者强制重启, 建议: 用户可以监听进入后台事件, 然后应用自杀
                        } else if (code == PatchStatusCode.CODE_ERROR_INNERENGINEFAIL) {
                            // 内部引擎加载异常, 推荐此时清空本地补丁, 但是不清空本地版本号, 防止失败补丁重复加载
                            //HotFixManager.getInstance().cleanPatches(false);
                        } else {
                            // TODO: 10/25/16 其它错误信息, 查看PatchStatusCode类说明
                        }
                    }
                }).initialize();
    }

    private void init() {
        // 如果本地补丁放在了外部存储卡中,6.0以上需要申请读外部存储卡权限
        if (Build.VERSION.SDK_INT >= 23) {
            PermissionUtils.requestExternalStoragePermission(this);
        }

//        HotFixManager.getInstance().queryNewHotPatch(); // 拉取最新补丁
//        HotFixManager.getInstance().cleanPatches(true); // 清除历史补丁

        goHomeActivity();
    }

    /**
     * 倒计时进入首页
     */
    private void goHomeActivity() {
//        subscription = Observable.timer(getResources().getInteger(R.integer.int3000), TimeUnit.MILLISECONDS)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<Long>() {
//                    @Override
//                    public void call(Long aLong) {
                        Intent intent = new Intent(GuideActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
//                    }
//                });
    }

    /**
     * 获取权限回调
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_EXTERNAL_STORAGE_PERMISSION:
                if (grantResults.length <= 0 || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    // 获取权限失败处理...
                    // updateConsole("local external storage patch is invalid as not read external storage permission");
                }
                break;
            default:
        }
    }
}
