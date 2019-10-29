package com.wordpress.techbeatsweb.inern;
import android.app.Application;

import com.firebase.client.Firebase;

public class quizzy extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        Firebase.setAndroidContext(this);


    }
}