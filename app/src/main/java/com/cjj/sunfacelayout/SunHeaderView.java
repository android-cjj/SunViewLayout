package com.cjj.sunfacelayout;

import android.content.Context;

import com.cjj.view.SunLayout;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

/**
 * Created by cjj on 2016/2/22.
 */
public class SunHeaderView extends SunLayout implements PtrUIHandler{

    public SunHeaderView(Context context) {
        super(context);
    }

    @Override
    public void onUIReset(PtrFrameLayout frame) {

    }

    @Override
    public void onUIRefreshPrepare(PtrFrameLayout frame) {

    }

    @Override
    public void onUIRefreshBegin(PtrFrameLayout frame) {

    }

    @Override
    public void onUIRefreshComplete(PtrFrameLayout frame) {
        cancelSunLineAnim();
    }

    @Override
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {
        if (ptrIndicator.getCurrentPercent()>=1)
        {
            mLineView.setVisibility(VISIBLE);
            mLineView.setAlpha(ptrIndicator.getCurrentPercent());
        }else {
            mLineView.setVisibility(INVISIBLE);
        }
        mSunView.setPerView(DEFAULT_SUN_RADIUS,ptrIndicator.getCurrentPercent());

        startSunLineAnim(mLineView);

    }
}
