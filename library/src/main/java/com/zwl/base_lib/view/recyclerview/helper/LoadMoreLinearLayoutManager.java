package com.zwl.base_lib.view.recyclerview.helper;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;

/**
 * Created by hasee on 2017/3/25.
 */

public class LoadMoreLinearLayoutManager extends LinearLayoutManager implements ILoadMore {

    public LoadMoreLinearLayoutManager(Context context) {
        super(context);
    }

    public LoadMoreLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public LoadMoreLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean isEnd() {
        int lastVisibleItem = findLastCompletelyVisibleItemPosition();
        int totalItemCount = getItemCount();

        return lastVisibleItem == (totalItemCount - 1);
    }
}
