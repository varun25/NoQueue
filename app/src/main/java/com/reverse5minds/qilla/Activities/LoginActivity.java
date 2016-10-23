package com.reverse5minds.qilla.Activities;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.reverse5minds.qilla.Constants;
import com.reverse5minds.qilla.R;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

public class LoginActivity extends AppCompatActivity {

    EditText name, email, phno;
    Button reg;
    String userdetails="";
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        phno = (EditText) findViewById(R.id.phno);
        reg = (Button) findViewById(R.id.register);
        pb = (ProgressBar) findViewById(R.id.login_progress);
    }

    public void attemptLogin(View v) {
        phno.setTextColor(getResources().getColor(R.color.primary_text));
        email.setTextColor(getResources().getColor(R.color.primary_text));
        if(isEmailValid(email.getText().toString()) && isPhnoValid(phno.getText().toString()))
        {
            userdetails = "name=" + name.getText().toString() + "&email=" + email.getText().toString() + "&phno=" + phno.getText().toString();
            new read().execute();
            pb.setVisibility(View.VISIBLE);
            Snackbar.make(v, "Please wait", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
        else {
            if (isEmailValid(email.getText().toString())) {
                Snackbar.make(v, "Invalid phone number", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                phno.setTextColor(Color.RED);
            } else if(isPhnoValid(phno.getText().toString())){
                Snackbar.make(v, "Invalid email", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                email.setTextColor(Color.RED);
            }
            else {
                Snackbar.make(v, "Invalid email and phone number", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                email.setTextColor(Color.RED);
                phno.setTextColor(Color.RED);
            }
        }
    }


    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPhnoValid(String phno) {
        return (phno.length() > 9 && phno.length() < 11) ;
    }



    public class read extends AsyncTask<String, Integer, String> {
        BufferedReader in;
        String add,data="";

        @SuppressLint("SetJavaScriptEnabled")
        @Override
        protected String doInBackground(String... nam) {

            add = Constants.URL + userdetails.toString() ;
            try {
                HttpClient client = new DefaultHttpClient();
                URI website = new URI(add.toString());
                HttpGet request = new HttpGet();
                request.setURI(website);
                HttpResponse response = client.execute(request);
                in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                StringBuffer sb = new StringBuffer("");
                String l = "";
                String nl = System.getProperty("line.separator");
                while ((l = in.readLine()) != null) {
                    sb.append(l + nl);
                }
                in.close();
                data = sb.toString();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }

        @SuppressLint("SetJavaScriptEnabled")
        @Override
        protected void onPostExecute(String result) {

            if(data.contains("successfully created"))
            {
                Toast.makeText(getBaseContext(), "Successfully registered !", Toast.LENGTH_LONG).show();
                finish();
            }
            else
                Toast.makeText(getBaseContext(), "Something Went Wrong!", Toast.LENGTH_LONG).show();
            pb.setVisibility(View.INVISIBLE);

        }
    }
}

