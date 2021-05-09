package com.example.syuaib;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.location_map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //  tambah koordinat marker
        LatLng rumah = new LatLng (-0.928826, 119.872015);
        LatLng smartkitchen = new LatLng(-0.923011, 119.866116);

//    atur ukuran marker
        int tinggi = 100;
        int lebar = 100;

        BitmapDrawable bitmapStart = (BitmapDrawable)getResources().getDrawable(R.drawable.syuaib);
        BitmapDrawable bitmapDes = (BitmapDrawable)getResources().getDrawable(R.drawable.toko);

        Bitmap s = bitmapStart.getBitmap();
        Bitmap d = bitmapDes.getBitmap();

        Bitmap markerStart = Bitmap.createScaledBitmap(s, lebar, tinggi, false);
        Bitmap markerDes = Bitmap.createScaledBitmap(d, lebar, tinggi, false);

//    tambahkan marker ke map
        mMap.addMarker(new MarkerOptions().position(rumah).title("Marker in rumah")
                .snippet("Ini rumah ")
                .icon(BitmapDescriptorFactory.fromBitmap(markerStart)));

        mMap.addMarker(new MarkerOptions().position(smartkitchen).title("Marker in smartkitchen" )
                .snippet("Ini smartkitchen")
                .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));

        mMap.addPolyline(new PolylineOptions().add(
                rumah,
                new LatLng(-0.928826, 119.872015),
                new LatLng(-0.928091, 119.871870),
                new LatLng(-0.928121, 119.871157),
                new LatLng(-0.928263, 119.870307),
                new LatLng(-0.925841, 119.869696),
                new LatLng(-0.922057, 119.870125),
                new LatLng(-0.922604, 119.868452),
                new LatLng(-0.923048, 119.866892),
                new LatLng(-0.923011, 119.866116),
                smartkitchen
        ).width(10)
                .color(Color.RED));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rumah, 11.5f));
    }
}
