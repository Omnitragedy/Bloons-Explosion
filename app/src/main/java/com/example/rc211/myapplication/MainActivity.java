package com.example.rc211.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.View.OnTouchListener;




import com.example.rc211.myapplication.Game.GameEventScheduler;

public class MainActivity extends Activity implements View.OnTouchListener {

    private int mStatus = 100;

    private Handler mHandler;
    private GameEventScheduler gamehandler;

    private GameView gameView;

    private ImageView img;
    private int _xDelta;
    private int _yDelta;
    private ProgressBar progressBar;
    private MyProgressBar pb;
    private int progressStatus = 0;
    private ImageView ImageView;
    private Handler handler = new Handler();

    public MainActivity() {
        mHandler = new Handler();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

///////////////////////////////////////////////////////////////////////////start here


        //making the surfaceView the place to draw
        gameView = new GameView(this);
        gameView.setOnTouchListener(this);
        setContentView(R.layout.activity_main);

        gamehandler = new GameEventScheduler(); //gamehandler will schedule enemy spawns (and other regular events)


        img = (ImageView) findViewById(R.id.imageView);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(150, 150);
//        img.setLayoutParams(layoutParams);
        img.setOnTouchListener(new ChoiceTouchListener());




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

        Thread gvThread = null;
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


    private final class ChoiceTouchListener implements OnTouchListener {
        public boolean onTouch(View view, MotionEvent event){
            final int X = (int) event.getRawX();
            final int Y = (int) event.getRawY();
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN:
                    android.support.constraint.ConstraintLayout.LayoutParams lParams = (android.support.constraint.ConstraintLayout.LayoutParams) (view.getLayoutParams());
                    _xDelta = X - lParams.leftMargin;
                    _yDelta = Y - lParams.topMargin;
                    break;
                case MotionEvent.ACTION_UP:
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    break;
                case MotionEvent.ACTION_MOVE:
                    android.support.constraint.ConstraintLayout.LayoutParams layoutParams = (android.support.constraint.ConstraintLayout.LayoutParams) (view.getLayoutParams());
                    layoutParams.leftMargin = X - _xDelta;
                    layoutParams.topMargin = Y - _yDelta;
                    layoutParams.rightMargin = -250;
                    layoutParams.bottomMargin = -250;
                    view.setLayoutParams(layoutParams);
                    break;
            }
            return true;
        }
    }


}
