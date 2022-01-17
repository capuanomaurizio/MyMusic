package com.example.mymusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddSong extends AppCompatActivity {

    Button btnAddSong;
    Button btnSongsList;
    EditText edtSongName;
    EditText edtSongAuthor;
    Spinner spnSongGenre;
    EditText edtPublishDate;
    GestoreBrani gb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_song);
        btnAddSong = (Button)findViewById(R.id.btnAddSong);
        btnSongsList = (Button)findViewById(R.id.btnSongsList);
        edtSongName = (EditText)findViewById(R.id.edtSongName);
        edtSongAuthor = (EditText)findViewById(R.id.edtSongAuthor);
        spnSongGenre = (Spinner)findViewById(R.id.spnSongGenre);
        edtPublishDate = (EditText)findViewById(R.id.edtPublishDate);
        gb = new GestoreBrani();

        btnAddSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Brano b = new Brano(edtSongName.getText().toString(), edtSongAuthor.getText().toString(),
                        spnSongGenre.getSelectedItem().toString(), edtPublishDate.getText().toString());
                gb.addBrano(b);
                Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_SHORT).show();
                Log.d("brano", b.toString());
            }
        });

        btnSongsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SongsList.class);
                i.putExtra("gestore", gb);
                startActivity(i);
            }
        });
    }
}