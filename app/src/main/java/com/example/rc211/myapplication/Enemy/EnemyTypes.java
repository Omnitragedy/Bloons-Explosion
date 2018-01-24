package com.example.rc211.myapplication.Enemy;

import com.example.rc211.myapplication.Enemy.Specialized_Enemies.Grunt;

/**
 * Created by rc211 on 1/24/2018.
 */

public enum EnemyTypes {
    GRUNT (Grunt.class);

    EnemyTypes(Class<Grunt> gruntClass) {
        
    }
}
