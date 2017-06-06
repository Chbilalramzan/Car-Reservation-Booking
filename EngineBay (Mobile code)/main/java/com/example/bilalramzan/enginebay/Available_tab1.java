package com.example.bilalramzan.enginebay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Bilal Ramzan on 4/21/2017.
 */

public class Available_tab1 extends Fragment {

    ListView lv;
    String gallery_url = "http://10.0.2.2/Engine_bay_android/include/reserve.php";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootview= inflater.inflate(R.layout.available_tab1,container,false);

        lv = (ListView) rootview.findViewById(R.id.Alv);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itm = Integer.toString(position);
                Toast.makeText(view.getContext(),((TextView)view).getText() + itm, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(view.getContext(),Bookinginfo.class);
                String product = ((TextView) view).getText().toString();

                i.putExtra("product",product);
                startActivity(i);
            }
        });
        fetchURLControllor  d=new fetchURLControllor(this.getActivity(),lv,gallery_url);
        d.execute();

        return rootview;
    }

}
