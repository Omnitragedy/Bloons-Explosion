package com.example.rc211.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.rc211.myapplication.Game.GameHandler;

public class MainActivity extends Activity {


    private static GameHandler gamehandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gamehandler = new GameHandler();

    }






    
    
}
