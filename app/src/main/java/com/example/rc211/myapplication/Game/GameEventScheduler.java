package com.example.rc211.myapplication.Game;

import com.example.rc211.myapplication.Enemy.EnemyTypes;
import com.example.rc211.myapplication.Enemy.GenericEnemy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Saurav on 1/22/2018.
 */

public class GameEventScheduler {

    private ArrayList<GenericEnemy> enemies;
    private HashMap<EnemyTypes, Class> typeToSpecificEnemyMap;

    private static int tempEnemiesCount;        //used to simply store how many enemies have been spawned in a single
                                                //call of the scheduleAndRunEnemySpawn method

    public GameEventScheduler() {
        enemies = new ArrayList<>();

        typeToSpecificEnemyMap = new HashMap<>();
        for(EnemyTypes e : EnemyTypes.values()) {
            try {
                typeToSpecificEnemyMap.put(e, Class.forName(e.name())); //mapping from enum value of enemy to class
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }

        tempEnemiesCount = 0;

    }



    /**
     * Set how many enemies to spawn and the time interval between each of them
     * @param numOfEnemies number of enemies to spawn
     * @param intervalBetweenSpawn interval in ms
     */
    private void scheduleAndRunEnemySpawn(final int numOfEnemies, int intervalBetweenSpawn, EnemyTypes enemytype) {
        final Class typeOfEnemyToSpawn = typeToSpecificEnemyMap.get(enemytype); //type of enemy to spawn as class object


        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                tempEnemiesCount++;
                if(tempEnemiesCount > numOfEnemies) {
                    tempEnemiesCount = 0;
                    timer.cancel();
                }
                try {
                    enemies.add((GenericEnemy)(typeOfEnemyToSpawn.newInstance()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, intervalBetweenSpawn); //second - delay; third - time between each execution

    }

    private void scheduleAndRunEnemySpawn(final int numOfEnemies, float intervalBetweenSpawn, EnemyTypes enemytype) {
        scheduleAndRunEnemySpawn(numOfEnemies, intervalBetweenSpawn*1000, enemytype);   //////needs to be fixed
    }


    /**
     * Returns the list of enemies that have spawned
     * @return enemies list
     */
    public ArrayList<GenericEnemy> getEnemiesList() {
        return enemies;
    }

    public void update() {

    }
}
