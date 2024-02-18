package com.uca.entity;
import java.util.ArrayList;
public class EleveEntity{

    private int id_eleve;
    private String nom_eleve;
    private String prenom_eleve;

    public EleveEntity(){
        //
    }

    public int getId(){
        return this.id_eleve;
    }

    public String getNom(){
        return this.nom_eleve;
    }

    public String getPrenom(){
        return this.prenom_eleve;
    }

    public void setId(int i){
        this.id_eleve = i;
    }

    public void setNom(String n){
        this.nom_eleve = n;
    }

    public void setPrenom(String p){
        this.prenom_eleve = p;
    }

    @Override
    public String toString(){
        return "| ID : "+this.id_eleve+" | NOM : "+this.nom_eleve+" | PRENOM : "+this.prenom_eleve+" |";
    }

}