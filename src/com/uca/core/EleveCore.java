package com.uca.core;

import com.uca.dao.EleveDAO;
import com.uca.entity.EleveEntity;

import java.util.ArrayList;

public class EleveCore {

    public static ArrayList<EleveEntity> getAllEleves() {
        return new EleveDAO().getAllEleves();
    }

    public static void delete(EleveEntity obj){
        new EleveDAO().delete(obj);
    }

    public static void create(EleveEntity obj){
        new EleveDAO().create(obj);
    }

    public static void modify(EleveEntity obj){
        new EleveDAO().modify(obj);
    }

}