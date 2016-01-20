package com.canyinghao.canblock;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangjian on 15/12/21.
 */
public class CanBlockManager implements  CanBlockLife {
    private List<CanBlock> mList;


    public CanBlockManager() {

         this.mList = new ArrayList<>();
    }

    public List<CanBlock> getList() {
        return mList;
    }

    @Override
    public void onDestroy() {

        for (CanBlock block:mList) {
            block.onDestroy();
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {

        for (CanBlock block:mList) {
            block.onSaveInstanceState(outState, outPersistentState);
        }
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        for (CanBlock block:mList) {
            block.onRestoreInstanceState(savedInstanceState);
        }
    }

    @Override
    public void onStart() {

        for (CanBlock block:mList) {
            block.onStart();
        }
    }

    @Override
    public void onResume() {
        for (CanBlock block:mList) {
            block.onResume();
        }
    }

    @Override
    public void onPause() {
        for (CanBlock block:mList) {
            block.onPause();
        }
    }

    @Override
    public void onStop() {
        for (CanBlock block:mList) {
            block.onStop();
        }
    }

    @Override
    public void onRestart() {
        for (CanBlock block:mList) {
            block.onRestart();
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        for (CanBlock block:mList) {
            block.onNewIntent(intent);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        for (CanBlock block:mList) {
            block.onActivityResult(requestCode, resultCode, data);
        }
    }

    public boolean onBackPressed() {
        for (CanBlock block : mList) {
            if (block.onBackPressed()) {
                return true;
            }
        }
        return false;
    }


    public  CanBlockManager set(@NonNull CanBlock block,View v) {
        block.setToView(v);
        mList.add(block);
        return this;
    }

    public  CanBlockManager add(@NonNull CanBlock block,ViewGroup vg) {
        block.addToActivity(vg);
        mList.add(block);
        return this;
    }

    public  CanBlockManager replace(@NonNull CanBlock block,View v) {
        block.replaceToActivity(v);
        mList.add(block);
        return this;
    }

    public CanBlockManager remove(@NonNull CanBlock block) {
        block.onDestroy();
        if (mList.contains(block)) {
            mList.remove(block);
        }
        return this;
    }


    public  CanBlockManager addPager(@NonNull CanBlock block,Context context) {
        block.init(context);
        mList.add(block);
        return this;
    }


}
