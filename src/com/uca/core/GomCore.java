package com.uca.core;

import com.uca.dao.GomDAO;
import com.uca.entity.GomEntity;

import java.util.ArrayList;

public class GomCore {

    public static ArrayList<GomEntity> getAllGoms() {
        return new GomDAO().getAllGoms();
    }

    public static void delete(GomEntity obj){
        new GomDAO().delete(obj);
    }

    public static void create(GomEntity obj){
        new GomDAO().create(obj);
    }

    public static void modify(GomEntity obj){
        new GomDAO().modify(obj);
    }

}
