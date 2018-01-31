package com.example.rc211.myapplication.Enemy;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ProgressBar;

import com.example.rc211.myapplication.MainActivity;
import com.example.rc211.myapplication.Sprite.Sprite;

/**
 * Created by Saurav on 1/23/2018.
 */

public abstract class GenericEnemy {

    private ProgressBar enemyProgressBar;

    private int x, y;
    private int width, height;

    private Sprite enemySprite;

    public GenericEnemy(MainActivity.GameView gameView, Context context, int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;


        enemySprite = new Sprite(gameView, getBitmapSprite(), x, y, width, height);


        enemyProgressBar = new ProgressBar(context);
    }


    /**
     * Change position of progress bar and enemy sprite based on new determined position
     * @param newX
     * @param newY
     */
    public void update(int newX, int newY) {
        //change progress bar location code

        //change progress bar value code




        //change enemy location code


    }

    /**
     * How the enemy's sprite should be determined
     */
    public abstract void setEnemyBody();

    /**
     * Return the data for enemy's sprite
     * @return enemy sprite
     */
    public abstract Bitmap getBitmapSprite();
}
