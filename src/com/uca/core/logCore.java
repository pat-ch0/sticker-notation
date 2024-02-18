package com.uca.core;

import com.uca.dao.logDAO;
import com.uca.entity.ProfEntity;

import java.util.ArrayList;

public class logCore {
    
    public static ProfEntity verif(String u, String p) {
        return new logDAO().verif(u,p);
    }

    public static String convert(String n){
        if(n != null){
            System.out.println(n.length());
            for(int i = 0; i < n.length(); i++){
                System.out.println(n.charAt(i));
            }
            System.out.println("TEST POUR REMI compareto : " + (n.compareTo("-1")));
        }
        System.out.println("TEST POUR REMI : " + (n == "-1"));
        return n;

    }

}
