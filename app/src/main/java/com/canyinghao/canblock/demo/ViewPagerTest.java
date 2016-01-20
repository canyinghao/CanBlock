package com.canyinghao.canblock.demo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.canyinghao.canblock.CanBlockActivity;
import com.canyinghao.canblock.CanBlockManager;
import com.canyinghao.canblock.CanBlockPagerAdapter;

/**
 * Created by yangjian on 15/12/21.
 */
public class ViewPagerTest extends CanBlockActivity {
    CanRecyclerViewPager  viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_viewpager);

          viewPager = (CanRecyclerViewPager) findViewById(R.id.viewpager);


        LinearLayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,
                false);
        viewPager.setLayoutManager(layout);





        CanBlockManager manager =    getCanBlockManager().addPager(new Block1(),this).addPager(new Block2(),this).addPager(new Block1(),this);

        CanBlockPagerAdapter adapter = new CanBlockPagerAdapter(viewPager,manager.getList());


        viewPager.setAdapter(adapter);

        viewPager.setHasFixedSize(true);
        viewPager.setLongClickable(true);
        viewPager.setOnePage(true);


    }



}
