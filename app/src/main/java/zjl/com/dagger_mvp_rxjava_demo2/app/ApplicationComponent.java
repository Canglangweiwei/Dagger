package zjl.com.dagger_mvp_rxjava_demo2.app;

import dagger.Component;

/**
 * <p>
 * application
 * </p>
 * Created by weiwei on 2016/8/31.
 */
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(MyApplication myApplication);
}
