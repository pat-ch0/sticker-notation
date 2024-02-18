package com.uca.entity;

public class GomEntity {
    private int id_gom;
    private String couleur;
    private String description;


    public GomEntity(){
        //
    }

    public int getId(){
        return this.id_gom;
    }

    public String getCouleur(){
        return this.couleur;
    }

    public String getDesc(){
        return this.description;
    }

    public void setId(int i){
        this.id_gom = i;
    }

    public void setCouleur(String c){
        this.couleur = c;
    }

    public void setDesc(String c){
        this.description = c;
    }

    @Override
    public String toString(){
        return "| ID : "+this.id_gom+" | COULEUR : "+this.couleur+" | DESCRIPTION : "+this.description+" |";
    }
}
