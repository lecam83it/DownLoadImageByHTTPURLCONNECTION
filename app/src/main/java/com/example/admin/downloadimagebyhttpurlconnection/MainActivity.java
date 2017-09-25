package com.example.admin.downloadimagebyhttpurlconnection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.admin.async.ImageAsync;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgLoad;
    private Button btnLoad;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        url = "https://scontent.fdad4-1.fna.fbcdn.net/v/t1.0-9/19731852_1401970219869912_7550049522958884326_n.jpg?oh=7bf8fa1d1db0294f39c2fa49588d3c00&oe=5A4D642E";
        addControls();
        addEvents();
    }


    private void addControls() {
        imgLoad = (ImageView) findViewById(R.id.imgLoad);
        btnLoad = (Button) findViewById(R.id.btnLoad);
    }

    private void addEvents() {
        btnLoad.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        new ImageAsync(MainActivity.this, imgLoad).execute(url);
    }
}
