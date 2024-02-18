package com.uca.gui;

import com.uca.core.EleveCore;
import com.uca.entity.EleveEntity;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.util.ArrayList;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class EleveGUI {

    public static String getAllEleves(int etat) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();
       // ArrayList<Integer> id_check = new ArrayList<>();
        //id_check.add(etat);
        Map<String, Object> input = new HashMap<>();
        input.put("eleves", EleveCore.getAllEleves());
        input.put("etats", etat);
        Writer output = new StringWriter();
        Template template = configuration.getTemplate("/users/eleves.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    public static String delete(EleveEntity obj) throws IOException, TemplateException {
        EleveCore.delete(obj);
        return null;
    }

    public static String create(EleveEntity obj) throws IOException, TemplateException {
        EleveCore.create(obj);
        return null;
    }

    public static String modify(EleveEntity obj) throws IOException, TemplateException {
        EleveCore.modify(obj);
        return null;
    }
}
