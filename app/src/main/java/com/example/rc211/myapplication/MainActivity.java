package com.example.rc211.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("blah");
    }

    public boolean getAlec(boolean work){
        if (work){
            return true;
        }
        return false;
    }

    public boolean getNitn(boolean sdf){
        if (sdf){
            return true;
        }
        return false;
    }


    public boolean getShg(boolean sdf){
        if (sdf){
            return true;
        }
        return false;
    }


    public boolean getSvhjh(boolean sdf){
        if (sdf){
            return true;
        }
        return false;
    }
}
