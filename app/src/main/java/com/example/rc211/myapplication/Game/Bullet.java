package com.example.rc211.myapplication.Game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.example.rc211.myapplication.MainActivity;
import com.example.rc211.myapplication.R;

/**
 * Created by rc211 on 1/23/2018.
 */

public class Bullet {

    private final double angle;

    private double xStep, yStep;

    private float x, y;


    private Bitmap bulletImg;

    private Canvas canvas;


    public Bullet (double angle, float x, float y, Context context, Canvas canvas){
        this.angle = angle;

        xStep = 500*Math.cos(angle);
        yStep = 500*Math.sin(angle);

        this.x = x;
        this.y = y;
        bulletImg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bullet);

        this.canvas = canvas;
    }

    public void update(float dT) {
        x += xStep * dT;
        y += yStep * dT;

        System.out.println("shooting");

        canvas.drawBitmap(bulletImg, x, y, null);
    }
}
