package com.uca.gui;

import com.uca.core.GomAttrCore;
import com.uca.entity.GomAttrEntity;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.util.ArrayList;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class GomAttrGUI {
    public static String getAllGomE(String id_eleve, int etat) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();
        input.put("gomE", GomAttrCore.getAllGomE(id_eleve));
        input.put("etats", etat);
        Writer output = new StringWriter();
        Template template = configuration.getTemplate("/users/gomE.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    public static String getAllGomE(int etat) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();
        //ArrayList<Integer> id_check = new ArrayList<>();
        //id_check.add(etat);
        Map<String, Object> input = new HashMap<>();
        input.put("gomE", GomAttrCore.getAllGomE());
        input.put("etats", etat);
        

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("/users/gomE.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
}
