package zjl.com.dagger_mvp_rxjava_demo2.news;


import java.util.ArrayList;

import zjl.com.dagger_mvp_rxjava_demo2.BasePresenter;
import zjl.com.dagger_mvp_rxjava_demo2.BaseView;
import zjl.com.dagger_mvp_rxjava_demo2.bean.News;

@SuppressWarnings("ALL")
public interface NewsContract {

    interface View extends BaseView {
        void load(ArrayList<News> list);

        void refresh(ArrayList<News> list);
    }

    interface Presenter extends BasePresenter<View> {
        void getBeforeNewsListData(String date);

        void getNewsListData();

        void getRefreshNewsListData();
    }
}
















