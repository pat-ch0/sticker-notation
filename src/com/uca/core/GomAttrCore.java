package com.uca.core;

import com.uca.dao.GomAttrDAO;
import com.uca.entity.GomAttrEntity;

import java.util.ArrayList;
public class GomAttrCore {
    public static ArrayList<GomAttrEntity> getAllGomE(String id_eleve) {
        return new GomAttrDAO().getAllGomE(id_eleve);
    }
    public static ArrayList<GomAttrEntity> getAllGomE() {
        return new GomAttrDAO().getAllGomE();
    }
    public static void create(GomAttrEntity obj){
        new GomAttrDAO().create(obj);
    }

    public static void delete(GomAttrEntity obj){
        new GomAttrDAO().delete(obj);
    }
}
