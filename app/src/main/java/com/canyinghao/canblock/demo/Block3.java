package com.canyinghao.canblock.demo;

import android.view.View;
import android.widget.TextView;

import com.canyinghao.canblock.CanBlock;

/**
 * Created by yangjian on 15/12/21.
 */
public class Block3 extends CanBlock {
    @Override
    public void initView() {

      TextView tv = (TextView) findViewById(R.id.tv);

        tv.setText("Block3");
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().setResult(0);
                getActivity().finish();
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
