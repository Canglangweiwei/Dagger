package zjl.com.dagger_mvp_rxjava_demo2.news;


import android.support.annotation.NonNull;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import zjl.com.dagger_mvp_rxjava_demo2.bean.News;
import zjl.com.dagger_mvp_rxjava_demo2.bean.NewsList;

@SuppressWarnings("ALL")
public class NewsPresenter implements NewsContract.Presenter {

    private NewsContract.View view;
    private Subscription mSubscription;
    private ArrayList<News> listdata = new ArrayList<>();

    @Inject
    NewsModel newsModel;

    @Inject
    public NewsPresenter() {
        super();
    }

    @Override
    public void getBeforeNewsListData(String date) {
        mSubscription = newsModel.getBeforeNews(date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<NewsList>() {
                    @Override
                    public void call(NewsList newsList) {
                        for (int z = 0; z < newsList.getStories().size(); z++) {
                            listdata.add(newsList.getStories().get(z));
                        }
                        view.load(listdata);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        System.out.println("-------onFailure" + throwable.getMessage());
                    }
                });
    }

    @Override
    public void getNewsListData() {
        mSubscription = newsModel.getLatestNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<NewsList>() {
                    @Override
                    public void call(NewsList newsList) {
                        listdata.clear();
                        for (int z = 0; z < newsList.getStories().size(); z++) {
                            listdata.add(newsList.getStories().get(z));
                        }
                        view.refresh(listdata);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        System.out.println("-------onFailure" + throwable.getMessage());
                    }
                });
    }

    @Override
    public void getRefreshNewsListData() {
        mSubscription = newsModel.getLatestNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<NewsList>() {
                    @Override
                    public void call(NewsList newsList) {
                        listdata.clear();
                        for (int z = 0; z < newsList.getStories().size(); z++) {
                            listdata.add(newsList.getStories().get(z));
                        }
                        view.refresh(listdata);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        System.out.println("-------onFailure" + throwable.getMessage());
                    }
                });
    }

    @Override
    public void attachView(@NonNull NewsContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
        view = null;
    }
}
