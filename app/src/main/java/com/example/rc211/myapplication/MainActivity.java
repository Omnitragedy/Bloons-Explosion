package com.example.rc211.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void onGameBegin(View view) {
        Intent myIntent = new Intent(view.getContext(), GameScreenActivity.class);
        startActivityForResult(myIntent, 0);
    }


    
    
}
