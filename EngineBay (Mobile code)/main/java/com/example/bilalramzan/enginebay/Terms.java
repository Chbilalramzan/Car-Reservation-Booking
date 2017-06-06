package com.example.bilalramzan.enginebay;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Bilal Ramzan on 5/3/2017.
 */

public class Terms  extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootview= inflater.inflate(R.layout.terms,container,false);

        return rootview;
    }
}
