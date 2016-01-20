package com.canyinghao.canblock;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

/**
 * Created by yangjian on 15/12/21.
 */

public interface CanBlockLife {

    void onDestroy();

    void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState);

    void onRestoreInstanceState(Bundle savedInstanceState);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onRestart();

    void onNewIntent(Intent intent);

    void onActivityResult(int requestCode, int resultCode, Intent data);
}