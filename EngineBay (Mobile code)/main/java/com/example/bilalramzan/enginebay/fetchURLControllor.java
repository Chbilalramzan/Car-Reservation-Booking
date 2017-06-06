package com.example.bilalramzan.enginebay;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Bilal Ramzan on 5/2/2017.
 */

public class fetchURLControllor extends AsyncTask<Void,Integer,String> {

    Context context;
    ListView lv;
    String gallery_url;

    ProgressDialog pd;

    public fetchURLControllor(Context context, ListView lv, String gallery_url) {
        this.context = context;
        this.lv = lv;
        this.gallery_url = gallery_url;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(context);
        pd.setTitle("Fetch Data");
        pd.setMessage("Fetching....   Please wait!");
    }

    @Override
    protected String doInBackground(Void... params) {
        String data=readURL();


        return data;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        pd.dismiss();
        if(s!=null)
        {
            gallParser p=new gallParser(context,lv,s);
            p.execute();
        }
        else
        {
            Toast.makeText(context, "Unable to download data", Toast.LENGTH_SHORT).show();
        }
    }

    private  String readURL() {
        InputStream is=null;
        try {


            URL url = new URL(gallery_url);
            HttpURLConnection http=(HttpURLConnection)url.openConnection();
            http.setDoInput(true);
            http.connect();

           is=new BufferedInputStream(http.getInputStream());
            BufferedReader BR = new BufferedReader(new InputStreamReader(is));
            StringBuffer sb=new StringBuffer();
            String line = ""; //to reade data line by line
            if(BR!=null)
            {
                while ((line = BR.readLine()) != null) {
                    sb.append(line + "\n");
                }

            }else
            {
                return null;
            }

            return sb.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
