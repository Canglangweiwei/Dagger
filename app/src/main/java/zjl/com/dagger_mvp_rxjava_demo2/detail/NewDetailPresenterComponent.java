package zjl.com.dagger_mvp_rxjava_demo2.detail;

import dagger.Component;
import zjl.com.dagger_mvp_rxjava_demo2.app.ApplicationComponent;

@SuppressWarnings("ALL")
@Component(dependencies = ApplicationComponent.class, modules = NewDetailModule.class)
public interface NewDetailPresenterComponent {
    void inject(NewDetailActivity newDetailActivity);
}
