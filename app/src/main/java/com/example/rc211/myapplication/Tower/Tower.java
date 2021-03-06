package com.example.rc211.myapplication.Tower;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.example.rc211.myapplication.Enemy.GenericEnemy;
import com.example.rc211.myapplication.Game.Bullet;
import com.example.rc211.myapplication.MainActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by rc211 on 1/23/2018.
 */

public class Tower extends ImageView {

    public static int cost;
    public static int range = 300;
    public static int rangeSquared = range * range;

    private int width, height;

    private float angleToShoot;

    public ArrayList<Bullet> bullets;

    private Canvas canvas;


    public Context context;

    public void setCost(int cost) {this.cost = cost;}

    public Tower(Context context){
        super(context);

        this.cost = cost;
        bullets = new ArrayList<>();

        this.context = context;
    }

    public Tower(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        this.cost = cost;
        bullets = new ArrayList<>();

        this.context = context;
    }

    public Tower(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int cost) {
        super(context, attrs, defStyleAttr);

        this.cost = cost;
        bullets = new ArrayList<>();

        this.context = context;
    }

    public Tower(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes, int cost) {
        super(context, attrs, defStyleAttr, defStyleRes);

        this.cost = cost;
        bullets = new ArrayList<>();

        this.context = context;
    }

    private void shoot(float angle) {
        bullets.add(new Bullet(angle, this.getX(), this.getY(), context, canvas));
    }

    /**
     * Update the list of enemies in the bounds of the tower
     */
    public void updateAim(Canvas canvas) {
        GenericEnemy enemyToAim = null;
        ArrayList<ArrayList<GenericEnemy>> enemyWavesList = MainActivity.GruntEnemyEnemyWavesList;

        for(int i = enemyWavesList.size() - 1; i >= 0; i--) {
            for (int j = enemyWavesList.get(i).size() - 1; j >= 0; j--) {
                if( Math.pow(enemyWavesList.get(i).get(j).X - this.getX(), 2)
                        + Math.pow(enemyWavesList.get(i).get(j).Y - this.getY(), 2) <= rangeSquared) {
                    enemyToAim = enemyWavesList.get(i).get(j);
                }
            }
        }

        if(enemyToAim != null) {
            float tempAngle = (float) Math.toDegrees(Math.atan2(enemyToAim.Y - this.getY(), enemyToAim.Y - this.getY()));
            if(tempAngle < 0)
                tempAngle += 360;

            angleToShoot = tempAngle;
        }

        angleToShoot = 90;


        shoot(angleToShoot);


        for(Bullet bullet : bullets)
            bullet.update(1.0f/30);
    }
}
