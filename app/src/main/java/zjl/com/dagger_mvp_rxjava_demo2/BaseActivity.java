package zjl.com.dagger_mvp_rxjava_demo2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import zjl.com.dagger_mvp_rxjava_demo2.app.ApplicationComponent;
import zjl.com.dagger_mvp_rxjava_demo2.app.MyApplication;

/**
 * <p>
 * 描述：BaseActivity
 * </p>
 * Created by weiwei on 2016/8/26.
 */
public abstract class BaseActivity extends AppCompatActivity {

    /**
     * Called when a activity page is first load
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initContentView());
        setupComponent(MyApplication.sApp.component());
        initUi();
        initDatas();
        initListener();
    }

    /**
     * 设置页面
     */
    public abstract int initContentView();

    /**
     * Dagger2绑定
     */
    protected abstract void setupComponent(ApplicationComponent component);

    /**
     * 初始化页面信息
     */
    protected abstract void initUi();

    /**
     * 初始化数据信息
     */
    protected abstract void initDatas();

    /**
     * 初始化监听事件
     */
    protected abstract void initListener();
}
