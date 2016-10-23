package com.reverse5minds.qilla.Activities;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.reverse5minds.qilla.R;

/**
 * Created by Varun on 28-08-2016.
 */
public class Splash extends AppCompatActivity {

    View rootv ;
    Thread timer;
    Button fab ;
    int count = 0;
    String mesgStr=null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        fab = (Button) findViewById(R.id.ret);
        fab.setX(3000);

        timer = new Thread(){
            public void run(){
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                }
                Splash.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {

                        }
                        finally{
                            rootv = findViewById(android.R.id.content);
                            if(checkconnection()==0)
                            {
                                fab.setX(0);
                            }
                        }
                    }
                });super.run();
            }
        };
        timer.start();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootv = view;
                checkconnection();
            }
        });
    }

    public int checkconnection() {

        ConnectivityManager connec = (ConnectivityManager) getSystemService(getBaseContext().CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connec.getActiveNetworkInfo();
        if(!((activeNetworkInfo!=null) && (activeNetworkInfo.isConnected())))
        {
            switch(count)
            {
                case 0 : mesgStr = "\t\tCannot connect to internet :( \n\t\tPlease check your internet connection";
                         break;
                case 1 : mesgStr = "\t\tY o u   l o o k   h u n g r y !! :)\n\t\tPlease check your internet connection";
                    break;
                case 2 : mesgStr = "\t\tY o u   l o o k   h u n g r y !! :)\n\t\tTry to get   H O T S P O T   from your friend ";
                    break;
            }
            Snackbar.make(rootv, mesgStr, Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            count++;
            return 0;
        }
        else
        {
            Intent khaana = new Intent("android.intent.action.VIEWRESTAURANTS");
            startActivity(khaana);
            finish();
        }
        return 1;
    }
}
