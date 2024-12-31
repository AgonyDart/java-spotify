package com.mycompany.tap_u1t2.Controllers;

import com.mycompany.tap_u1t2.Models.Playlist;

import java.util.ArrayList;


public class PlaylistManager {

    private ArrayList<Playlist> playlists = new ArrayList<Playlist>();
    private Playlist currentPlaying;

    public void addPlaylist(Playlist playlist) {
        this.playlists.add(playlist);
    }

    public void removePlaylist(Playlist playlist) {
        this.playlists.remove(playlist);
    }

    public void setCurrentPlaying(Playlist playlist) {
        this.currentPlaying = playlist;
    }

    public Playlist getCurrentPlaying() {
        return this.currentPlaying;
    }

    public ArrayList<Playlist> getPlaylists() {
        return this.playlists;
    }

    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    public void removeSongFromPlaylist(Playlist playlist, String title) {
        playlist.removeSong(title);
    }
}