package com.example.mymusic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SongDetails extends AppCompatActivity {

    TextView lblTitle, lblDetails;
    ImageView imgImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);
        lblTitle = (TextView) findViewById(R.id.lblTitle);
        lblDetails = (TextView) findViewById(R.id.lblDetails);
        imgImage = (ImageView)findViewById(R.id.imgImage);
        imgImage.setImageResource(R.drawable.track);

        String title = getIntent().getStringExtra("songTitle");
        lblTitle.setText(title);

        SongsManager gb = (SongsManager)getIntent().getSerializableExtra("manager");
        ArrayList<Song> songs = gb.getBrani();
        Song chosenSong;
        boolean b = false;
        int i=0;
        while(i<songs.size() && b==false){
            if(songs.get(i).getTitle().equals(title)) {
                chosenSong = songs.get(i);
                lblDetails.setText(chosenSong.toString());
                b = true;
            }
            i++;
        }
    }
}