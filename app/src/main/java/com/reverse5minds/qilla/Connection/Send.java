package com.reverse5minds.qilla.Connection;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

import com.reverse5minds.qilla.Constants;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

/**
 * Created by Varun on 04-09-2016.
 */
public class Send extends AsyncTask<String, Integer, String> {

        BufferedReader in;
        String add,data="";

        public interface sendListener {

            void onPreExecuteConcluded();
            void onPostExecuteConcluded(String res);
        }

        private sendListener mlistener;

        public void setListener(sendListener sl) {
            mlistener = sl ;
        }

        @SuppressLint("SetJavaScriptEnabled")
        @Override
        protected String doInBackground(String... nam) {

            add = Constants.URL ;
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
            if(mlistener!=null) {
                mlistener.onPostExecuteConcluded(result);
            }
        }

        @Override
        protected void onPreExecute() {
            if(mlistener!=null) {
                mlistener.onPreExecuteConcluded();
            }
        }
}
