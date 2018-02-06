package com.example.rc211.myapplication.Tower;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.example.rc211.myapplication.Game.Bullet;

/**
 * Created by rc211 on 1/23/2018.
 */

public class Tower extends ImageView {

    public static Bullet bullet;
    public static int cost;
    public static int range = 300;
    public static int rangeSquared = range * range;

    private boolean isShooting = false;

    public void setCost(int cost) {this.cost = cost;}

    public Tower(Context context){
        super(context);

        this.cost = cost;
    }

    public Tower(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        this.cost = cost;
    }

    public Tower(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int cost) {
        super(context, attrs, defStyleAttr);

        this.cost = cost;
    }

    public Tower(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes, int cost) {
        super(context, attrs, defStyleAttr, defStyleRes);

        this.cost = cost;
    }

    public void setStartShooting() {
        isShooting = true;
    }

    public void setStopShooting() {
        isShooting = false;
    }
}
