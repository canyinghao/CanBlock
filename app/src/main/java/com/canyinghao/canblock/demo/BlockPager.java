package com.canyinghao.canblock.demo;

import android.widget.TextView;

import com.canyinghao.canblock.CanBlock;

/**
 * Created by yangjian on 15/12/21.
 */
public class BlockPager extends CanBlock {

    TextView tv_notice;

    int page;

    public BlockPager(int page) {
        this.page = page;
    }

    @Override
    public void initView() {

        setContentView(R.layout.block);


        TextView tv_title = (TextView) findViewById(R.id.tv_title);
        TextView tv_add = (TextView) findViewById(R.id.tv_add);

         tv_notice = (TextView) findViewById(R.id.tv_notice);

        tv_title.setText("BlockPager"+page);
        tv_add.setText("ViewPager测试页面");
        tv_notice.setText("");
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }
}
