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
    private Parametric pathFunctionsList;

    /**
     * Make path in terms of a function. Converts provided function into parametric curve
     * @param initX starting x-coord
     * @param initY starting y-coord
     */
    public EnemyPath(float initX, float initY, Function<Float,Float> xFunc, Function<Float,Float> yFunc) {
        this.initX = initX;
        this.initY = initY;

        pathFunctionsList = new Parametric(xFunc, yFunc);


    }

    public float getXCoord(float t) {
        return pathFunctionsList.getX(t);
    }

    public float getYCoord(float t) {
        return pathFunctionsList.getY(t);
    }

}
