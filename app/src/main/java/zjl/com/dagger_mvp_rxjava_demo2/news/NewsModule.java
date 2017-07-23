package zjl.com.dagger_mvp_rxjava_demo2.news;

import dagger.Module;

@SuppressWarnings("ALL")
@Module
public class NewsModule {

    private final NewsContract.View view;

    public NewsModule(NewsContract.View view) {
        this.view = view;
    }
}
