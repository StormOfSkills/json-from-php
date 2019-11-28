package com.example.json_from_php;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;


public class Activity2 extends AppCompatActivity {
    Button btnview;
    TextView uid, name, phone, email;

    phpConn phpC = new phpConn();
    final String fetch = "http://192.168.8.108:8080/sqli/fetch2json.php";
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_adapter_view);


    }
}
