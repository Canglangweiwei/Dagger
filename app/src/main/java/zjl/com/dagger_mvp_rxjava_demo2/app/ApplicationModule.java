package zjl.com.dagger_mvp_rxjava_demo2.app;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * <p>
 * application
 * </p>
 * Created by weiwei on 2016/8/31.
 */
@SuppressWarnings("ALL")
@Module
public class ApplicationModule {

    private Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }
}
