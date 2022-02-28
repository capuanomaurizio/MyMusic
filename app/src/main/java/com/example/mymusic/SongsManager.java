package com.example.mymusic;

import android.content.Context;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class SongsManager implements Serializable {
    private ArrayList<Song> songs;

    public SongsManager(){
        songs = new ArrayList<Song>();
    }
    public ArrayList<Song> getBrani(){
        return songs;
    }
    public  ArrayList<String> getTitles(){
        ArrayList<String> titles= new ArrayList<>();
        for (Song song : songs) {
            titles.add(song.getTitle());
        }
        return titles;
    }
    public void addBrano(Song b){
        songs.add(b);
    }
    public void populateSongs(String fileName, Context c){
        FileManager fm = new FileManager();
        songs = fm.readFile(fileName, c);
    }
    public String listBrani(){
        //Declaration and instance of the StringBuilder object
        StringBuilder sb = new StringBuilder();
        //For each Song in songsList
        for(Song b : songs){
            //Appending the information of the Song to the whole built string of the list
            sb.append(b.toString()+"\n\n");
        }
        //Returning the String obtained from the StringBuilder
        return sb.toString();
    }
}
