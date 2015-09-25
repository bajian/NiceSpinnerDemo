package com.example.bajian.spinnerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.bajian.nicespinner.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    private Spinner spinner;
    private static final String[] list={"One", "Two", "Three", "Four", "Five"};
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //普通Spinner
        spinner=(Spinner)findViewById(R.id.spinner);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        spinner.setAdapter(adapter);

        //NiceSpinner
        final NiceSpinner niceSpinner = (NiceSpinner) findViewById(R.id.nice_spinner);
        final List<String> dataset = new LinkedList<>(Arrays.asList("One", "Two", "Three", "Four", "Five"));
        niceSpinner.attachDataSource(dataset);
        niceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG,"change before"+niceSpinner.getText().toString().trim());//这个是获得点击前的值、、
                Log.d(TAG,"position"+position);//这个是获得点击前的值、、
                Log.d(TAG,"change after"+dataset.get(position));//这个是获得点击后的值、、
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //compat_spinner
        AppCompatSpinner compat_spinner= (AppCompatSpinner) findViewById(R.id.compat_spinner);
        compat_spinner.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}
