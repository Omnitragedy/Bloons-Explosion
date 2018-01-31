package com.example.rc211.myapplication.Enemy;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ProgressBar;

import com.example.rc211.myapplication.Enemy.EnemyUIElements.EnemyBody;
import com.example.rc211.myapplication.Enemy.EnemyUIElements.EnemyProgressBar;
import com.example.rc211.myapplication.MainActivity;

/**
 * Created by Saurav on 1/23/2018.
 */

public abstract class GenericEnemy {

    private ProgressBar enemyProgressBar;
    private EnemyBody enemyBody;

    private int x, y;

    public GenericEnemy(Context context, int x, int y) {
        this.x = x;
        this.y = y;

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
     * Return the data for everything that needs to be drawn for an enemy on the screen
     * @return enemy sprite
     */
    public Bitmap getBitmapSprite() {
        return enemyBody.getBitmapSprite();
    }
}
