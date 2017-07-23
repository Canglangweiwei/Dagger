package zjl.com.dagger_mvp_rxjava_demo2;

import android.support.annotation.NonNull;

/**
 * <p>
 * BasePresenter
 * </p>
 * Created by weiwei on 2016/8/26.
 */
public interface BasePresenter<T extends BaseView> {

    /**
     * 绑定view，这个方法将会在activity中调用
     *
     * @param view 页面
     */
    void attachView(@NonNull T view);

    /**
     * 解绑
     */
    void detachView();
}

