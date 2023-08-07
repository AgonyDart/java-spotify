/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tap_u1t2;


import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.*;
import javax.swing.JProgressBar;

/**
 *
 * @author angel
 */
public class MusicPlayer {
    private boolean isPlaying = false;
    private Timer timer;
    private TimerTask task;

    public void soundTest(File songToPlay) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(songToPlay);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }
    
    public void togglePlay(Clip song, JProgressBar bar) throws UnsupportedAudioFileException, IOException, LineUnavailableException, LineUnavailableException{
        if (isPlaying) {
            stopBar();
            song.stop();
        } else {
            resetBar();
            startBar(song, bar);
            song.start();
        }
        isPlaying = !isPlaying;
    }
    
    public void resetSong(Clip song) {
        resetBar();
        song.setMicrosecondPosition(0);
    }
    
    public void resetSongWithBar(Clip song, JProgressBar bar) {
        resetBar();
        song.setMicrosecondPosition(0);
        startBar(song, bar);
    }
    
    public String startBar(Clip song, JProgressBar bar) {
        int TO_SECONDS_INT = 1000000;
        String ended = "";
        timer = new Timer();
        task = new TimerTask() {
            public void run() {
                int current = (int)(song.getMicrosecondPosition() / TO_SECONDS_INT);
                int end = (int)(song.getMicrosecondLength() / TO_SECONDS_INT);
                bar.setMaximum(end);
                bar.setValue(current);
                String ended = (end == current) ? "y" : "n";
//                System.out.println(ended);
            }
        };
        timer.scheduleAtFixedRate(task, 1000,1000);
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

}
