package com.example.bilalramzan.enginebay;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Bilal Ramzan on 5/1/2017.
 */

public class gallParser extends AsyncTask<Void, Integer, Integer> {

    Context context;
    ListView lv;
    String data;

    ImageView img;
    ArrayList<String> gallery=new ArrayList<>();
    ProgressDialog pd;

    public gallParser(Context context, ListView lv, String data) {
        this.context = context;
        this.lv = lv;
        this.data = data;
    }

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
        pd=new ProgressDialog(context);
        pd.setTitle("Parser");
        pd.setMessage("Parsing....   Please wait!");
        pd.show();
    }

    @Override
    protected Integer doInBackground(Void... params)
    {
        return this.Parse();
    }

    @Override
    protected void onPostExecute(Integer integer)
    {
        super.onPostExecute(integer);
        if(integer==1)
        {
            ArrayAdapter <String> adapter=new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,gallery);
            lv.setAdapter(adapter);


        }
        else
        {
            Toast.makeText(context,"Unable To parse",Toast.LENGTH_SHORT).show();
        }
        pd.dismiss();
    }

    private int Parse()
    {
        try {
            JSONArray JA= new JSONArray(data);
            JSONObject JO = null;
            String log=null;
            String [] car_array = new String [JA.length()];


            gallery.clear();
            Bitmap b;
            for (int i=0;i<JA.length();i++)
            {


                JO=JA.getJSONObject(i);
                car_array[i]="Name: " + JO.getString("name") + "\nPrice: " + "(" + JO.getString("price") + ")" + "\nPower: "+ "(" + JO.getString("power") + ")" + "\nAverage: " + "(" + JO.getString("Average") + ")" + "\nType: "+ "(" + JO.getString("type") + ")"+ "\nCondition: "+ "(" + JO.getString("carcondition") + ")" + "\nStatus: "+ "(" + JO.getString("status") + ")" ;
                //String name=JO.getString("name");
                //gallery.add(name);


               // String price=JO.getString("price");
               gallery.add(car_array[i]);
            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;

    }
}

