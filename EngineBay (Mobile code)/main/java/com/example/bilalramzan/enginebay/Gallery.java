package com.example.bilalramzan.enginebay;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by Bilal Ramzan on 4/23/2017.
 */

public class Gallery extends Fragment {



    ListView lv;
    String gallery_url = "http://10.0.2.2/Engine_bay_android/include/retrievegallery.php";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.gallery, container, false);

         lv = (ListView) rootview.findViewById(R.id.lv);
        fetchURLControllor  d=new fetchURLControllor(this.getActivity(),lv,gallery_url);
        d.execute();


        return rootview;
    }

    }

