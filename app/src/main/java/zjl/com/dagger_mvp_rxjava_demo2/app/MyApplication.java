package zjl.com.dagger_mvp_rxjava_demo2.app;

import android.app.Application;
import android.content.Context;

@SuppressWarnings("ALL")
public class MyApplication extends Application {

    private ApplicationComponent applicationComponent;

    public static MyApplication get(Context context) {
        return (MyApplication) context.getApplicationContext();
    }

    public static MyApplication sApp;

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
        setGraph();
    }

    private void setGraph() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
//        applicationComponent.inject(this);// 现在没有需要在MyApplication注入的对象，所以这句代码可写可不写
    }

    public ApplicationComponent component() {
        return applicationComponent;
    }
}
