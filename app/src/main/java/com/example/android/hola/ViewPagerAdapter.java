package com.example.android.hola;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by El3ashry on 2/17/2018.
 */

public class ViewPagerAdapter extends PagerAdapter {

   private Context context;
   private LayoutInflater layoutInflater;
   private Integer[] images = {R.drawable.hola1,R.drawable.hola2,R.drawable.hola3,R.drawable.hola4,R.drawable.hola5,R.drawable.hola6,R.drawable.hola7,R.drawable.hola8};

    public ViewPagerAdapter(Context context) {

        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout , null);
        ImageView img = (ImageView) view.findViewById(R.id.img);
        img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        img.setImageResource(images[position]);
        ViewPager vp = (ViewPager)container;
        vp.addView(view , 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager vp = (ViewPager)container;
        View view = (View) object;
        vp.removeView(view);
    }
}
