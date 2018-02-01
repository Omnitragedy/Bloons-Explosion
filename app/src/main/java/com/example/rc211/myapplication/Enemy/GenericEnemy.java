package com.example.rc211.myapplication.Enemy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.widget.ProgressBar;

import com.example.rc211.myapplication.GeneralUtilities.Parametric;
import com.example.rc211.myapplication.MainActivity;
import com.example.rc211.myapplication.Sprite.Sprite;

/**
 * Created by Saurav on 1/23/2018.
 */

public abstract class GenericEnemy {

    private MainActivity.GameView gameView;

    private ProgressBar enemyProgressBar;

    private int initX, initY;
    private int width, height;

    private Sprite enemySprite;

    private Parametric pathFunc;

    private long initT;
    private long dT;

    public GenericEnemy(MainActivity.GameView gameView, Context context, int x, int y, int width, int height, Parametric pathFunc) {
        initX = x;
        initY = y;
        this.width = width;
        this.height = height;

        this.pathFunc = pathFunc;
        initT = System.currentTimeMillis();

        enemySprite = new Sprite(gameView, getBitmapSprite(), x, y, width, height);


        enemyProgressBar = new ProgressBar(context);
    }


    /**
     * Change position of progress bar and enemy sprite based on new determined position
     * @param newX
     * @param newY
     */
    private void update(float newX, float newY) {
        //change progress bar location code

        //change progress bar value code




        //change enemy location code
        Canvas c = gameView.getHolder().lockCanvas();
        c.drawBitmap(this.getBitmapSprite(), newX, newY, null);
        gameView.getHolder().unlockCanvasAndPost(c);
    }

    /**
     * Updates the theoretical location of the enemy and calls the update method for the enemy
     */
    public void moveEnemyBody() {
        this.dT = System.currentTimeMillis() - initT;


        //call last
        update(initX + pathFunc.getX(this.dT), initY + pathFunc.getY(this.dT));
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
