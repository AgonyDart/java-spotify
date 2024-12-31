/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tap_u1t2.Controllers;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.*;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author angel
 */
public class SongManager {
    private boolean isPlaying = false;
    private Timer timer;
    private TimerTask task;

    public void soundTest(File songToPlay) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(songToPlay);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }

    public void togglePlay(Clip song, JProgressBar bar, JLabel label)
            throws UnsupportedAudioFileException, IOException, LineUnavailableException, LineUnavailableException {
        if (isPlaying) {
            stopBar();
            song.stop();
        } else {
            resetBar();
            startBar(song, bar, label);
            song.start();
        }
        isPlaying = !isPlaying;
    }

    public void resetSong(Clip song) {
        resetBar();
        song.setMicrosecondPosition(0);
    }

    public void resetSongWithBar(Clip song, JProgressBar bar, JLabel label) {
        resetBar();
        song.setMicrosecondPosition(0);
        startBar(song, bar, label);
    }

    public String startBar(Clip song, JProgressBar bar, JLabel label) {
        int TO_SECONDS_INT = 1000000;
        String ended = "";
        timer = new Timer();
        task = new TimerTask() {
            public void run() {
                int current = (int) (song.getMicrosecondPosition() / TO_SECONDS_INT);
                int end = (int) (song.getMicrosecondLength() / TO_SECONDS_INT);
                bar.setMaximum(end);
                bar.setValue(current);
                label.setText(getSongTime(song));
                String ended = (end == current) ? "y" : "n";
                // System.out.println(ended);
            }
        };
        timer.scheduleAtFixedRate(task, 1000, 1000);
        return ended;
    }

    private void resetBar() {
        if (timer != null) {
            timer.cancel();
            timer.purge();
        }
    }

    public void stopBar() {
        timer.cancel();
    }

    public boolean getIsPlaying() {
        return isPlaying;
    }

    public void setIsPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public String getSongTime(Clip song) {
        int TO_SECONDS_INT = 1000000;
        int current = (int) (song.getMicrosecondPosition() / TO_SECONDS_INT);
        int minutes = current / 60;
        int seconds = current % 60;
        String secondsString = (seconds < 10) ? "0" + seconds : "" + seconds;
        return minutes + ":" + secondsString;
    }
}
