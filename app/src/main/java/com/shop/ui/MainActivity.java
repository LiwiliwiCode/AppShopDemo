package com.shop.ui;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.shop.fragment.BaseFragment;
import com.shop.fragment.TestFragment;

import shop.com.appshopdemo.R;

public class MainActivity extends BaseActivity implements View.OnClickListener ,BaseFragment.OnFragmentInteractionListener {

    private static final String TAG = "MainActivity";

    private TextView mShopMallTv;
    private TextView mShopCartTv;
    private TextView mUserTv;

    private Fragment mTestFragment1;
    private Fragment mTestFragment2;
    private Fragment mTestFragment3;

    @Override
    protected int LayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void InitViews() {
        mShopMallTv = (TextView) findViewById(R.id.id_main_shopmall_tab_tv);
        mShopCartTv = (TextView) findViewById(R.id.id_main_shopcart_tab_tv);
        mUserTv = (TextView) findViewById(R.id.id_main_user_tab_tv);

        mTestFragment1 = TestFragment.newInstance(getString(R.string.str_main_shopmall_tab_name));
        getSupportFragmentManager().beginTransaction().replace(R.id.id_main_content,mTestFragment1).commit();
    }

    @Override
    protected void InitEvents() {
        mShopMallTv.setOnClickListener(this);
        mShopCartTv.setOnClickListener(this);
        mUserTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        switch (v.getId())
        {
            case  R.id.id_main_shopmall_tab_tv:
                if(mTestFragment1 == null)
                mTestFragment1 = TestFragment.newInstance(getString(R.string.str_main_shopmall_tab_name));
                getSupportFragmentManager().beginTransaction().replace(R.id.id_main_content,mTestFragment1).commit();
                break;
            case  R.id.id_main_shopcart_tab_tv:
                if(mTestFragment2 == null)
                mTestFragment2 = TestFragment.newInstance(getString(R.string.str_main_shopcart_tab_name));
                getSupportFragmentManager().beginTransaction().replace(R.id.id_main_content,mTestFragment2).commit();
                break;
            case  R.id.id_main_user_tab_tv:
                if(mTestFragment3 == null)
                mTestFragment3 = TestFragment.newInstance(getString(R.string.str_main_user_tab_name));
                getSupportFragmentManager().beginTransaction().replace(R.id.id_main_content,mTestFragment3).commit();
                break;

        }

    }

    @Override
    public void onFragmentInteraction(String msg) {
        Log.d(TAG, "onFragmentInteraction:msg =  "+msg);
    }
}
