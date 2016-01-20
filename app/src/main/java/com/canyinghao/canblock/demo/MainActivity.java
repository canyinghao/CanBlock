package com.canyinghao.canblock.demo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

        findViewById(R.id.tv_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ViewPagerTest.class));
            }
        });


      LinearLayout  ll_block = (LinearLayout) findViewById(R.id.ll_block);
      View block =   findViewById(R.id.block1);

        getCanBlockManager().set(new Block3(),ll_block).add(new Block1(), ll_block).replace(new Block2(),block);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("onActivityResult","onActivityResult");
    }
}
