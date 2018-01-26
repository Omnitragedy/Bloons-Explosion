package com.example.rc211.myapplication.GeneralUtilities;

import android.telecom.Call;

import java.util.function.Function;


/**
 * Created by Saurav on 1/25/2018.
 */

public class Parametric {

    Function xFunc;
    Function yFunc;

    public Parametric(Function<Float, Float> xFunc, Function<Float, Float> yFunc) {
        xFunc = this.xFunc;
        yFunc = this.yFunc;
    }

    public float getX(float t) {
        return (float) xFunc.apply(t);
    }

    public float getY(float t) {
        return (float) xFunc.apply(t);
    }

}
