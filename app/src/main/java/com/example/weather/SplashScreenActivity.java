package com.example.weather;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
public class SplashScreenActivity extends AppCompatActivity {

    private static final int SPLASH_DURATION = 30000; // Duration in milliseconds
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        VideoView videoView = findViewById(R.id.videoView);
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splashscreen_video);
        videoView.setVideoURI(videoUri);
        videoView.setOnPreparedListener(mp -> {
            mp.setLooping(true);
            mp.start();
        });
        new Handler().postDelayed(() -> {
            startMainActivity();
        }, SPLASH_DURATION);
    }
    private void startMainActivity() {
        Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
