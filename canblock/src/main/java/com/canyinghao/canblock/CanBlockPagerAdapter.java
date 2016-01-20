package com.canyinghao.canblock;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangjian on 15/12/21.
 */
public class CanBlockPagerAdapter extends RecyclerView.Adapter<CanBlockPagerAdapter.BlockHolder> {


    private List<CanBlock> mList;
    private RecyclerView recyclerView;

    public CanBlockPagerAdapter(RecyclerView recyclerView) {
        this.mList = new ArrayList<>();
        this.recyclerView = recyclerView;
    }

    public CanBlockPagerAdapter(RecyclerView recyclerView, List<CanBlock> mList) {

        this(recyclerView);
        if (mList != null && !mList.isEmpty()) {
            this.mList.addAll(mList);
        }


    }

    /**
     * 获取数据
     *
     * @return
     */
    public List<CanBlock> getList() {
        return mList;
    }

    /**
     * 添加到头部
     *
     * @param datas
     */
    public void addNewList(List<CanBlock> datas) {
        if (datas != null && !datas.isEmpty()) {
            mList.addAll(0, datas);
            notifyDataSetChanged();
        }
    }

    /**
     * 添加到末尾
     *
     * @param datas
     */
    public void addMoreList(List<CanBlock> datas) {
        if (datas != null && !datas.isEmpty()) {
            mList.addAll(datas);
            notifyDataSetChanged();
        }
    }


    /**
     * 设置数据
     *
     * @param datas
     */
    public void setList(List<CanBlock> datas) {

        mList.clear();

        if (datas != null && !datas.isEmpty()) {
            mList.addAll(datas);
        }
        notifyDataSetChanged();
    }

    /**
     * 清空
     */
    public void clear() {
        mList.clear();
        notifyDataSetChanged();
    }

    @Override
    public BlockHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new BlockHolder(new LinearLayout(parent.getContext()));

    }

    @Override
    public void onBindViewHolder(BlockHolder holder, int position) {

        CanBlock block = mList.get(position);

        LinearLayout ll = (LinearLayout) holder.itemView;

        addView(ll, block.getContentView());

    }


    @Override
    public int getItemCount() {
        return mList.size();
    }


    private void addView(LinearLayout ll, View v) {

        int index = ll.indexOfChild(v);

        if (index < 0) {
            ll.addView(v);
        }

        index = ll.indexOfChild(v);
        if (index >= 0) {

            int count = ll.getChildCount();


            for (int i = 0; i < count; i++) {

                View view = ll.getChildAt(i);
                view.setVisibility(View.GONE);
                if (i == index) {
                    view.setVisibility(View.VISIBLE);
                }

            }

        }

    }


    class BlockHolder extends RecyclerView.ViewHolder {


        public BlockHolder(View itemView) {
            super(itemView);

            ViewGroup.LayoutParams lp = itemView.getLayoutParams() == null ? new ViewGroup.LayoutParams(-1, -1) : itemView.getLayoutParams();
            if (recyclerView.getLayoutManager().canScrollHorizontally()) {
                lp.width = recyclerView.getWidth() - recyclerView.getPaddingLeft() - recyclerView.getPaddingRight();
            } else {
                lp.height = recyclerView.getHeight() - recyclerView.getPaddingTop() - recyclerView.getPaddingBottom();
            }

            itemView.setLayoutParams(lp);
        }
    }

}
