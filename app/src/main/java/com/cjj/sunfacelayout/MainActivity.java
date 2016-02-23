package com.cjj.sunfacelayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cjj.view.SunLayout;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SunLayout sunLayout = (SunLayout) findViewById(R.id.sun);
        sunLayout.setSunRadius(50);
        sunLayout.setSunColor(Color.RED);
        sunLayout.setEyesSize(5);
        sunLayout.setLineColor(Color.RED);
        sunLayout.setLineHeight(10);
        sunLayout.setLineLevel(20);


        final PtrFrameLayout frame = (PtrFrameLayout) findViewById(R.id.material_style_ptr_frame);

        // header
//        final RentalsSunHeaderView header = new RentalsSunHeaderView(getContext());
//        header.setLayoutParams(new PtrFrameLayout.LayoutParams(-1, -2));
//        header.setPadding(0, LocalDisplay.dp2px(15), 0, LocalDisplay.dp2px(10));
//        header.setUp(frame);

        SunHeaderView headers = new SunHeaderView(this);

        frame.setLoadingMinTime(1000);
        frame.setDurationToCloseHeader(1500);
        frame.setHeaderView(headers);
        frame.addPtrUIHandler(headers);
        // frame.setPullToRefresh(true);
        frame.postDelayed(new Runnable() {
            @Override
            public void run() {
                frame.autoRefresh(true);
            }
        }, 100);

        frame.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return true;
            }

            @Override
            public void onRefreshBegin(final PtrFrameLayout frame) {
                long delay = 2500;
                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        frame.refreshComplete();
                    }
                }, delay);
            }
        });


    }
}
