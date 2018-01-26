package com.example.rc211.myapplication.GeneralUtilities;

import android.provider.ContactsContract;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.function.Function;

/**
 * Created by Saurav on 1/25/2018.
 */

public class EnemyPath {

    private float initX;
    private float initY;
    private ArrayList<Parametric> pathFunctionsList;

    /**
     * Make path in terms of a function. Converts provided function into parametric curve
     * @param initX starting x-coord
     * @param initY starting y-coord
     */
    public EnemyPath(float initX, float initY, ArrayList<Function<Float,Float>> xFuncs, ArrayList<Function<Float,Float>> yFuncs) {
        this.initX = initX;
        this.initY = initY;

        if(xFuncs.size() != yFuncs.size()) {
            try {
                throw new Exception("Functions for parametric path of enemy function mismatch");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            for(int i = 0; i < xFuncs.size() - 1; i++) {
                pathFunctionsList.add(new Parametric(xFuncs.get(i), yFuncs.get(i)));
            }
        }


    }

    public float getYCoord(float t) {

    }

}
