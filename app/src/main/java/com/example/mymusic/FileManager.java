package com.example.mymusic;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileManager {

    public FileManager(){
    }

    public ArrayList<Song> readFile(String fileName, Context c){
        try {
            //InputStreamReader trasforma i byte letti dal file (aperto tramite il metodo del Context openFileInput) in caratteri leggibili
            BufferedReader reader = new BufferedReader(new InputStreamReader(c.getAssets().open(fileName)));
            ArrayList<Song> songs = new ArrayList<Song>();
            String line="";
            while((line=reader.readLine())!= null) {
                String[] songData = line.split(";");
                songs.add(new Song(songData[0], songData[1], songData[2], songData[3], songData[4]));
            }
            return songs;
        } catch (FileNotFoundException e) {
            Log.e("FileNotFoundException", e.toString());
        } catch (IOException e) {
            Log.e("IOException", e.toString());
        }
        ArrayList<Song> songs = new ArrayList<Song>();
        return songs;
    }
}
