package com.example.rc211.myapplication.Enemy;

import android.graphics.Bitmap;

import com.example.rc211.myapplication.Enemy.EnemyUIElements.EnemyBody;
import com.example.rc211.myapplication.Enemy.EnemyUIElements.EnemyProgressBar;

/**
 * Created by Saurav on 1/23/2018.
 */

public abstract class GenericEnemy {

    private EnemyProgressBar enemyProgressBar;
    private EnemyBody enemyBody;

    private int x, y;

    public GenericEnemy(int x, int y) {
        this.x = x;
        this.y = y;
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
