package com.example.rc211.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.view.View.OnTouchListener;


import com.example.rc211.myapplication.Enemy.EnemyTypes;
import com.example.rc211.myapplication.Enemy.GenericEnemy;
import com.example.rc211.myapplication.Game.GameEventScheduler;
import com.example.rc211.myapplication.GeneralUtilities.Parametric;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.function.Function;

public class MainActivity extends Activity implements View.OnTouchListener {


    private int mStatus = 100;

    private Handler mHandler;
    private GameEventScheduler gamehandler;

    private GameView gameView;

    private int _xDelta;
    private int _yDelta;
    private ProgressBar progressBar;
    private int progressStatus = 0;
    private ImageView ImageView;
    private Handler handler = new Handler();

    public static ArrayList<ArrayList<GenericEnemy>> GruntEnemyEnemyWavesList;
    public static ArrayList<Parametric> paths;

    private static int screenWidth, screenHeight;

    public MainActivity() {
        mHandler = new Handler();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //store screen width and height
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;


        //making the surfaceView the place to draw
        gameView = new GameView(this);
//        gameView = findViewById(R.id.gameView);
        gameView.setOnTouchListener(this);

        gamehandler = new GameEventScheduler(gameView, this); //gamehandler will schedule enemy spawns (and other regular events)
        GruntEnemyEnemyWavesList = gamehandler.getGenericEnemyEnemiesList(); //assigns reference of the enemies list from the gameHandler to this object
        paths = new ArrayList<>();

        ImageView t1 = (ImageView) findViewById(R.id.t1);
        t1.setOnTouchListener(new ChoiceTouchListener());
        ImageView t2 = (ImageView) findViewById(R.id.t2);
        t2.setOnTouchListener(new ChoiceTouchListener());
        ImageView t3 = (ImageView) findViewById(R.id.t3);
        t3.setOnTouchListener(new ChoiceTouchListener());
        ImageView t4 = (ImageView) findViewById(R.id.t4);
        t4.setOnTouchListener(new ChoiceTouchListener());



        Function<Float, Float> xFunc = new Function<Float, Float>() {
            @Override
            public Float apply(Float dT) {
                return dT / 10 * (float) Math.PI / 2;
            }
        };
        Function<Float, Float> yFunc = new Function<Float, Float>() {
            @Override
            public Float apply(Float dT) {
                return (float) Math.sin(dT / 1000 * Math.PI / 2) * screenHeight / 5;
            }
        };
        Parametric enemyParametric = new Parametric(xFunc, yFunc, 0, screenHeight / 2f, screenWidth);
        paths.add(enemyParametric);
        gamehandler.scheduleAndRunEnemySpawn(20,1500, EnemyTypes.GRUNT,
                screenHeight / 4, screenHeight / 4, enemyParametric);


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

    public static class GameView extends SurfaceView implements Runnable {

        private Thread gvThread = null;
        private SurfaceHolder holder;
        private boolean isItOKToDraw = false;

        private static final Paint linePaint = new Paint();

        private GameView gameView;

        public GameView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            holder = super.getHolder();
            System.out.print("");
            gameView = this;

            linePaint.setColor(Color.WHITE);

            holder.addCallback(new SurfaceHolder.Callback() {
                @Override
                public void surfaceCreated(SurfaceHolder holder) {
                    isItOKToDraw = true;
                    gvThread = new Thread(gameView);
                    gvThread.start();
                }

                @Override
                public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

                }

                @Override
                public void surfaceDestroyed(SurfaceHolder holder) {

                }
            });
        }

        public GameView(Context context, AttributeSet attrs) {
            super(context, attrs);
            holder = super.getHolder();
            System.out.print("");
            gameView = this;

            linePaint.setColor(Color.WHITE);

            holder.addCallback(new SurfaceHolder.Callback() {
                @Override
                public void surfaceCreated(SurfaceHolder holder) {
                    isItOKToDraw = true;
                    gvThread = new Thread(gameView);
                    gvThread.start();
                }

                @Override
                public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

                }

                @Override
                public void surfaceDestroyed(SurfaceHolder holder) {

                }
            });
        }

        public GameView(final Context context) {
            super(context);
            holder = super.getHolder();
            System.out.print("");
            gameView = this;

            linePaint.setColor(Color.WHITE);


            holder.addCallback(new SurfaceHolder.Callback() {
                @Override
                public void surfaceCreated(SurfaceHolder holder) {
                    isItOKToDraw = true;
                    gvThread = new Thread(gameView);
                    gvThread.start();
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

                    for(int i = 0; i < paths.size() - 1; i++) {
                        canvas.drawLines(paths.get(i).getPath(), linePaint);
                    }
                    System.out.println("draw enemy");   /////////////////////////////////
                    for(int i = 0; i < GruntEnemyEnemyWavesList.get(GruntEnemyEnemyWavesList.size()-1).size() - 1; i++)
                        GruntEnemyEnemyWavesList.get(GruntEnemyEnemyWavesList.size()-1).get(i).moveEnemyBody(canvas, EnemyTypes.GRUNT); //list guaranteed to be GenericEnemy enemies

                    holder.unlockCanvasAndPost(canvas);
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
