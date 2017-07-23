package zjl.com.dagger_mvp_rxjava_demo2.news;


import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import zjl.com.dagger_mvp_rxjava_demo2.BaseActivity;
import zjl.com.dagger_mvp_rxjava_demo2.R;
import zjl.com.dagger_mvp_rxjava_demo2.adapter.NewsAdapter;
import zjl.com.dagger_mvp_rxjava_demo2.app.ApplicationComponent;
import zjl.com.dagger_mvp_rxjava_demo2.bean.News;
import zjl.com.dagger_mvp_rxjava_demo2.utils.DividerItemDecoration;

/**
 * <p>
 * 新闻列表
 * </p>
 * Created by weiwei on 2016/8/26.
 */
public class NewsActivity extends BaseActivity implements NewsContract.View {

    @Bind(R.id.recyclerview)
    XRecyclerView mxRecyclerView;

    private NewsAdapter newsAdapter;
    private List<News> listData = new ArrayList<>();

    @Inject
    NewsPresenter newsPresenter;

    @Override
    protected void initUi() {
        ButterKnife.bind(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mxRecyclerView.setLayoutManager(layoutManager);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST);
        mxRecyclerView.addItemDecoration(itemDecoration);

        mxRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);//设置刷新类型
        mxRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.Pacman);//设置加载类型
        //  mRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);//设置下拉箭头
        mxRecyclerView.setRefreshing(true);
    }

    @Override
    protected void initDatas() {
        newsAdapter = new NewsAdapter(this, listData);
        mxRecyclerView.setAdapter(newsAdapter);

        newsPresenter.attachView(this);
        newsPresenter.getNewsListData();
    }

    @Override
    protected void initListener() {
        mxRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        newsPresenter.getRefreshNewsListData();
                        mxRecyclerView.refreshComplete();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        newsPresenter.getBeforeNewsListData("20160811");
                        mxRecyclerView.loadMoreComplete();
                    }
                }, 1000);
            }
        });
    }

    @Override
    public void load(ArrayList<News> list) {
        for (int z = 0; z < list.size(); z++) {
            listData.add(list.get(z));
        }
        newsAdapter.notifyDataSetChanged();
    }

    @Override
    public void refresh(ArrayList<News> list) {
        listData.clear();
        for (int z = 0; z < list.size(); z++) {
            listData.add(list.get(z));
        }
        newsAdapter.notifyDataSetChanged();
    }

    @Override
    protected void setupComponent(ApplicationComponent component) {
        DaggerNewsPresenterComponent.builder()
                .applicationComponent(component)
                .newsModule(new NewsModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        newsPresenter.detachView();
    }
}


















