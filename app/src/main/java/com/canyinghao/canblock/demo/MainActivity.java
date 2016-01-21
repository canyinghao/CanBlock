package com.canyinghao.canblock.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.canyinghao.canblock.CanBlockActivity;

/**
 * Created by yangjian on 15/12/21.
 */
public class MainActivity extends CanBlockActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        LinearLayout ll_main = (LinearLayout) findViewById(R.id.ll_main);

        LinearLayout ll_block = (LinearLayout) findViewById(R.id.ll_block1);
        View block2 = findViewById(R.id.block2);

        getCanBlockManager().set(new Block1(), ll_block).replace(new Block2(), block2).add(new Block3(), ll_main);




    }


}
