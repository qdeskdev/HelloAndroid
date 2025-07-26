package com.qdesk.helloandroid;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.qdesk.myutils.Logger;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView img,imgCar;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Logger.log("Hello from My Java Logger!");


        img = findViewById(R.id.img);
        imgCar = findViewById(R.id.imgCar);

        Animation slideUp = AnimationUtils.loadAnimation(this,R.anim.slide_up);
        Animation scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        Animation scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        Animation slideRight = AnimationUtils.loadAnimation(this,R.anim.slide_right);


        //Picasso image animation
        Picasso.get().load("https://gregcartmell.com/wp-content/uploads/2018/02/pablo-picasso-painting-2-742x1024.jpg")
                .placeholder(R.drawable.ic_launcher_foreground).noFade()
                .into(img, new Callback() {
                    @Override
                    public void onSuccess() {
                        img.startAnimation(slideUp);
                    }

                    @Override
                    public void onError(Exception e) {
                        Log.d("MainActivity","Exception"+e.getMessage());
                    }
                });


        img.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                img.startAnimation(scaleUp);
            } else if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {
                img.startAnimation(scaleDown);
                imgCar.startAnimation(slideRight);
            }
            return true;
        });

        // Car animation
        Picasso.get().
                load("https://static.vecteezy.com/system/resources/previews/023/524/637/non_2x/red-sport-car-design-transparent-background-free-png.png").
                placeholder(R.drawable.ic_launcher_foreground).
                into(imgCar, new Callback() {
                    @Override
                    public void onSuccess() {
                        imgCar.startAnimation(slideRight);
                    }

                    @Override
                    public void onError(Exception e) {
                        Log.d("MainActivity","Exception"+e.getMessage());
                    }
                });
    }
}