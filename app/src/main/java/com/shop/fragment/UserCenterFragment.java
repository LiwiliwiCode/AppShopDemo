package com.shop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import shop.com.appshopdemo.R;

/**
 * Created by hhmsw on 2016/6/2.
 */
public class UserCenterFragment extends  BaseFragment {

    private static final String ARG_PARAM1 = "param1";

    private TextView mFragmentTv;

    public static UserCenterFragment newInstance(String param1){
        UserCenterFragment fragment = new UserCenterFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM1,param1);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null){
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
