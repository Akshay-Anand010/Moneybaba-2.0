package com.wordpress.techbeatsweb.inern;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class info extends AppCompatActivity {
    Button bb;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
        ActionBar actionBar = getActionBar();
        bb = (Button) findViewById(R.id.bb);


        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"trioindia697@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "User Fedback");
                intent.setType("plain/text");
                startActivity(intent);
            }
        });

    }
    }

