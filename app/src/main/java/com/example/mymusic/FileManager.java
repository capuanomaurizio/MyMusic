package com.example.mymusic;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FileManager {

    public FileManager(){
    }

    public void firstWriting(String fileName, Context c){
        boolean redFlag=false;
        BufferedReader toReadFrom = null;
        try {
            //if songs.txt exists set the redFlag
            toReadFrom = new BufferedReader(new InputStreamReader(c.openFileInput("songs.txt")));
            redFlag = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //if redFlag is true do NOT write the file
        if(!redFlag){
            try {
                //InputStreamReader trasforma i byte letti dal file (aperto tramite il metodo del Context openFileInput) in caratteri leggibili
                toReadFrom = new BufferedReader(new InputStreamReader(c.getAssets().open(fileName)));
                FileOutputStream toWriteTo = c.openFileOutput(fileName, Context.MODE_APPEND);
                String line="";
                while((line=toReadFrom.readLine())!= null) {
                    line+="\n";
                    toWriteTo.write(line.getBytes());
                }
                toWriteTo.close();
            } catch (FileNotFoundException e) {
                Log.e("FileNotFoundException", e.toString());
            } catch (IOException e) {
                Log.e("IOException", e.toString());
            }
        }
    }

    public ArrayList<Song> readFile(String fileName, Context c){
        try {
            //InputStreamReader trasforma i byte letti dal file (aperto tramite il metodo del Context openFileInput) in caratteri leggibili
            BufferedReader reader = new BufferedReader(new InputStreamReader(c.openFileInput(fileName)));
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

    public void writeNewSong(String fileName, String songDetails, Context c){
        try {
            FileOutputStream file;
            file = c.openFileOutput(fileName, Context.MODE_APPEND);
            file.write(songDetails.getBytes());
            file.close();
        } catch (FileNotFoundException e) {
            Log.e("FileNotFoundException", e.toString());
        } catch (IOException e) {
            Log.e("IOException", e.toString());
        }
    }
}
