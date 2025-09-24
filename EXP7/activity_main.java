package com.example.exp7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView image1,image2;
    private boolean show=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image1=findViewById(R.id.imageView);
        image2=findViewById(R.id.imageView3);
        Button toggle=findViewById(R.id.button);
        toggle.setOnClickListener(view -> {
            if (show) {
                image1.setVisibility(View.GONE);
                image2.setVisibility(View.VISIBLE);
            } else {
                image1.setVisibility(View.VISIBLE);
                image2.setVisibility(View.GONE);
            }
            show = !show;
        });
    }
}
