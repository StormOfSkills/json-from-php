package com.example.json_from_php;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Button btnview;
    TextView uid, name, phone, email;

    phpConn phpC = new phpConn();
    final String fetch = "http://192.168.8.108:8080/sqli/fetch2json.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //textview=(TextView)findViewById(R.id.textView);
        btnview= (Button)findViewById(R.id.btnview);
        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    phpC.urlCon(fetch);
                    //getting an array back
                    JSONArray js_array = new JSONArray(phpC.getAnswer());
                    //textview.setText(js_array.toString());

                    //JSONObject jsonObject = new JSONObject();
                    /* reading the JSON array line by line */
                    for (int i = 0; i < js_array.length(); i++) {
                        JSONArray array = js_array.optJSONArray(i);
                        String id = array.getString(0);
                        String name = array.getString(1);
                        String phone = array.getString(2);
                        String email = array.getString(3);
                        //String value=js_array.getString(i);
                        Log.v("george json", "ID: "+id+" Name: "+name+" Phone: "+phone+" Email"+ email);
                    }
                } catch (Exception e) {
                    Log.e("Error", e.toString());
                }

            }

        });

    }
}
