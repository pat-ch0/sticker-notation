package com.uca.gui;

import com.uca.core.logCore;
import com.uca.entity.ProfEntity;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class logGUI {

    public static String getLogT(String e) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();
        Writer output = new StringWriter();
        ArrayList<String> message = new ArrayList<>();
        Template template = configuration.getTemplate("/users/login.ftl");
        template.setOutputEncoding("UTF-8");
        Map<String, Object> input = new HashMap<>();
        if(e.equals("miss")){
            message.add("Veuillez saisir un nom de d'utilisateur et un mot de passe valide.");
            input.put("msgs", message);
        }
        else{
            message.add("");
            input.put("msgs", message);
        }
        template.process(input, output);
        return output.toString();
    }

    public static String getButtons() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();
        Writer output = new StringWriter();
        Template template = configuration.getTemplate("/users/home2.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(null, output);
        return output.toString();
    }


    public static ProfEntity verif(String u, String p) throws IOException, TemplateException {
        return logCore.verif(u, p);
    }
}
