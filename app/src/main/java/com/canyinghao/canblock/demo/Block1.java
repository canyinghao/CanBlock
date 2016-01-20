package com.canyinghao.canblock.demo;

import android.widget.TextView;

import com.canyinghao.canblock.CanBlock;

/**
 * Created by yangjian on 15/12/21.
 */
public class Block1 extends CanBlock {




    @Override
    public void initView() {
        setContentView(R.layout.block_1);


      TextView tv = (TextView) findViewById(R.id.tv_block);

        tv.setText("Block1");

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }
}
