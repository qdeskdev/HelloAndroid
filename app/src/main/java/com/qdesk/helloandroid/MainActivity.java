package com.qdesk.helloandroid;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.qdesk.toasty.Toaster;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private ImageView img, imgCar;
    private static final String PICASSO_IMAGE_URL = "https://gregcartmell.com/wp-content/uploads/2018/02/pablo-picasso-painting-2-742x1024.jpg";
    private static final String CAR_IMAGE_URL = "https://static.vecteezy.com/system/resources/previews/023/524/637/non_2x/red-sport-car-design-transparent-background-free-png.png";

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setupToasts();
        setupAnimations();
        loadImages();
    }

    private void initializeViews() {
        img = findViewById(R.id.img);
        imgCar = findViewById(R.id.imgCar);
    }

    private void setupToasts() {
        // Simple toast
        Toaster.show(this, "Hello from Toaster library!");

        // Success toast (green background with checkmark)
        Toaster.success(this, "Operation successful!");

        // Error toast (red background with error icon)
        Toaster.error(this, "Something went wrong");

        // Warning toast (orange background with warning icon)
        Toaster.warning(this, "Please check your input");

        // Info toast (blue background with info icon)
        Toaster.info(this, "New update available");
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setupAnimations() {
        Animation slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        Animation scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        Animation scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);
        Animation slideRight = AnimationUtils.loadAnimation(this, R.anim.slide_right);

        img.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                img.startAnimation(scaleUp);
            } else if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {
                img.startAnimation(scaleDown);
                imgCar.startAnimation(slideRight);
            }
            return true;
        });
    }

    private void loadImages() {
        // Picasso image loading with better error handling
        Picasso.get()
                .load(PICASSO_IMAGE_URL)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background) // Add error placeholder
                .into(img, new Callback() {
                    @Override
                    public void onSuccess() {
                        Animation slideUp = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_up);
                        img.startAnimation(slideUp);
                    }

                    @Override
                    public void onError(Exception e) {
                        Log.e("MainActivity", "Picasso loading error: " + e.getMessage());
                        Toaster.error(MainActivity.this, "Failed to load image");
                    }
                });

        // Car image loading
        Picasso.get()
                .load(CAR_IMAGE_URL)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background)
                .into(imgCar, new Callback() {
                    @Override
                    public void onSuccess() {
                        Animation slideRight = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_right);
                        imgCar.startAnimation(slideRight);
                    }

                    @Override
                    public void onError(Exception e) {
                        Log.e("MainActivity", "Car image loading error: " + e.getMessage());
                        Toaster.error(MainActivity.this, "Failed to load car image");
                    }
                });
    }
}