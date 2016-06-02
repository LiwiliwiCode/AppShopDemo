package com.shop.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

public abstract class BaseFragment extends Fragment {

    private static final String TAG = "BaseFragment";
    protected static final String ARG_PARAM1 = "param1";

    protected String mParam1;

    /**
     * 记录是否是第一次初始化
     */
    protected boolean isFirstInit = true ;

    private OnFragmentInteractionListener mListener;

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

    public abstract void onFirstObtainData();

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
