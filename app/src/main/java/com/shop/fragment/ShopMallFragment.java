package com.shop.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;

import shop.com.appshopdemo.R;


public class ShopMallFragment extends BaseFragment {


    private TextView mFragmentTv;
    private ProgressDialog mProgressDialog;

    public static ShopMallFragment newInstance(String param1) {
        ShopMallFragment fragment = new ShopMallFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public int FragmentLayoutId() {
        return R.layout.fragment_test;
    }

    @Override
    public void InitViewAndEvents() {
        mFragmentTv = (TextView) getView().findViewById(R.id.id_fragment_tv);
    }

    @Override
    public void onFirstObtainData() {
            //初次加载数据
            if(isFirstInit){
                showLoadingProgressDialog(mParam1,2000);
                mFragmentTv.setText(mParam1);
                onButtonPressed(mParam1);
            }

    }

    @Override
    public void onShowVisible() {

        mFragmentTv.setText(mParam1);
        onButtonPressed(mParam1);
    }
}
