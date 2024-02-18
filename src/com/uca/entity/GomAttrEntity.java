package com.uca.entity;

import java.sql.Date;
public class GomAttrEntity {
    private int id;
    private int id_eleve;
    private String nom_eleve;
    private String prenom_eleve;
    private int id_prof;
    private String nom_prof;
    private String raison;
    private String desc;
    private String couleur;
    private int id_gom;
    private Date date;

    public GomAttrEntity(){
        //
    }

    public String getCouleur(){
        return this.couleur;
    }

    public void setCouleur(String c){
        this.couleur = c;
    }

    public String getDesc(){
        return this.desc;
    }

    public void setDesc(String n){
        this.desc = n;
    }

    public String getNomEleve(){
        return this.nom_eleve;
    }

    public void setNomEleve(String n){
        this.nom_eleve = n;
    }

    public void setPrenomEleve(String n){
        this.prenom_eleve = n;
    }

    public void setNomProf(String n){
        this.nom_prof = n;
    }

    public String getPrenomEleve(){
        return this.prenom_eleve;
    }

    public String getNomProf(){
        return this.nom_prof;
    }


    public int getId(){
        return this.id;
    }

    public int getEleveId(){
        return this.id_eleve;
    }

    public int getProfId(){
        return this.id_prof;
    }

    public int getGomId(){
        return this.id_gom;
    }

    public String getRaison(){
        return this.raison;
    }


    public void setId(int i){
        this.id = i;
    }

    public void setEleveId(int i){
        this.id_eleve = i;
    }

    public void setProfId(int i){
        this.id_prof = i;
    }

    public void setGomId(int i){
        this.id_gom = i;
    }

    public void setRaison(String c){
        this.raison = c;
    }

    public Date getDate(){
        return this.date;
    }

    public void setDate(Date d){
        this.date = d;
    }

    @Override
    public String toString(){
        return "| ID : "+this.id + " | Donnee par "+this.nom_prof+" à " + this.nom_eleve +" " + this.prenom_eleve + " | Couleur : " + this.couleur +" | Description : " + this.desc + " | Raison : " + this.raison + " | Date : "+this.date+" |";
    }
}
