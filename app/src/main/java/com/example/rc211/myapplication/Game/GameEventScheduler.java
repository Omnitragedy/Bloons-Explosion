package com.example.rc211.myapplication.Game;

import com.example.rc211.myapplication.Enemy.GenericEnemy;

import java.util.ArrayList;

/**
 * Created by Saurav on 1/22/2018.
 */

public class GameEventScheduler {

    private ArrayList<GenericEnemy> enemies;

    public GameEventScheduler() {
        enemies = new ArrayList<>();
    }

    /**
     *
     * @param numOfEnemies
     * @param intervalBetweenSpawn
     */
    public void scheduleAndRunEnemySpawn(int numOfEnemies, float intervalBetweenSpawn) {

    }


    public ArrayList<GenericEnemy> getEnemiesList() {
        return enemies;
    }
}
