package com.example.chandan.hackazapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.amazonaws.http.HttpClient;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

public class MainActivity extends AppCompatActivity {

    private Button b_get;
    public double latitude;
    public double longitude;
    private TrackGPS gps;

    DynamoDBMapper dynamoDBMapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setPermissions();

        gps = new TrackGPS(MainActivity.this);

        b_get = (Button) findViewById(R.id.get_Loc);
        b_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Start GPS Service.
                setDefaults();

            }
        });


        AWSMobileClient.getInstance().initialize(this).execute();

        AmazonDynamoDBClient dynamoDBClient = new AmazonDynamoDBClient(AWSMobileClient.getInstance().getCredentialsProvider());
        this.dynamoDBMapper = DynamoDBMapper.builder()
                .dynamoDBClient(dynamoDBClient)
                .awsConfiguration(AWSMobileClient.getInstance().getConfiguration())
                .build();
    }

    public void setDefaults() {

        //Toast.makeText(MainActivity.this, "listener", Toast.LENGTH_SHORT).show();


        if (gps.canGetLocation()) {
            //Toast.makeText(MainActivity.this, "inside if", Toast.LENGTH_SHORT).show();
            longitude = gps.getLongitude();
            latitude = gps.getLatitude();

            Log.w("coord -> ", "Latitude ->" + latitude + " Longitude -> " + longitude);
            Toast.makeText(getApplicationContext(), "Longitude:" + Double.toString(longitude) + "\nLatitude:" + Double.toString(latitude), Toast.LENGTH_SHORT).show();


        } else {
            Log.w("gps: ", "in else part");
            gps.showSettingsAlert();
        }
    }



    void setPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    1);
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                    2);
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_NETWORK_STATE},
                    3);
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET},
                    3);
        }
    }







    }
