package com.example.rc211.myapplication;

import android.app.Activity;
import android.os.Bundle;

import com.example.rc211.myapplication.Game.GameEventScheduler;

public class MainActivity extends Activity {


    private static GameEventScheduler gamehandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gamehandler = new GameEventScheduler();

    }






    
    
}
