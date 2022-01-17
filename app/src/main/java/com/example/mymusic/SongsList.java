package com.example.mymusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SongsList extends AppCompatActivity {

    ListView lsvwSongsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_list);
        lsvwSongsList = (ListView)findViewById(R.id.lsvwSongsList);
        GestoreBrani gb = (GestoreBrani) getIntent().getSerializableExtra("gestore");
        ArrayList<String> titoliBrani = new ArrayList<String>();
        for (Brano b : gb.getBrani()) {
            titoliBrani.add(b.getTitolo());
        }
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, titoliBrani);
        lsvwSongsList.setAdapter(itemsAdapter);
        /*lsvwSongsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), FilmActivity.class);
                i.putExtra("title", (String)lsvwList.getItemAtPosition(position));
                startActivity(i);
            }
        });*/
    }
}