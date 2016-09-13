package com.canyinghao.canblock.demo;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.canyinghao.canblock.CanBlock;

/**
 * Created by yangjian on 15/12/21.
 */
public class Block3 extends CanBlock {

    TextView tv_notice;
    @Override
    public void initView() {

        setContentView(R.layout.block);


        TextView tv_title = (TextView) findViewById(R.id.tv_title);
        TextView tv_add = (TextView) findViewById(R.id.tv_add);

         tv_notice = (TextView) findViewById(R.id.tv_notice);

        tv_title.setText("Block3");
        tv_add.setText("前去ViewPager测试页面");
        tv_notice.setText("ViewPagerTestActivity");
    }

    @Override
    public void initListener() {
        tv_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(mContext,ViewPagerTestActivity.class));
            }
        });
    }

    @Override
    public void initData() {

    }
}
