package com.uca.gui;

import com.uca.core.GomCore;
import com.uca.entity.GomEntity;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class GomGUI {

    public static String getAllGoms(Integer etat) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();
        input.put("goms", GomCore.getAllGoms());
        input.put("etats", etat);
        Writer output = new StringWriter();
        Template template = configuration.getTemplate("/users/goms.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
    
    public static String delete(GomEntity obj) throws IOException, TemplateException {
        GomCore.delete(obj);
        return "done.";
    }

    public static String create(GomEntity obj) throws IOException, TemplateException {
        GomCore.create(obj);
        return "done.";
    }

    public static String modify(GomEntity obj) throws IOException, TemplateException {
        GomCore.modify(obj);
        return "";
    }
}
