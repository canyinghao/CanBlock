package com.canyinghao.canblock.demo;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.canyinghao.canblock.CanBlock;

/**
 * Created by yangjian on 15/12/21.
 */
public class Block2 extends CanBlock {

    TextView tv_notice;
    CutImgHelper cutImgHelper;

    @Override
    public void initView() {

        setContentView(R.layout.block);

        LinearLayout ll_block = (LinearLayout) findViewById(R.id.ll_block);

        TextView tv_title = (TextView) findViewById(R.id.tv_title);


        TextView tv_add = (TextView) findViewById(R.id.tv_add);

        tv_notice = (TextView) findViewById(R.id.tv_notice);

        tv_title.setText("Block2");
        tv_add.setText("去剪切图片");
        tv_notice.setText("点击出现dialog");

        cutImgHelper = new CutImgHelper();

        getCanBlockActivity().getCanBlockManager().add(cutImgHelper, ll_block);

    }

    @Override
    public void initListener() {

        tv_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cutImgHelper.showOptionsDialog(true);
            }
        });
    }

    @Override
    public void initData() {

    }
}
