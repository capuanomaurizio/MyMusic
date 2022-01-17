package com.example.mymusic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Brano {
    private String titolo;
    private String autore;
    private String genere;
    private LocalDate dataPubblicazione;

    public Brano(String t, String a, String g, String d){
        titolo=t;
        autore=a;
        genere=g;
        dataPubblicazione = LocalDate.parse(d, DateTimeFormatter.ofPattern("d/MM/yyyy"));
    }
    public String getTitolo(){
        return titolo;
    }
    public String getAutore(){
        return autore;
    }
    public String getGenere(){
        return genere;
    }
    public LocalDate getDataPubblicazione(){
        return dataPubblicazione;
    }
    @Override
    public String toString(){
        return titolo+" "+autore+" "+genere+" "+dataPubblicazione.toString();
    }
}
