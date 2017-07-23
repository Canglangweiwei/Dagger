package zjl.com.dagger_mvp_rxjava_demo2.news;


import javax.inject.Inject;

import rx.Observable;
import zjl.com.dagger_mvp_rxjava_demo2.api.ApiManager;
import zjl.com.dagger_mvp_rxjava_demo2.bean.NewsList;

@SuppressWarnings("ALL")
public class NewsModel {

    @Inject
    public NewsModel() {
        super();
    }

    Observable<NewsList> getLatestNews() {
        return ApiManager.getLatestNews();
    }

    Observable<NewsList> getBeforeNews(String date) {
        return ApiManager.getBeforeNews(date);
    }
}













