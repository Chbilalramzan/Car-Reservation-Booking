package com.example.bilalramzan.enginebay;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Bilal Ramzan on 4/23/2017.
 */

public class About extends Fragment {

    public About()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootview= inflater.inflate(R.layout.about,container,false);

        return rootview;
    }
}
