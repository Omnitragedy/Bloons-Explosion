package com.example.rc211.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.rc211.myapplication.Game.GameEventScheduler;

import java.security.spec.ECField;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private ProgressBar mProgressBar;
    private TextView mLoadingText;

    private int mStatus = 100;

    private Handler mHandler;
    private GameEventScheduler gamehandler;

    private GameView gameView;

    public MainActivity() {
        mHandler = new Handler();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new GameView(this);
        gameView.setOnTouchListener(this);
        setContentView(gameView);

        gamehandler = new GameEventScheduler();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mStatus < 101) {
                    mStatus--;
                    android.os.SystemClock.sleep(50);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar.setProgress(mStatus);
                        }
                    });
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mLoadingText.setVisibility(View.VISIBLE);
                    }
                });
            }
        }).start();


    }

    @Override
    public void onPause() {
        super.onPause();
        gameView.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        gameView.resume();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        System.out.println('s');
        return true;
    }

    public class GameView extends SurfaceView implements Runnable {

        Thread gvThread;
        SurfaceHolder holder;
        boolean isItOKToDraw = false;

        public GameView(Context context) {
            super(context);
            holder = super.getHolder();
        }



        @Override
        public void run() {
            while(isItOKToDraw) {
                //perform canvas draw

                if(!holder.getSurface().isValid()) {    //if the holder surface is invalid, recheck to see if still ok to draw
                    continue;
                }

                Canvas canvas = holder.lockCanvas();
                canvas.drawARGB(255, 91,192,222);
                holder.unlockCanvasAndPost(canvas);
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
}
