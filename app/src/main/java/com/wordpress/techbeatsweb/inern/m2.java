package com.wordpress.techbeatsweb.inern;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by DELL on 05-Oct-19.
 */

public class m2  extends AppCompatActivity implements View.OnClickListener {

    private Button reg;
    private EditText name;
    private EditText email;
    private EditText pass;
    private EditText city;
    private Button signin;
    private ProgressBar progressBar;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m2);
        progressBar=new ProgressBar(this);
        reg = (Button) findViewById(R.id.btn);
        name = (EditText) findViewById(R.id.ediname);
        email = (EditText) findViewById(R.id.editemail);
        pass = (EditText) findViewById(R.id.editpassword);
        city = (EditText) findViewById(R.id.city);
        signin = (Button) findViewById(R.id.btn1);
        reg.setOnClickListener(this);
        signin.setOnClickListener(this);

        users = FirebaseDatabase.getInstance().getReference("user");




    }
    private void register()
    {
        String na=name.getText().toString().trim();
        String pas= pass.getText().toString().trim();
        String ci= city.getText().toString().trim();
        String em= email.getText().toString().trim();

        if(TextUtils.isEmpty(na))
        {
            Toast.makeText(this,"Please enter name",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pas))
        {
            Toast.makeText(this,"Please enter password",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(ci))
        {
            Toast.makeText(this,"Please enter city",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(em))
        {
            Toast.makeText(this,"Please enter email",Toast.LENGTH_SHORT).show();
            return;
        }
        String id= users.push().getKey();
        user u1=new user(na,ci,em,pas);
        users.child(id).setValue(u1);
       dopen();

    }

public void dopen()
{

    final AlertDialog.Builder builder = new AlertDialog.Builder(m2.this);
    LayoutInflater inflater = getLayoutInflater();
    View view = inflater.inflate(R.layout.custom,null);
    TextView tv = (TextView)view.findViewById(R.id.head);

    builder.setView(view);
    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
           name.setText("");
            email.setText("");
            pass.setText("");
            city.setText("");
            dialog.dismiss();
        }
    });

    builder.show();

        }
    public void open()
    {

        Intent intent=new Intent(m2.this,MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void onClick(View v) {
        if (v==reg)
            register();
        if (v==signin)
            open();
    }
}