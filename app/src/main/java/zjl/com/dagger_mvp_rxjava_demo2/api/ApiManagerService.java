package zjl.com.dagger_mvp_rxjava_demo2.api;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import zjl.com.dagger_mvp_rxjava_demo2.bean.NewsDetail;
import zjl.com.dagger_mvp_rxjava_demo2.bean.NewsList;

/**
 * @className：ApiManagerService Created by weiwei on 2016/3/2.
 */
@SuppressWarnings("ALL")
public interface ApiManagerService {

    @GET("stories/latest")
    Observable<NewsList> getLatestNews();

    @GET("stories/before/{date}")
    Observable<NewsList> getBeforeNews(@Path("date") String date);

    @GET("story/{id}")
    Observable<NewsDetail> getNewsDetail(@Path("id") int id);

}