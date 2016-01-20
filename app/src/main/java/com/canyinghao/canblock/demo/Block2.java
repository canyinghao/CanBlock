package com.canyinghao.canblock.demo;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.canyinghao.canblock.CanBlock;

/**
 * Created by yangjian on 15/12/21.
 */
public class Block2 extends CanBlock {
    @Override
    public void initView() {
        setContentView(R.layout.block_1);
        TextView tv = (TextView) findViewById(R.id.tv_block);

        tv.setText("Block2");
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().startActivityForResult(new Intent(getActivity(),MainActivity.class),0);
            }
        });
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }
}
