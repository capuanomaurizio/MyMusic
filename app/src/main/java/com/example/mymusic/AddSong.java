package com.example.mymusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddSong extends AppCompatActivity {
    //Declaration of graphical elements
    Button btnAddSong;
    Button btnSongsList;
    EditText edtSongName;
    EditText edtSongAuthor;
    EditText edtSongDuration;
    Spinner spnSongGenre;
    EditText edtPublishDate;
    SongsManager sm;
    final String TAG = "AddSong Activity";

    //Genres array
    String[] generi = {"Pop", "Rock", "Reggae", "Rap", "Classica"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_song);
        //Instance of graphical elements
        btnAddSong = (Button)findViewById(R.id.btnAddSong);
        btnSongsList = (Button)findViewById(R.id.btnSongsList);
        edtSongName = (EditText)findViewById(R.id.edtSongName);
        edtSongAuthor = (EditText)findViewById(R.id.edtSongAuthor);
        edtSongDuration = (EditText)findViewById(R.id.edtSongDuration);
        spnSongGenre = (Spinner)findViewById(R.id.spnSongGenre);
        edtPublishDate = (EditText)findViewById(R.id.edtPublishDate);

        //Instance of the song manager
        sm = new SongsManager();
        sm.populateSongs("songs.txt", getApplicationContext());
        sm.firstWriting("songs.txt", getApplicationContext());

        //Creating ArrayAdapter to populate the genres spinner
        ArrayAdapter<String> adattatoreGeneri = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, generi);
        spnSongGenre.setAdapter(adattatoreGeneri);

        //Setting onClickListener that creates the Song object and adds it to the ArrayList of the song manager
        btnAddSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Song b = new Song(edtSongName.getText().toString(), edtSongAuthor.getText().toString(), edtSongDuration.getText().toString(),
                        spnSongGenre.getSelectedItem().toString(), edtPublishDate.getText().toString());
                sm.addBrano(b);
                sm.writeNewSong("songs.txt", b.toFileString(), getApplicationContext());
                //Message toast
                Toast.makeText(getApplicationContext(), "Song added", Toast.LENGTH_SHORT).show();
                //Showing the object information in the debug log
                Log.d("Song created", b.toString());
            }
        });
        //Setting onClickListener that switches to the other activity and passes the list of songs' information
        btnSongsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SongsList.class);
                i.putExtra("manager", sm);
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