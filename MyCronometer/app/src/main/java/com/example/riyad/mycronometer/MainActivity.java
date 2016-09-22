package com.example.riyad.mycronometer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public ImageView imageView;
    public Button bt_parar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        bt_parar = (Button) findViewById(R.id.bt_Parar);


    }

    public void inicia (View view){
        imageView.setVisibility(View.VISIBLE);
        bt_parar.setVisibility(View.VISIBLE);
        startService(new Intent(this, HelloIntentService.class));
        toast("Cronômetro iniciado!");
    }

    public void encerra(View view){
        imageView.setVisibility(View.INVISIBLE);
        bt_parar.setVisibility(View.INVISIBLE);
        stopService(new Intent(this, HelloIntentService.class));
        toast("Cronômetro encerrado!");
    }

    private void toast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

    }
}
