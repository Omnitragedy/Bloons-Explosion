package com.example.rc211.myapplication.Game;

import android.content.Context;

import com.example.rc211.myapplication.Enemy.EnemyTypes;
import com.example.rc211.myapplication.Enemy.GenericEnemy;
import com.example.rc211.myapplication.GeneralUtilities.Parametric;
import com.example.rc211.myapplication.MainActivity;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Saurav on 1/22/2018.
 */

public class GameEventScheduler {

    private static final int REFRESH_RATE_IN_MILLIS = 33;

    private ArrayList<ArrayList<GenericEnemy>> enemyWavesList;

    private static int tempEnemiesCount;        //used to simply store how many enemies have been spawned in a single
                                                //call of the scheduleAndRunEnemySpawn method

    private MainActivity.GameView gameView;
    private Context context;

    public GameEventScheduler(MainActivity.GameView gameView, Context context) {
        enemyWavesList = new ArrayList<>();

        this.gameView = gameView;
        this.context = context;

        tempEnemiesCount = 0;

    }



    /**
     * Set how many enemies to spawn and the time interval between each of them
     * @param numOfEnemies number of enemies to spawn
     * @param intervalBetweenSpawn interval in ms
     */
    public void scheduleAndRunEnemySpawn(final int numOfEnemies, int intervalBetweenSpawn, final EnemyTypes enemytype,
                                         final int width, final int height, final Parametric parametric) {

        enemyWavesList.add(new ArrayList<GenericEnemy>());

        final Timer spawnTimer = new Timer();
        spawnTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                tempEnemiesCount++;
                if (tempEnemiesCount > numOfEnemies) {
                    tempEnemiesCount = 0;
                    spawnTimer.cancel();
                }


                //attempt to add enemy of requested type
                GenericEnemy enemyToAdd = new GenericEnemy(gameView, context, (int) parametric.initX, (int) parametric.initY, width, height, parametric, enemytype);

                //add new enemy
                enemyWavesList.get(enemyWavesList.size() - 1).add(enemyToAdd);


            }
        }, 0, intervalBetweenSpawn); //second - delay; third - time between each execution
    }

    /**
     * Returns the list of enemies that have spawned
     * @return enemies list
     */
    public ArrayList<ArrayList<GenericEnemy>> getGenericEnemyEnemiesList() {
        return enemyWavesList;
    }
}
