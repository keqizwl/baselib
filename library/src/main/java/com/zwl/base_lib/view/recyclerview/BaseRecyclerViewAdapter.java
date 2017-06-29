package com.zwl.base_lib.view.recyclerview;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hasee on 2016/7/16.
 */
public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewAdapter.BaseViewHolder<T>> {
    protected Activity baseActivity;

    protected int layoutResId = 0;
    private List<T> datas = new ArrayList<>();

    private OnItemClickListener<T> onItemClickListener;
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            BaseViewHolder<T> baseViewHolder = (BaseViewHolder<T>) v.getTag();
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(BaseRecyclerViewAdapter.this, baseViewHolder.getAdapterPosition());
            }
        }
    };

    public BaseRecyclerViewAdapter(Activity baseActivity, int layoutResId) {
        this.baseActivity = baseActivity;
        this.layoutResId = layoutResId;
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public BaseViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder<T> baseViewHolder = new BaseViewHolder<T>(baseActivity.getLayoutInflater().inflate(layoutResId, parent, false));
        baseViewHolder.itemView.setTag(baseViewHolder);
        baseViewHolder.itemView.setOnClickListener(onClickListener);
        return baseViewHolder;
    }

    @Override
    public abstract void onBindViewHolder(BaseViewHolder<T> holder, int position);

    public static class BaseViewHolder<T> extends RecyclerView.ViewHolder {

        private SparseArray<View> cacheViews = new SparseArray<>();

        public BaseViewHolder(View itemView) {
            super(itemView);
        }

        public void setText(int textViewId, String text) {
            View view = getViewById(textViewId);
            if (view != null) {
                ((TextView) view).setText(text);
            }
        }

        public void setText(int textViewId, CharSequence text) {
            View view = getViewById(textViewId);
            if (view != null) {
                ((TextView) view).setText(text);
            }
        }

        private View getViewById(int viewId) {
            View view = cacheViews.get(viewId);

            if (view == null) {
                view = itemView.findViewById(viewId);
                cacheViews.put(viewId, view);
            }
            return view;
        }

        public void setImageView(int imageViewId, String url) {
            View view = getViewById(imageViewId);
            if (view != null && view instanceof ImageView && !TextUtils.isEmpty(url)) {
//                Picasso.with(view.getContext()).load(url).into((ImageView) view);
            }
        }

        public void setImageView(int imageViewId, String url, int defaultImage) {
            View view = getViewById(imageViewId);
            if (view != null && view instanceof ImageView && !TextUtils.isEmpty(url)) {
//                Picasso.with(view.getContext()).load(url).placeholder(defaultImage).into((ImageView) view);
            }
        }

        public void setViewWidthAndHeight(int id, int width, int height) {
            View view = getViewById(id);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                if (width != layoutParams.width || height != layoutParams.height) {
                    layoutParams.width = width;
                    layoutParams.height = height;
                    view.setLayoutParams(layoutParams);
                }
            }
        }

    }

    public T getItemByPostion(int pos) {
        if (pos < datas.size()) {
            return datas.get(pos);
        }
        return null;
    }

    public void add(T t) {
        if (t != null) {
            datas.add(t);
            notifyDataSetChanged();
        }
    }

    public void addAll(List<T> datas) {
        if (datas != null) {
            this.datas.addAll(datas);
            notifyDataSetChanged();
        }
    }

    public void remove(int pos) {
        if (pos < datas.size()) {
            datas.remove(pos);
            notifyDataSetChanged();
        }
    }

    public void clear() {
        if (datas.size() != 0) {
            datas.clear();
            notifyDataSetChanged();
        }
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener<T> {
        void onItemClick(BaseRecyclerViewAdapter<T> adapter, int pos);
    }

    public List<T> getDatas() {
        return Collections.unmodifiableList(datas);
    }
}
