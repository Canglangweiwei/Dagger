package zjl.com.dagger_mvp_rxjava_demo2.detail;

import javax.inject.Inject;

import rx.Observable;
import zjl.com.dagger_mvp_rxjava_demo2.api.ApiManager;
import zjl.com.dagger_mvp_rxjava_demo2.bean.NewsDetail;

@SuppressWarnings("ALL")
public class NewDetailModel {

    @Inject
    public NewDetailModel() {
        super();
    }

    /**
     * 获取新闻详情信息
     *
     * @param id 新闻id
     * @return Observable<NewsDetail>
     */
    Observable<NewsDetail> getNewsDetail(int id) {
        return ApiManager.getNewsDetail(id);
    }
}
