package com.uca.gui;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class inviteGUI {
    
    public static String getButtons() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();
        Writer output = new StringWriter();
        Template template = configuration.getTemplate("/users/home1.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(null, output);
        return output.toString();
    }


}
