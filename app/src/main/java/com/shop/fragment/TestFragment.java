package com.shop.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import shop.com.appshopdemo.R;


public class TestFragment extends BaseFragment {

    private static final String TAG = "TestFragment";

    private TextView mFragmentTv;
    private ProgressDialog mProgressDialog;


    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mProgressDialog.dismiss();
        }
    };

    public static TestFragment newInstance(String param1) {
        TestFragment fragment = new TestFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mFragmentTv = (TextView) getView().findViewById(R.id.id_fragment_tv);
    }

    @Override
    public void onFirstObtainData() {
            //初次加载数据
            if(isFirstInit){
                mProgressDialog = ProgressDialog.show(getActivity(),null,mParam1);
                mHandler.sendEmptyMessageDelayed(0x110,2000);
                mFragmentTv.setText(mParam1);
                onButtonPressed(mParam1);
            }

    }

    @Override
    public void onShownvisible() {
        Log.d(TAG, "onHideInvisible: mParam1"+mParam1);
        mFragmentTv.setText(mParam1);
        onButtonPressed(mParam1);
    }
}
