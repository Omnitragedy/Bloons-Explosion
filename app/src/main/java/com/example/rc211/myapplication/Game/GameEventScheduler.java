package com.example.rc211.myapplication.Game;

import com.example.rc211.myapplication.Enemy.EnemyTypes;
import com.example.rc211.myapplication.Enemy.GenericEnemy;

import java.util.ArrayList;
import java.util.TimerTask;

/**
 * Created by Saurav on 1/22/2018.
 */

public class GameEventScheduler {

    private ArrayList<GenericEnemy> enemies;

    public GameEventScheduler() {
        enemies = new ArrayList<>();
    }



    /**
     * Set how many enemies to spawn and the time interval between each of them
     * @param numOfEnemies
     * @param intervalBetweenSpawn
     */
    public void scheduleAndRunEnemySpawn(int numOfEnemies, float intervalBetweenSpawn, EnemyTypes enemytype) {
        TimerTask addEnemyTask = new TimerTask() {
            @Override
            public void run() {
                enemies.add(new GenericEnemy());
            }
        };
    }


    /**
     * Returns the list of enemies that have spawned
     * @return enemies list
     */
    public ArrayList<GenericEnemy> getEnemiesList() {
        return enemies;
    }
}
