package zjl.com.dagger_mvp_rxjava_demo2.detail;

import dagger.Module;
import dagger.Provides;

@SuppressWarnings("ALL")
@Module
public class NewDetailModule {

    private final NewDetailContract.View view;
    private int id;

    public NewDetailModule(NewDetailContract.View view, int id) {
        this.view = view;
        this.id = id;
    }

    @Provides
    public int provideid() {
        return id;
    }
}
