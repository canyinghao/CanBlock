package com.canyinghao.canblock;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yangjian on 15/12/21.
 */
public abstract class CanBlock implements CanBlockLife {

    protected View mContentView;
    protected Context context;
    protected boolean isSet;


    public void init(Context context) {
        this.context = context;
        onCreate();


    }

    @Override
    public void onDestroy() {

        if (!isSet) {
            ViewGroup vg = (ViewGroup) mContentView.getParent();

            if (vg != null) {
                vg.removeView(mContentView);

            }
        }


        context = null;
        mContentView = null;

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onNewIntent(Intent intent) {

    }

    protected boolean onBackPressed() {
        return false;
    }

    /**
     * 在CanBlock中处理activity的某一个view
     *
     * @param v
     */
    public void setToView(View v) {
        this.isSet = true;
        this.context = v.getContext();
        this.mContentView = v;
        onCreate();

    }


    /**
     * 将一个view加到activity上
     *
     * @param vg
     */
    public void addToActivity(@NonNull ViewGroup vg) {
        this.context = vg.getContext();
        onCreate();

        vg.addView(mContentView);


    }

    /**
     * 将一个view替换activity上的一个view
     *
     * @param view
     */
    public void replaceToActivity(@NonNull View view) {
        this.context = view.getContext();
        onCreate();


        ViewGroup vg = (ViewGroup) view.getParent();

        if (vg != null) {
            ViewGroup.LayoutParams params = view.getLayoutParams();
            int index = vg.indexOfChild(view);

            vg.removeView(view);
            vg.addView(mContentView, index, params);
        }


    }

    public void onCreate() {
        initView();
        initListener();
        initData();
    }

    public abstract void initView();

    public abstract void initListener();

    public abstract void initData();

    public void setContentView(@LayoutRes int layoutResID) {
        setContentView(LayoutInflater.from(context).inflate(layoutResID, null));
    }

    public void setContentView(@NonNull View view) {
        this.mContentView = view;
    }


    public View getContentView() {
        return mContentView;
    }

    public View findViewById(int rid) {

        return mContentView.findViewById(rid);

    }


    public Activity getActivity() {

        if (context != null && context instanceof Activity) {

            return (Activity) context;

        }

        return null;
    }


}
