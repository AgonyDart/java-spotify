/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tap_u1t2.Models;

import java.util.ArrayList;

/**
 *
 * @author angeld
 */
public class Playlist {
  public ArrayList<Song> songs = new ArrayList<Song>();
  private String name = "default name";

  public Playlist(String name) {
    this.name = name;
  }

  public Playlist(String name, ArrayList<Song> songs) {
    this.name = name;
    this.songs = songs;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ArrayList<Song> getSongs() {
    return songs;
  }

  public Song[] getSongsArray() {
    Song[] songsArray = new Song[this.songs.size()];
    for (int i = 0; i < this.songs.size(); i++) {
      songsArray[i] = this.songs.get(i);
    }
    return songsArray;
  }

  public void setSongs(ArrayList<Song> songs) {
    this.songs = songs;
  }

  public void addSong(Song song) {
    this.songs.add(song);
  }

  public void removeSong(String title) {
    for (int i = 0; i < this.songs.size(); i++) {
      if (this.songs.get(i).getTitle().equals(title)) {
        this.songs.remove(i);
        break;
      }
    }
  }
}
