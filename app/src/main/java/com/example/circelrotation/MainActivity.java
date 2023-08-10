package com.example.circelrotation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    CircleImageView hinhanh;
    Button buttonStart, buttonStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hinhanh = findViewById(R.id.action_image);
        buttonStart = findViewById(R.id.start_button);
        buttonStop = findViewById(R.id.stop_button);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation();
            }
        });
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAnimation();
            }
        });
    }

    private void stopAnimation() {
        hinhanh.animate().cancel();

    }

    private void startAnimation() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                hinhanh.animate().rotationBy(360).withEndAction(this).setDuration(5000)
                        .setInterpolator(new LinearInterpolator()).start();
            }

        };
        hinhanh.animate().rotationBy(360).withEndAction(runnable).setDuration(5000)
                .setInterpolator(new LinearInterpolator()).start();
    }
}