package com.example.rc211.myapplication.GeneralUtilities;

import android.telecom.Call;

import java.util.concurrent.Callable;
import java.util.function.Function;

/**
 * Created by Saurav on 1/25/2018.
 */

public class Parametric {

    Function xFunc;
    Function yFunc;

    public Parametric(Runnable xFunc, Runnable yFunc) {
        xFunc = this.xFunc;
        yFunc = this.yFunc;
    }

    public float getX(float t) {
        return xFunc.run();
    }

}
