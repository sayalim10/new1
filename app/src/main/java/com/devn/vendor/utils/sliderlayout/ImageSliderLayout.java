package com.devn.vendor.utils.sliderlayout;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.devn.vendor.R;

import java.util.HashMap;

/**
 * Created by Nitin Kalokhe on 11/13/2016
 * for AMI Pvt Ltd.
 * you can contact me at : nitin3kalokhe@gmail.com
 * * Copyright (c) 2016 AMI Pvt Ltd. All rights reserved.
 */
public class ImageSliderLayout implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    public interface IOnImageSliderClick {
        public void onSliderClick(String tag, int id);
    }


    private Context mContext;
    private View mView;
    private SliderLayout mSlider;
    private IOnImageSliderClick mCallback;

    public ImageSliderLayout(Context context, View rootView, IOnImageSliderClick callback) {
        this.mContext = context;
        this.mView = rootView;
        this.mCallback = callback;
    }

    public void slide() {

        mSlider = (SliderLayout) mView.findViewById(R.id.id_home_screen_sliderlayout);
        HashMap<String, String> url_maps = new HashMap<String, String>();
        url_maps.put("Special Dal Makhani", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Special Panjabi Thali", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("Special Kulcha", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Special Combo", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Special Dal Makhani", R.mipmap.mess_thali);
        file_maps.put("Special Panjabi Thali", R.mipmap.mess_thali);
        file_maps.put("Special Kulcha", R.mipmap.mess_thali);
        file_maps.put("Special Combo", R.mipmap.mess_thali);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(mContext);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);
            textSliderView.getBundle()
                    .putInt("extra_id", file_maps.get(name));

            mSlider.addSlider(textSliderView);
        }
        mSlider.setPresetTransformer(SliderLayout.Transformer.Background2Foreground);
        mSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mSlider.setCustomAnimation(new DescriptionAnimation());
        mSlider.setDuration(4000);
        mSlider.addOnPageChangeListener(this);
    }

    public void onStop() {
        mSlider.stopAutoCycle();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        if (this.mCallback != null)
            this.mCallback.onSliderClick(slider.getBundle().getString("extra"), slider.getBundle().getInt("extra_id"));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
