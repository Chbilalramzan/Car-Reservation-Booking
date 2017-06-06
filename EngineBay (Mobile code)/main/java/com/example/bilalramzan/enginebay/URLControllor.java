package com.example.bilalramzan.enginebay;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Bilal Ramzan on 4/24/2017.
 */

public class URLControllor  extends AsyncTask<String,Void,String>
{

    AlertDialog AD; //to show dialog
    //Constructor
    Context context;
    URLControllor(Context ctx)
    {
        context=ctx;
    }


    @Override
    protected String doInBackground(String... params)
    {
        String type=params[0];
        String register_url="http://10.0.2.2/Engine_bay_android/include/register.php";
        String Login_url   ="http://10.0.2.2/Engine_bay_android/include/Login.php";
        String Cdetail_url ="http://10.0.2.2/Engine_bay_android/include/customer_detail.php";
        String booking_url ="http://10.0.2.2/Engine_bay_android/include/bookinginfo.php";


        if (type.equals("register"))        //Http registration handling
        {
            try
            {
                String name=params[1];
                String mail=params[2];
                String pass=params[3];
                URL url=new URL(register_url);
                HttpURLConnection http=(HttpURLConnection)url.openConnection();
                //http properties
                http.setRequestMethod("POST");
                http.setConnectTimeout(20000);
                http.setReadTimeout(20000);
                http.setDoOutput(true);
                http.setDoInput(true);

                OutputStream OS=http.getOutputStream();
                BufferedWriter BW=new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));

                //post data into localhost
                String POST_data= URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"        //+ for concatination
                                 +URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(mail,"UTF-8")+"&"              //& for joining the url
                                 +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(pass,"UTF-8");
                BW.write(POST_data);
                BW.flush();
                BW.close();

                InputStream IS=http.getInputStream();
                BufferedReader BR=new BufferedReader(new InputStreamReader(IS,"iso-8859-1"));
                String result="";
                String line=""; //to reade data line by line
                while ((line=BR.readLine())!=null)
                {
                    result+=line;
                }

                BR.close();
                IS.close();
                http.disconnect();
                return result;
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (type.equals("Login"))    //Http Login Handling
        {
            try
            {
                String mail=params[1];
                String pass=params[2];
                URL url=new URL(Login_url);
                HttpURLConnection http=(HttpURLConnection)url.openConnection();
                http.setRequestMethod("POST");
                http.setDoOutput(true);
                http.setDoInput(true);

                OutputStream OS=http.getOutputStream();
                BufferedWriter BW=new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));

                //post data into localhost
                String POST_data=URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(mail,"UTF-8")+"&"        //+ for concatination
                            +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(pass,"UTF-8");//& for joining the url

                BW.write(POST_data);
                BW.flush();
                BW.close();

                InputStream IS=http.getInputStream();
                BufferedReader BR=new BufferedReader(new InputStreamReader(IS,"iso-8859-1"));
                String result="";
                String line=""; //to reade data line by line
                while ((line=BR.readLine())!=null)
                {
                    result+=line;
                }



                BR.close();
                IS.close();
                http.disconnect();
                return result;
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (type.equals("customer_detail"))    //Http customer details Handling
        {
            String title=params[1];
            String fname=params[2];
            String lname=params[3];
            String pno=params[4];
            String cnic=params[5];
            String address=params[6];
            String city=params[7];
            String postalcode=params[8];
            String country=params[9];

                try {

                    URL url = new URL(Cdetail_url);
                    HttpURLConnection http = (HttpURLConnection) url.openConnection();
                    http.setRequestMethod("POST");
                    http.setDoOutput(true);
                    http.setDoInput(true);

                    OutputStream OS = http.getOutputStream();
                    BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));

                    //post data into localhost
                    String POST_data = URLEncoder.encode("title", "UTF-8") + "=" + URLEncoder.encode(title, "UTF-8") + "&"        //+ for concatination
                            + URLEncoder.encode("fname", "UTF-8") + "=" + URLEncoder.encode(fname, "UTF-8") + "&"
                            + URLEncoder.encode("lname", "UTF-8") + "=" + URLEncoder.encode(lname, "UTF-8") + "&"        //& for joining the url
                            + URLEncoder.encode("p_no", "UTF-8") + "=" + URLEncoder.encode(pno, "UTF-8") + "&"
                            + URLEncoder.encode("cnic", "UTF-8") + "=" + URLEncoder.encode(cnic, "UTF-8") + "&"
                            + URLEncoder.encode("address", "UTF-8") + "=" + URLEncoder.encode(address, "UTF-8") + "&"
                            + URLEncoder.encode("city", "UTF-8") + "=" + URLEncoder.encode(city, "UTF-8") + "&"        //+ for concatination
                            + URLEncoder.encode("post_code", "UTF-8") + "=" + URLEncoder.encode(postalcode, "UTF-8") + "&"
                            + URLEncoder.encode("country", "UTF-8") + "=" + URLEncoder.encode(country, "UTF-8");

                    BW.write(POST_data);
                    BW.flush();
                    BW.close();

                    InputStream IS = http.getInputStream();
                    BufferedReader BR = new BufferedReader(new InputStreamReader(IS, "iso-8859-1"));
                    String result = "";
                    String line = ""; //to reade data line by line
                    while ((line = BR.readLine()) != null) {
                        result += line;
                    }

                    BR.close();
                    IS.close();
                    http.disconnect();
                    return result;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        if (type.equals("booking"))        //Http registration handling
        {
            try
            {
                String pdate=params[1];
                String ptime=params[2];
                String ddate=params[3];
                String dtime=params[4];
                String Car=params[5];
                String title=params[6];
                URL url=new URL(booking_url);
                HttpURLConnection http=(HttpURLConnection)url.openConnection();
                //http properties
                http.setRequestMethod("POST");
                http.setConnectTimeout(20000);
                http.setReadTimeout(20000);
                http.setDoOutput(true);
                http.setDoInput(true);

                OutputStream OS=http.getOutputStream();
                BufferedWriter BW=new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));

                //post data into localhost
                String POST_data= URLEncoder.encode("pdate","UTF-8")+"="+URLEncoder.encode(pdate,"UTF-8")+"&"        //+ for concatination
                                 +URLEncoder.encode("ptime","UTF-8")+"="+URLEncoder.encode(ptime,"UTF-8")+"&"              //& for joining the url
                                 +URLEncoder.encode("ddate","UTF-8")+"="+URLEncoder.encode(ddate,"UTF-8")+"&"        //+ for concatination
                                 +URLEncoder.encode("dtime","UTF-8")+"="+URLEncoder.encode(dtime,"UTF-8")+"&"
                                 +URLEncoder.encode("car","UTF-8")+"="+URLEncoder.encode(Car,"UTF-8")    +"&"//& for joining the url
                                 +URLEncoder.encode("title","UTF-8")+"="+URLEncoder.encode(title,"UTF-8");
                BW.write(POST_data);
                BW.flush();
                BW.close();

                InputStream IS=http.getInputStream();
                BufferedReader BR=new BufferedReader(new InputStreamReader(IS,"iso-8859-1"));
                String result="";
                String line=""; //to reade data line by line
                while ((line=BR.readLine())!=null)
                {
                    result+=line;
                }

                BR.close();
                IS.close();
                http.disconnect();
                return result;
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }



    @Override
    protected void onPreExecute() {
        AD=new AlertDialog.Builder(context).create();
        AD.setTitle("Registration Status");
    }

    @Override
    protected void onPostExecute(String result) {

       AD.setMessage(result);
        AD.show();


    }
        @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
