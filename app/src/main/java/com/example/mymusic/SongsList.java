package com.example.mymusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongsList extends AppCompatActivity {

    //Declaration of graphical objects
    ListView lsvwSongs;
    SongsManager gb;
    final String TAG = "AddSong Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_list);
        gb = (SongsManager)getIntent().getSerializableExtra("manager");

        //Instance of graphical objects
        lsvwSongs=(ListView)findViewById(R.id.lsvwSongs);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, gb.getTitles());
        lsvwSongs.setAdapter(adapter);
        lsvwSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), SongDetails.class);
                i.putExtra("songTitle", (String)lsvwSongs.getItemAtPosition(position));
                i.putExtra("manager", gb);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Currently onResuming "+TAG);
    }
}