package com.wordpress.techbeatsweb.inern;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.onesignal.OneSignal;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DELL on 12-Oct-19.
 */

public class Profile extends AppCompatActivity {
    public static final String BASE_URL = "http://docbook.orgfree.com/";
     private Button b1,b2,b3,b4,b5;
    private AdView mAdView;
    private InterstitialAd interstital;
    //adapterviewflipper object
    private AdapterViewFlipper adapterViewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        b1=(Button) findViewById(R.id.b1);
        b2=(Button) findViewById(R.id.b2);
        b3=(Button) findViewById(R.id.b3);
        b4=(Button) findViewById(R.id.b4);
        b5=(Button) findViewById(R.id.b5);

        //getting adapterviewflipper
        adapterViewFlipper = (AdapterViewFlipper) findViewById(R.id.adapterViewFlipper);

        //building retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Defining retrofit api service
        APIService service = retrofit.create(APIService.class);

        //creating an api call
        Call<Heroes> call =  service.getHeroes();

        //making the call
        call.enqueue(new Callback<Heroes>() {
            @Override
            public void onResponse(Call<Heroes> call, Response<Heroes> response) {

                //getting list of heroes
                ArrayList<Hero> heros = response.body().getHeros();

                //creating adapter object
                FlipperAdapter adapter = new FlipperAdapter(getApplicationContext(), heros);

                //adding it to adapterview flipper
                adapterViewFlipper.setAdapter(adapter);
                adapterViewFlipper.setFlipInterval(5000);
                adapterViewFlipper.startFlipping();
            }

            @Override
            public void onFailure(Call<Heroes> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent ir =new Intent(Profile.this,entr.class);
                startActivity(ir);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent ir =new Intent(Profile.this,sports.class);

                startActivity(ir);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent ir =new Intent(Profile.this,politics.class);
                startActivity(ir);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent ir =new Intent(Profile.this,edu.class);
                startActivity(ir);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent ir =new Intent(Profile.this,Quizz2.class);
                startActivity(ir);
            }
        });

    }
    public void onBackPressed(){

        finish();
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                dopen();
                ad();
                return true;
            case R.id.item2:
                    share();
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void ad() {

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        interstital = new InterstitialAd(Profile.this);
        interstital.setAdUnitId("ca-app-pub-2702096336547459/6133926029");
        interstital.loadAd(adRequest1);
        interstital.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                displayInterstial();
            }
        });
    }
    private void displayInterstial() {
        if (interstital.isLoaded()) {
            interstital.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }
    public void share()
    {
        Intent si = new Intent(Intent.ACTION_SEND);
        si.setType("text/plain");
        String ln ="Download Moneybaba :-To Play and win free paytm cash";
        String link="https://play.google.com/store/apps/details?id=com.wordpress.techbeatsweb.inern";
        si.putExtra(Intent.EXTRA_TEXT,ln + "     " +link);

        startActivity(Intent.createChooser(si,"Share via"));
    }
    public void dopen()
    {
        Intent ir =new Intent(Profile.this,info.class);
        startActivity(ir);
    }

}
