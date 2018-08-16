package android.zj.com.rcvheaderdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

public abstract class MyAdapter<T> extends RecyclerView.Adapter<ViewHolder> {

    private Context mContext;
    private int mLayoutid;
    private List<T> mDatas;
    private AdapterView.OnItemClickListener monItemClickListener = null;
    private int ITEM_TYPE_HEADER = 1;
    private int ITEM_TYPE_NORMAL = 0;

    /**
     * headerview容器
     */
    private List<View> mHeaderViews = new ArrayList<>();

    /**
     * 添加header
     * @param header
     */
    public void addHeaderView(View header){
        mHeaderViews.add(header);
        notifyDataSetChanged();
    }

    /**
     * adapter构造函数
     * @param mContext
     * @param mLayoutid
     * @param mDatas
     */
    public MyAdapter(Context mContext, int mLayoutid, List<T> mDatas) {
        this.mContext = mContext;
        this.mLayoutid = mLayoutid;
        this.mDatas = mDatas;
    }

    @Override
    public int getItemViewType(int position)
    {
        if(position < mHeaderViews.size()){
            return ITEM_TYPE_HEADER;
        }

        return ITEM_TYPE_NORMAL;
    }

    /**
     * onCreateViewHolder  --> inflate操作  根据 ItemViewType 渲染不同的布局
     * */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ViewHolder viewHolder = null;

        if (viewType == ITEM_TYPE_HEADER) {
            viewHolder = ViewHolder.getHolderByView(mContext, parent, mHeaderViews.get(mHeaderViews.size()-1));
        } else {
            viewHolder = ViewHolder.getHolderById(mContext, parent, mLayoutid);
        }

        return viewHolder;
    }

    /**
     * 暴露出来的接口
     * @param holder
     * @param position
     */
    public abstract void convert(ViewHolder holder, T position);

    /**
     * 摆放
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if(position < mHeaderViews.size()){
            return;
        }

        convert(holder, mDatas.get(position));
    }

    /**
     * 获取高度
     *
     * @return
     */
    @Override
    public int getItemCount() {
        if (mDatas == null) {
            return 0;
        }
        return mDatas.size();
    }

}
