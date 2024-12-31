/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tap_u1t2;

import com.mycompany.tap_u1t2.Views.Spotify;
import java.io.IOException;
import javax.sound.sampled.*;

/**
 *
 * @author angel
 */
public class TAP_U1T2 {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        Spotify spotify = new Spotify();
        spotify.setLocationRelativeTo(null);
        spotify.setVisible(true);
    }
}
