package com.reverse5minds.qilla.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.reverse5minds.qilla.Connection.Send;
import com.reverse5minds.qilla.R;

/**
 * Created by Varun on 09-09-2016.
 */

public class Test extends AppCompatActivity implements Send.sendListener {

    Send.sendListener lisss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offerpage);
        lisss = this;
        new Send().execute();
    }

    @Override
    public void onPreExecuteConcluded() {
        Toast.makeText(getBaseContext(), "Awesomeness 1!!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPostExecuteConcluded(String res) {
        Toast.makeText(getBaseContext(), "Awesomeness 2!!", Toast.LENGTH_LONG).show();
    }
}


