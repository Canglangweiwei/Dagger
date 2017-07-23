package zjl.com.dagger_mvp_rxjava_demo2.news;

import dagger.Component;
import zjl.com.dagger_mvp_rxjava_demo2.app.ApplicationComponent;

@SuppressWarnings("ALL")
@Component(dependencies = ApplicationComponent.class, modules = NewsModule.class)
public interface NewsPresenterComponent {
    void inject(NewsActivity newsActivity);
}
