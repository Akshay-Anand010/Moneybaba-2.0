package com.wordpress.techbeatsweb.inern;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * Created by DELL on 12-Oct-19.
 */

public class edu extends Activity {
    private TextView sv;
    private TextView ques;
    private String mAnswer;
    private int mQuestionno = 0;
    private Button bc1, bc2, bc3, bc4,quit;
    private int mScore;
    private Firebase mQuesRef, bc1ref, bc2ref, bc3ref, bc4ref, mAnsref;
    public int i=0;
    ProgressBar progressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizzy);
        sv = (TextView) findViewById(R.id.score);
        ques = (TextView) findViewById(R.id.question);

        bc1 = (Button) findViewById(R.id.choice1);
        bc2 = (Button) findViewById(R.id.choice2);
        bc3 = (Button) findViewById(R.id.choice3);
        bc4 = (Button) findViewById(R.id.choice4);
        quit=(Button)findViewById(R.id.quit);
        updateQuestion();
        q1();
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(edu.this,Profile.class);
                startActivity(i);
            }
        });
        bc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bc1.getText().equals(mAnswer)) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                } else {
                    updateQuestion();
                }
            }
        });
        bc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bc2.getText().equals(mAnswer)) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                } else {
                    updateQuestion();
                }
            }
        });
        bc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bc3.getText().equals(mAnswer)) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                } else {
                    updateQuestion();
                }
            }
        });
        bc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bc4.getText().equals(mAnswer)) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                } else {
                    updateQuestion();
                }
            }
        });

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        new AsyncTask<Object, Void, Void>() {
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            protected Void doInBackground(Object... params) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                progressBar.setVisibility(View.GONE);
            }
        }.execute();



    }
    public void q1() {
        if (mQuestionno==6) {
            if (mScore==5) {
                Intent intent = new Intent(edu.this, splash.class);
                startActivity(intent);
            } else {
                alert();
            }
        }
    }

    public void updateScore(int mScore) {
        sv.setText(" " + mScore);
    }

    public void updateQuestion() {
        mQuesRef = new Firebase("https://inern-a2bba.firebaseio.com/education/" + mQuestionno + "/question");
        mQuesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String question = dataSnapshot.getValue(String.class);
                ques.setText(question);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        bc1ref = new Firebase("https://inern-a2bba.firebaseio.com/education/" + mQuestionno + "/choice1");
        bc1ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                bc1.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        bc2ref = new Firebase("https://inern-a2bba.firebaseio.com/education/" + mQuestionno + "/choice2");
        bc2ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                bc2.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        bc3ref = new Firebase("https://inern-a2bba.firebaseio.com/education/" + mQuestionno + "/choice3");
        bc3ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                bc3.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        bc4ref = new Firebase("https://inern-a2bba.firebaseio.com/education/" + mQuestionno + "/choice4");
        bc4ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                bc4.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mAnsref = new Firebase("https://inern-a2bba.firebaseio.com/education/" + mQuestionno + "/answer");
        mAnsref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mAnswer = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mQuestionno++;
            q1();
    }


    public void alert() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.CustomDialogTheme);
        builder.setTitle("trio india");
        builder.setMessage("Thank ou for Playing..Better luck next Time!");
        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(edu.this, Profile.class);
                        startActivity(intent);
                    }
                });
        builder.show();
    }



}
