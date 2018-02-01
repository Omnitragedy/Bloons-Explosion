package com.example.rc211.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.rc211.myapplication.Enemy.GenericEnemy;

/**
 * Created by rc211 on 2/1/2018.
 */

public class GameView extends SurfaceView implements Runnable {

    private Thread gvThread = null;
    private SurfaceHolder holder;
    private boolean isItOKToDraw = false;

    public GameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public GameView(Context context) {
        super(context);
        holder = super.getHolder();
        System.out.print("");

        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {

            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
    }


    public SurfaceHolder getHolder() {
        return super.getHolder();
    }

    @Override
    public void run() {
        while(isItOKToDraw) {
            //perform canvas draw

//                if the holder surface is invalid, recheck to see if still ok to draw
            if(holder.getSurface().isValid()) {
                System.out.println(holder.getSurface().isValid());
                Canvas canvas = holder.lockCanvas();
                canvas.drawARGB(255, 91,192,222);
                System.out.println("draw enemy");   /////////////////////////////////
                for (GenericEnemy ge : MainActivity.enemyWavesList.get(MainActivity.enemyWavesList.size()-1)) {
                    ge.moveEnemyBody();
                }
                holder.unlockCanvasAndPost(canvas);continue;
            }


        }
    }


    public void pause() {
        isItOKToDraw = false;
        while (true) {
            try {
                gvThread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
        }

        gvThread = null;
    }

    public void resume() {
        isItOKToDraw = true;
        gvThread = new Thread(this);
        gvThread.start();
    }


}