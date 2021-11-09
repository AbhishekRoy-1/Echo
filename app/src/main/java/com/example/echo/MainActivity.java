package com.example.echo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private MediaPlayer mediaPlayer;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       button = findViewById(R.id.Button);
        SeekBar seekBar = findViewById(R.id.seekBar);

        mediaPlayer = MediaPlayer.create(this,R.raw.runaway);
        button.setOnClickListener(v -> {
            if(mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                button.setText("PLay");
            }
            else{
                mediaPlayer.start();
                button.setText("Pause");
            }

        });

        final int progress = seekBar.getProgress();
        seekBar.setProgress(progress);
        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (fromUser)
                {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}