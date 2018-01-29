package com.example.rc211.myapplication.Tower;

import com.example.rc211.myapplication.Game.Bullet;

/**
 * Created by rc211 on 1/23/2018.
 */

public abstract class Tower {

    public static Bullet bullet;
    public static int cost;
    public static int type;

    public Tower(Bullet bullet, int cost, int type){

        this.cost = cost;
        this.type = type;
    }



}
