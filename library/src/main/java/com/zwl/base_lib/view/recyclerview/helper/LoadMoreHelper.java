package com.zwl.base_lib.view.recyclerview.helper;

import android.support.v7.widget.RecyclerView;


/**
 * 为recyclerview添加加载更多配置
 * 1考虑到动作的监听是发生在recyclerview
 * 2考虑到adapter应该只用来设置itemview和处理itemview的动作，这个adapter的职责
 * 所以应该通过添加helper的方式来设置recyclerview
 * Created by hasee on 2017/3/25.
 */

public class LoadMoreHelper {
    private RecyclerView mRecyclerView;
    private boolean hasNoData;
    private ILoadCallback loader;

    public LoadMoreHelper(RecyclerView mRecyclerView) {
        this.mRecyclerView = mRecyclerView;
        init();
    }

    private void init() {
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null && layoutManager instanceof ILoadMore) {
                    if (((ILoadMore) layoutManager).isEnd()) {
                        if (loader != null) {
                            if (!hasNoData) {
                                loader.onLoadMore();
                            } else {
                                loader.onNoMoreData();
                            }
                        }
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    public void setHasNoData(boolean hasNoData) {
        this.hasNoData = hasNoData;
    }

    public void setLoader(ILoadCallback loader) {
        this.loader = loader;
    }

    public interface ILoadCallback {
        void onLoadMore();

        void onNoMoreData();
    }

    public static abstract class SimpleLoadCallback implements ILoadCallback {
        boolean hasShowed = false;

        public void onNoMoreData() {
            if (!hasShowed) {
//                ToastUtils.show(MainApplication.getInstance(), R.string.coomon_no_more_data);
                hasShowed = true;
            }
        }

        public void clearState() {
            hasShowed = false;
        }
    }
}
