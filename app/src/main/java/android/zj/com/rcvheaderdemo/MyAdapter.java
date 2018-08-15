package android.zj.com.rcvheaderdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.List;

public abstract class MyAdapter<T> extends RecyclerView.Adapter<ViewHolder> {

    private Context mContext;
    private int mLayoutid;
    private List<T> mDatas;
    private AdapterView.OnItemClickListener monItemClickListener = null;


    public MyAdapter(Context mContext, int mLayoutid, List<T> mDatas) {
        this.mContext = mContext;
        this.mLayoutid = mLayoutid;
        this.mDatas = mDatas;
    }

    /**
     * inflate操作
     * */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = ViewHolder.get(mContext, parent, mLayoutid);
        return viewHolder;
    }

    /**
     * 暴露出来的接口
     * @param holder
     * @param position
     */
    public abstract void convert(ViewHolder holder, T position);

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
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
