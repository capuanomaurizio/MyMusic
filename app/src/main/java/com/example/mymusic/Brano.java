package com.example.mymusic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Brano {
    private String titolo;
    private String autore;
    private String durata;
    private String genere;
    private LocalDate dataPubblicazione;

    public Brano(String t, String a, String d, String g, String dP){
        titolo=t;
        autore=a;
        durata=d;
        genere=g;
        dataPubblicazione = LocalDate.parse(dP, DateTimeFormatter.ofPattern("d/MM/yyyy"));
    }
    public String getTitolo(){
        return titolo;
    }
    public String getAutore(){
        return autore;
    }
    public String getDurata() { return durata; }
    public String getGenere(){
        return genere;
    }
    public LocalDate getDataPubblicazione(){
        return dataPubblicazione;
    }
    @Override
    public String toString(){
        return "Song title: "+titolo+" Author: "+autore+" Duration: "+durata+" Genre: "+genere+" Publication date: "+dataPubblicazione.toString();
    }
}
