package com.wordpress.techbeatsweb.inern;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;



/**
 * Created by DELL on 05-Oct-19.
 */

public class p1 extends ArrayAdapter<user>
{
    private Activity context;
    private List<user> u1;


    public p1(Activity context,List<user> u1){
        super(context,R.layout.pl,u1);
        this.context=context;
        this.u1=u1;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        final View listviewitem=inflater.inflate(R.layout.pl,null,true);

        final TextView t1=(TextView)listviewitem.findViewById(R.id.name1);
        TextView t2=(TextView)listviewitem.findViewById(R.id.email1);
        TextView t3=(TextView)listviewitem.findViewById(R.id.city1);
        TextView t4=(TextView)listviewitem.findViewById(R.id.pass1);

        user ur =u1.get(position);


        t1.setText(ur.getName());
        t2.setText(ur.getEmail());
        t3.setText(ur.getCity());
        t4.setText(ur.getPass());



        return listviewitem;
    }

}