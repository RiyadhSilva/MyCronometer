package com.example.riyad.mycronometer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService(new Intent(this, HelloIntentService.class));

    }

    public void inicia (View view){
        startService(new Intent(this, HelloIntentService.class));
    }
}
