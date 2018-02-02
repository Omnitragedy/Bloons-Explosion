package com.example.rc211.myapplication.GeneralUtilities;

import android.graphics.Canvas;
import android.telecom.Call;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;


/**
 * Created by Saurav on 1/25/2018.
 */

public class Parametric {

    private Function<Float, Float> xFunc;
    private Function<Float, Float> yFunc;

    public final float initX, initY;

    private ArrayList<Float> pts;

    private int screenWidth;

    public Parametric(Function<Float, Float> xFunc, Function<Float, Float> yFunc, float initX, float initY, int screenWidth) {
        this.xFunc = xFunc;
        this.yFunc = yFunc;

        this.initX = initX;
        this.initY = initY;

        this.screenWidth = screenWidth;

        pts = new ArrayList<>(screenWidth * 4/200);


        drawPath(0);
    }

    public float getX(float t) {
        return (float) xFunc.apply(t);
    }

    public float getY(float t) {
        return (float) yFunc.apply(t);
    }

    /**
     * Make array of points to be drawn for parametric to be rendered. DOES NOT ACTUALLY RETURN ARRAY
     * (must call getPath separately)
     */
    public float[] getPath() {
        float[] tempPts = new float[pts.size()];
        for (int i = 0; i < pts.size() ; i++) {
            tempPts[i] = pts.get(i);
        }

        return tempPts;
    }

    private void drawPath(int t) {
        int step = 200;

        if(getX(t+step) <= screenWidth) {
            pts.add(getX(t));
            pts.add(getY(t));
            pts.add(getX(t + step));
            pts.add(getY(t + step));
            drawPath(t + step);
        } else
            return;
    }

}
