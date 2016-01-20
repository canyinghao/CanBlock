package com.canyinghao.canblock;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by yangjian on 15/12/21.
 */
public class CanBlockActivity extends AppCompatActivity {

    private CanBlockManager mCanBlockManager;


    public CanBlockManager getCanBlockManager() {
        if (mCanBlockManager == null) {
            mCanBlockManager = new CanBlockManager();
        }
        return mCanBlockManager;
    }

    
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        if (mCanBlockManager != null) {
            mCanBlockManager.onSaveInstanceState(outState, outPersistentState);
        }
    }

   
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (mCanBlockManager != null) {
            mCanBlockManager.onRestoreInstanceState(savedInstanceState);
        }
    }

   
    @Override
    public void onStart() {
        super.onStart();
        if (mCanBlockManager != null) {
            mCanBlockManager.onStart();
        }
    }

   
    @Override
    protected void onResume() {
        super.onResume();
        if (mCanBlockManager != null) {
            mCanBlockManager.onResume();
        }
    }

   
    @Override
    public void onPause() {
        super.onPause();
        if (mCanBlockManager != null) {
            mCanBlockManager.onPause();
        }
    }

   
    @Override
    protected void onStop() {
        super.onStop();
        if (mCanBlockManager != null) {
            mCanBlockManager.onStop();
        }
    }

   
    @Override
    protected void onRestart() {
        super.onRestart();
        if (mCanBlockManager != null) {
            mCanBlockManager.onRestart();
        }
    }

   
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCanBlockManager != null) {
            mCanBlockManager.onDestroy();
        }
    }

   
    @Override
    public void onBackPressed() {
        if (mCanBlockManager != null) {
            if (!mCanBlockManager.onBackPressed()) {
                super.onBackPressed();
            }
        }
    }

   
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mCanBlockManager != null) {
            mCanBlockManager.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (mCanBlockManager != null) {
            mCanBlockManager.onNewIntent(intent);
        }
    }
}
