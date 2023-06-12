package com.example.a20f0196.project;

import android.os.AsyncTask;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Fetchdata extends AsyncTask<Object,String,String> {
    String googlebyneardata;
    GoogleMap googleMap;
    String url;

    @Override
    protected String doInBackground(Object... objects) {
        try{
            googleMap=(GoogleMap)  objects[0];
            url=(String) objects[1];
            DownloadUrl downloadUrl=new DownloadUrl();
            googlebyneardata=downloadUrl.retrieveUrl(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return googlebyneardata;
    }

    @Override
    protected void onPostExecute(String s) {
        try {
            JSONObject jsonObject=new JSONObject(s);
            JSONArray jsonArray=jsonObject.getJSONArray("result");
            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                JSONObject getlocation=jsonObject1.getJSONObject("geometry")
                        .getJSONObject("location");

                String lat=getlocation.getString("lat");
                String lng= getlocation.getString("lng");


                JSONObject  getname=jsonArray.getJSONObject(i);
                String name=getname.getString("name");

                LatLng latLng=new LatLng(Double.parseDouble(lat),Double.parseDouble(lng));
                MarkerOptions markerOptions=new MarkerOptions();

                markerOptions.title(name);
                markerOptions.position(latLng);
                googleMap.addMarker(markerOptions);
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));

            }

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
