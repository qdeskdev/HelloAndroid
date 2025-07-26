package com.qdesk.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import pl.droidsonroids.gif.GifImageView;
import pl.droidsonroids.gif.GifTextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        ImageView gifImg = findViewById(R.id.gifImg);

        Glide.with(this)
                .asGif()
                .load("https://media4.giphy.com/media/v1.Y2lkPTc5MGI3NjExa3FwMXVsd3hiNmFjNWE0dDVndGMxZDBmM3Y4ODg5Z3h3eXR2NTQwaCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/8PjAb8aF8a62LuoU0d/giphy.gif")
                .into(gifImg);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent a = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(a);
                finish();
            }
        },5000);

    }
}