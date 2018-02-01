package com.example.rc211.myapplication.GeneralUtilities;

import android.telecom.Call;

import java.util.function.Function;


/**
 * Created by Saurav on 1/25/2018.
 */

public class Parametric {

    private Function<Float, Float> xFunc;
    private Function<Float, Float> yFunc;

    public Parametric(Function<Float, Float> xFunc, Function<Float, Float> yFunc) {
        this.xFunc = xFunc;
        this.yFunc = yFunc;
    }

    public float getX(float t) {
        return (float) xFunc.apply(t);
    }

    public float getY(float t) {
        return (float) xFunc.apply(t);
    }

}
