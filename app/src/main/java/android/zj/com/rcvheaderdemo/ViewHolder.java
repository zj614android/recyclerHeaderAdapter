package android.zj.com.rcvheaderdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * ViewHolder
 */
public class ViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews;
    private View mConvertView;

    /**
     * 0.VuewHolder构造函数
     * @param context
     * @param itemview
     * @param parent
     */
    public ViewHolder(Context context, View itemview, ViewGroup parent) {
        super(itemview);
        mConvertView = itemview;
        mViews = new SparseArray<View>();
    }

    /**
     * 1.渲染条目，并创建viewholder，这个方法一般在onCreateViewHolder内进行调用
     * @param context
     * @param parent
     * @param layoutid
     * @return
     */
    public static ViewHolder getHolderById(Context context, ViewGroup parent, int layoutid) {
        View itemview = LayoutInflater.from(context).inflate(layoutid, parent, false);
        ViewHolder holder = new ViewHolder(context, itemview, parent);
        return holder;
    }

    public static ViewHolder getHolderByView(Context context, ViewGroup parent, View view) {
        ViewHolder holder = new ViewHolder(context, view, parent);
        return holder;
    }

    /**
     * 2.扩展方法，根据ViewId获取View
     * @param viewid
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewid) {
        View view = mViews.get(viewid);
        if (view == null) {
            view = mConvertView.findViewById(viewid);
            mViews.put(viewid, view);
        }
        return (T) view;
    }
}

