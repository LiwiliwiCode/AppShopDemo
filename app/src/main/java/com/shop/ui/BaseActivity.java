package com.shop.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

/**
 * Created by hhmsw on 2016/6/1.
 */
public abstract class BaseActivity extends FragmentActivity  {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LayoutId());

        InitViews();
        InitEvents();

    }

    protected abstract int LayoutId();

    protected abstract  void InitViews();

    protected abstract void InitEvents();

    protected void showToast(String msg){
        Toast.makeText(BaseActivity.this,msg,Toast.LENGTH_SHORT).show();
    }
}
