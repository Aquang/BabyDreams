package com.astonlille.pierre.chuutthebaby;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.util.Log;
import android.view.View;

import java.io.IOException;

/**
 * Created by Pierre on 23/05/2016.
 */
public class enregistrer extends MainActivity {

    MediaRecorder recorder;
    MediaPlayer player;
    String LOG_TAG = "enregistrer";
    String fileRecord = null;

    public void startRecording(View view) {
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setOutputFile(fileRecord);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            recorder.prepare();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }

        recorder.start();
    }

    public void stopRecording(View view) {
        recorder.stop();
    }

    public void startPlaying(View view) {
        player = new MediaPlayer();
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
