package com.uca.entity;
import java.sql.Timestamp;

public class ProfEntity {
    private int id_prof;
    private String nom_prof;
    private String prenom_prof;
    private String nom_classe;


    public ProfEntity(){
        //
    }

    public int getId(){
        return this.id_prof;
    }

    public String getNom(){
        return this.nom_prof;
    }

    public String getPrenom(){
        return this.prenom_prof;
    }

    public String getClasse(){
        return this.nom_classe;
    }

    public void setId(int i){
        this.id_prof = i;
    }

    public void setNom(String i){
        this.nom_prof = i;
    }

    public void setPrenom(String i){
        this.prenom_prof = i;
    }

    public void setClasse(String i){
        this.nom_classe = i;
    }
}
