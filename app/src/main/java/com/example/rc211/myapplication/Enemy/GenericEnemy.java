package com.example.rc211.myapplication.Enemy;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.widget.ProgressBar;

import com.example.rc211.myapplication.GeneralUtilities.Parametric;
import com.example.rc211.myapplication.MainActivity;
import com.example.rc211.myapplication.R;
import com.example.rc211.myapplication.Sprite.Sprite;

import java.util.HashMap;

/**
 * Created by Saurav on 1/23/2018.
 */

public class GenericEnemy {

    private MainActivity.GameView gameView;

    private ProgressBar enemyProgressBar;

    private int initX, initY;
    private int width, height;

    private Sprite enemySprite;

    private Parametric pathFunc;

    private long initT;
    private long dT;

    private EnemyTypes enemyType;

    private HashMap<EnemyTypes, Bitmap> typeToSpriteMap = new HashMap<>();

    public GenericEnemy(MainActivity.GameView gameView, Context context, int x, int y, int width, int height, Parametric pathFunc, EnemyTypes enemyType) {
        initX = x;
        initY = y;
        this.width = width;
        this.height = height;

        this.pathFunc = pathFunc;
        initT = System.currentTimeMillis();

        enemySprite = new Sprite(gameView, getBitmapSprite(enemyType), x, y, width, height);
        this.enemyType = enemyType;

        typeToSpriteMap.put(EnemyTypes.GRUNT, BitmapFactory.decodeResource(context.getResources(), R.drawable.red_bloon));



        enemyProgressBar = new ProgressBar(context);
    }


    /**
     * Change position of progress bar and enemy sprite based on new determined position
     * @param newX
     * @param newY
     */
    private void update(float newX, float newY, Canvas canvas, EnemyTypes enemyType) {
        //change progress bar location code

        //change progress bar value code




        //change enemy location code

        //assume that the canvas was locked before this method was called
//        Bitmap bp = getBitmapSprite(enemyType);
        canvas.drawBitmap(getBitmapSprite(enemyType), newX, newY, null);
//        System.out.print("");
    }

    /**
     * Updates the theoretical location of the enemy and calls the update method for the enemy
     */
    public void moveEnemyBody(Canvas canvas, EnemyTypes enemyType) {
        this.dT = System.currentTimeMillis() - initT;


        //call last
        update(initX + pathFunc.getX(this.dT), initY + pathFunc.getY(this.dT), canvas, enemyType);
    }

    /**
     * Return the data for enemy's sprite
     * @return enemy sprite
     */
    public Bitmap getBitmapSprite(EnemyTypes enemyType) {
        if(enemyType.equals(EnemyTypes.GRUNT))
            return typeToSpriteMap.get(EnemyTypes.GRUNT);

        return typeToSpriteMap.get(EnemyTypes.GRUNT);
    }
}
