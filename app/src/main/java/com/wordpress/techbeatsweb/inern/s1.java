package com.wordpress.techbeatsweb.inern;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by DELL on 13-Oct-19.
 */

public class s1 extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s1);


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent hi = new Intent(s1.this,Profile.class);
                startActivity(hi);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
