package com.example.rc211.myapplication.Sprite;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.rc211.myapplication.MainActivity;

/**
 * Created by Saurav on 1/30/2018.
 */

public class Sprite {

    private int x, y;
    private int height, width;
    private Bitmap b;
    private MainActivity.GameView gameView;

    public Sprite(MainActivity.GameView gameView, Bitmap body, int x, int y, int width, int height) {
        b = body;
        this.gameView = gameView;
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    public void update(Canvas canvas, int newX, int newY) {


        x = newX;
        y = newY;

        Rect dst = new Rect(x, y, x + width, y + height);

        canvas.drawBitmap(b, null, dst, null);
    }

}
