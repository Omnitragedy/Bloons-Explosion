package com.example.rc211.myapplication.Enemy.EnemyUIElements;

import android.graphics.Bitmap;

/**
 * Created by Saurav on 1/24/2018.
 */

public class EnemyBody {

    private Bitmap body;

    public EnemyBody(Bitmap body) {
        this.body = body;
    }

    public Bitmap getBitmapSprite() {
        return body;
    }
}
