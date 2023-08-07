/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tap_u1t2;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author angel
 */
public class Song {
    
    private String pathname = "";
    private String title = "";
    private String artist = "";
    private String imagePath = "";
//    private long duration = 0;
    private File wav;
    private File png = new File(imagePath);
    private Clip clip;

    public Song(String title, String artist, String pathname) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.title = title;
        this.artist = artist;
        this.pathname = pathname;
        this.wav = new File(pathname);
        this.clip = fileToClip(this.wav);
//        this.duration = this.clip.getMicrosecondLength();
    }

    public static Clip fileToClip(File songToPlay) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(songToPlay);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        return clip;
    }
    
    
    public String getPathname() {
        return pathname;
    }

    public void setPathname(String pathname) {
        this.pathname = pathname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
    
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

//    public long getDuration() {
//        return duration;
//    }
//
//    public void setDuration(int duration) {
//        this.duration = duration;
//    }
    
    public File getWav() {
        return wav;
    }

    public void setWav(File wav) {
        this.wav = wav;
    }

    public File getPng() {
        return png;
    }

    public void setPng(File png) {
        this.png = png;
    }

    public Clip getClip() {
        return clip;
    }

    public void setClip(Clip clip) {
        this.clip = clip;
    }
}
