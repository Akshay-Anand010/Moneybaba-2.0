package com.wordpress.techbeatsweb.inern;

import android.widget.EditText;

/**
 * Created by DELL on 05-Oct-19.
 */

public class user {

    String name;
    String city;
    String email;
    String pass;

    public user()
    {

    }

    public user(String name, String city, String email,String pass) {
        this.name = name;
        this.city = city;
        this.email = email;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }
}
