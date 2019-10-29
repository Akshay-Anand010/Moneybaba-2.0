package com.wordpress.techbeatsweb.inern;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    DatabaseReference users;
    List<user> ur;

  ListView lvusers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvusers = (ListView) findViewById(R.id.lviewusers);
        users = FirebaseDatabase.getInstance().getReference("user");
        ur = new ArrayList<>();

    }

    @Override
    protected void onStart() {
        super.onStart();

        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ur.clear();
            for (DataSnapshot snapshot:dataSnapshot.getChildren())
            {
                user u1=snapshot.getValue(user.class);
                ur.add(u1);
            }
            p1 adapter =new p1(MainActivity.this,ur);
             lvusers.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}