package zjl.com.dagger_mvp_rxjava_demo2.api;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import zjl.com.dagger_mvp_rxjava_demo2.app.MyApplication;
import zjl.com.dagger_mvp_rxjava_demo2.bean.NewsDetail;
import zjl.com.dagger_mvp_rxjava_demo2.bean.NewsList;

/**
 * <p>
 * 初始化网络加载工具
 * </p>
 * Created by weiwei on 2016/3/2.
 */
public class ApiManager {

    private static final int cacheSize = 10 * 1024 * 1024; // 10 MiB
    private static final Cache cache = new Cache(MyApplication.sApp.getCacheDir(), cacheSize);

    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)       //设置超时时间
            .readTimeout(20, TimeUnit.SECONDS)          //设置读取超时时间
            .writeTimeout(20, TimeUnit.SECONDS)         //设置写入超时时间
            .cache(cache)
            .build();

    private static final Retrofit sRetrofit = new Retrofit.Builder()
            .baseUrl("http://news-at.zhihu.com/api/4/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 使用RxJava作为回调适配器
            .client(okHttpClient)
            .build();

    private static final ApiManagerService apiManager = sRetrofit.create(ApiManagerService.class);

    public static Observable<NewsList> getLatestNews() {
        return apiManager.getLatestNews();
    }

    public static Observable<NewsList> getBeforeNews(String date) {
        return apiManager.getBeforeNews(date);
    }

    public static Observable<NewsDetail> getNewsDetail(int id) {
        return apiManager.getNewsDetail(id);
    }
}