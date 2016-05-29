package com.astonlille.pierre.chuutthebaby;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;

/**
 * Created by Pierre on 23/05/2016.
 */
public class enregistrer extends MainActivity {
    MediaRecorder recorder;
    MediaPlayer player;
    String LOG_TAG = "enregistrer";
    private String fileRecord = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enregistrer);
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        recorder.setOutputFile(fileRecord);
    }


    public void startRecording(View view) {

        try {
            recorder.prepare();
            recorder.start();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }
    }

    public void stopRecording(View view) {
        recorder.stop();
        recorder.release();
        recorder = null ;
    }

    public void startPlaying(View view) {
        MediaPlayer player = new MediaPlayer();
        try {
            player.setDataSource(fileRecord);
            player.prepare();
            player.start();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }
    }

    public void stopPlaying(View view){
        player.stop();
    }
}
