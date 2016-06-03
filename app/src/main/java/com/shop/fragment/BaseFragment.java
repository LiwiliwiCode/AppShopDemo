package com.shop.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {

    private static final String TAG = "BaseFragment";
    /**
     * Bundle传递所需要的参数
     */
    protected static final String ARG_PARAM1 = "param1";
    protected String mParam1;

    /**
     * 第一次初始化标记
     */
    protected boolean isFirstInit = true ;
    /**
     * Activity 回调接口
     */
    private OnFragmentInteractionListener mListener;

    private ProgressDialog mProgressDialog;

    private Handler mBaseHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mProgressDialog.dismiss();
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(FragmentLayoutId(),container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        InitViewAndEvents();
    }

    public BaseFragment() {
    }

    @Override
    public void onResume() {
        super.onResume();
            if(getUserVisibleHint()) {
                if (isFirstInit) {
                    //初次加载数据
                    onFirstObtainData();
                    isFirstInit = false;
                } else {
                    onShowVisible();
                }
            }
    }

    @Override
    public void onPause() {
        super.onPause();
        //TODO
    }

    protected void showLoadingProgressDialog (String msg , long time)
    {
        mProgressDialog = ProgressDialog.show(getActivity(),null,msg);
        mBaseHandler.sendEmptyMessageDelayed(0x110,time);
    }

    /**
     * Layout ID
     * @return
     */
    public abstract int FragmentLayoutId();
    /**
     * 初始化View 以及注册事件
     */
    public abstract void InitViewAndEvents();
    /**
     * 初次获取数据
     */
    public abstract void onFirstObtainData();
    /**
     * 不再获取数据默认显示初次获取的数据
     */
    public abstract void onShowVisible();

    public void onButtonPressed(String msg) {
        if (mListener != null) {
            mListener.onFragmentInteraction(msg);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String itemName);
    }
}
