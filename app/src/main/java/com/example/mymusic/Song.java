package com.example.mymusic;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Song implements Serializable {
    private String title;
    private String author;
    private String duration;
    private String genre;
    private LocalDate publicationDate;

    public Song(String t, String a, String d, String g, String dP){
        title=t;
        author=a;
        duration=d;
        genre=g;
        //Converting the String of the date to a LocalDate object using a specific pattern
        publicationDate = LocalDate.parse(dP);
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getDuration() { return duration; }
    public String getGenre(){
        return genre;
    }
    public LocalDate getPublicationDate(){
        return publicationDate;
    }
    @Override
    public String toString(){
        //Concatenation of all the attributes of the object and returning as a String
        return "Song title: "+title+"\n\nAuthor: "+author+"\n\nDuration: "+duration+"\n\nGenre: "+genre+"\n\nPublication date: "+publicationDate.toString();
    }
}
