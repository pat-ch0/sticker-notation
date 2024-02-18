package com.uca.entity;
import com.uca.entity.EleveEntity;
import java.util.ArrayList;

public class ClasseEntity {
    String nom_classe;
    ArrayList<EleveEntity> listEleve;

    public ClasseEntity(){
        //
    }

    public String getName(){
        return this.nom_classe;
    }

    public ArrayList<EleveEntity> getList(){
        return this.listEleve;
    }

    public void setName(String n){
        this.nom_classe = n;
    }

    public void setListEleve(ArrayList<EleveEntity> l){
        this.listEleve = l;
    }
}
