package com.example.rc211.myapplication.Game;

/**
 * Created by rc211 on 1/23/2018.
 */

public class Bullet {

    private final double angle;

    private double xStep, yStep;

    private float x, y;

    public Bullet (double angle, int x, int y){
        this.angle = angle;

        xStep = 500*Math.cos(angle);
        yStep = 500*Math.sin(angle);

        this.x = x;
        this.y = y;
    }

    public void update(float dT) {
        x += xStep * dT;
        y += yStep * dT;
    }





}
