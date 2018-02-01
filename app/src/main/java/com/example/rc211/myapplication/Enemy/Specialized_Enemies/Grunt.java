package com.example.rc211.myapplication.Enemy.Specialized_Enemies;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.rc211.myapplication.Enemy.GenericEnemy;
import com.example.rc211.myapplication.GeneralUtilities.Parametric;
import com.example.rc211.myapplication.MainActivity;
import com.example.rc211.myapplication.R;

/**
 * Created by rc211 on 1/24/2018.
 */

public class Grunt extends GenericEnemy{



    public Grunt(MainActivity.GameView gameView, Context context, int x, int y, int width, int height, Parametric pathFunc) {
        super(gameView, context, x, y, width, height, pathFunc);
    }

    @Override
    public void setEnemyBody() {

    }

    @Override
    public Bitmap getBitmapSprite() {
        return BitmapFactory.decodeResource(Resources.getSystem(), R.mipmap.blue_bloon);    //mipmap may make error
    }
}
