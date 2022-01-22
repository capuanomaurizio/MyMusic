package com.example.mymusic;

import java.io.Serializable;
import java.util.ArrayList;

public class GestoreBrani implements Serializable {
    private ArrayList<Brano> brani;

    public GestoreBrani(){
        brani = new ArrayList<Brano>();
    }
    public ArrayList<Brano> getBrani(){
        return brani;
    }
    public void addBrano(Brano b){
        brani.add(b);
    }
    public String listBrani(){
        StringBuilder sb = new StringBuilder();
        for(Brano b : brani){
            sb.append(b.toString()+"\n\n");
        }
        return sb.toString();
    }
}
