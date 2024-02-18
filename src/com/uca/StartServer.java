package com.uca;

import com.uca.dao._Initializer;
import com.uca.entity.*;
import com.uca.gui.*;
import com.uca.dao.*;
import com.uca.core.*;

import static spark.Spark.*;
import javax.servlet.MultipartConfigElement;
import java.sql.*;

import java.util.Calendar;

public class StartServer {

    public static void main(String[] args) {
        //Configure Spark
        staticFiles.location("/static/");
        port(8081);

        _Initializer.Init();



        //Defining our routes
        get("/", (req, res) -> {
            res.redirect("/login");
            return "";
        });

        get("/login", (req, res) -> {
            String n =  (String)req.session().attribute("id");
            if((n == null)||(Integer.valueOf(n) == 0)){
                return logGUI.getLogT("");
            }
            else if((Integer.valueOf(n) == -1)){
                return logGUI.getLogT("miss");
            }
            else{
                res.redirect("/home2");
                return "";
            }
        });

        get("/home2", (req, res) -> {
            return logGUI.getButtons();
        });

        post("/login", (req, res) ->{
            req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
            String Username = new String(req.raw().getPart("Username").getInputStream().readAllBytes());
            String Password = new String(req.raw().getPart("Password").getInputStream().readAllBytes());
            ProfEntity c = logGUI.verif(Username, Password);
            req.session(true);
            req.session().attribute("id", String.valueOf(c.getId()));
            req.session().attribute("nom", c.getNom());
            res.redirect("/login");
            return"";
            
        });

        post("/login/invite", (req, res) ->{
            req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
            req.session(true);
            req.session().attribute("id", String.valueOf(0));
            res.redirect("/home1");
            return"";
        });
    
        get("/home1", (req, res) -> {
            return inviteGUI.getButtons();
        });

        get("/eleves", (req, res) -> {
            String n =  (String)req.session().attribute("id");
            if(n == null){
                n = "-2";
            }
            return EleveGUI.getAllEleves(Integer.valueOf(n));
        });

        get("/eleves/:id/delete", (req, res) -> {
            String n =  (String)req.session().attribute("id");
            if((n == null)||(Integer.valueOf(n) == -1)||(Integer.valueOf(n) == 0)){
                return "Permission Denied !";
            }
            else{
                EleveEntity e = new EleveEntity();
                e.setId(Integer.parseInt(req.params(":id")));
                EleveGUI.delete(e);
                res.redirect("/eleves");
                return "Eleve supprime(e).";
            }
        });

        post("/eleves", (req, res) ->{
            req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
            String Nom = new String(req.raw().getPart("LastName").getInputStream().readAllBytes());
            String Prenom = new String(req.raw().getPart("FirstName").getInputStream().readAllBytes());
            EleveEntity e = new EleveEntity();
            e.setNom(Nom);
            e.setPrenom(Prenom);
            EleveGUI.create(e);
            res.redirect("/eleves");
            return "";
        });

        post("/eleves/edit", (req, res) ->{
            req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
            String Id = new String(req.raw().getPart("Id").getInputStream().readAllBytes());
            String Nom = new String(req.raw().getPart("NLastName").getInputStream().readAllBytes());
            String Prenom = new String(req.raw().getPart("NFirstName").getInputStream().readAllBytes());
            EleveEntity e = new EleveEntity();
            e.setId(Integer.valueOf(Id));
            e.setNom(Nom);
            e.setPrenom(Prenom);
            EleveGUI.modify(e);
            res.redirect("/eleves");
            return "";
        });

        get("/goms", (req, res) -> {
            String n =  (String)req.session().attribute("id");
            if(n == null){
                n = "-2";
            }
            return GomGUI.getAllGoms(Integer.valueOf(n));
        });

        get("/goms/:id/delete", (req, res) -> {
            GomEntity e = new GomEntity();
            e.setId(Integer.parseInt(req.params(":id")));
            GomGUI.delete(e);
            res.redirect("/goms");
            return"";
        });

        post("/goms", (req, res) ->{
            req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
            String c = new String(req.raw().getPart("Color").getInputStream().readAllBytes());
            String d = new String(req.raw().getPart("Desc").getInputStream().readAllBytes());
            GomEntity e = new GomEntity();
            e.setCouleur(c);
            e.setDesc(d);
            GomGUI.create(e);
            res.redirect("/goms");
            return null;
        });
        

        post("/goms/edit", (req, res) ->{
            req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
            String Id = new String(req.raw().getPart("Id").getInputStream().readAllBytes());
            String Couleur = new String(req.raw().getPart("NColor").getInputStream().readAllBytes());
            String Desc = new String(req.raw().getPart("NDesc").getInputStream().readAllBytes());
            GomEntity e = new GomEntity();
            e.setId(Integer.valueOf(Id));
            e.setCouleur(Couleur);
            e.setDesc(Desc);
            GomGUI.modify(e);
            res.redirect("/goms");
            return "";
        });

        get("/eleves/:id/goms", (req, res) -> {
            String s = req.params(":id");
            String n =  (String)req.session().attribute("id");
            if(n == null){
                n = "-2";
            }
            return GomAttrGUI.getAllGomE(s, Integer.valueOf(n));
        });

        get("/eleves/goms", (req, res) -> {
            String n =  (String)req.session().attribute("id");
            if(n == null){
                n = "-2";
            }
            return GomAttrGUI.getAllGomE(Integer.valueOf(n));
        });


        post("/eleves/goms/add", (req, res) ->{
            req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
            String Id_Eleve = new String(req.raw().getPart("IdEleve").getInputStream().readAllBytes());
            String Id_Gom = new String(req.raw().getPart("IdGom").getInputStream().readAllBytes());
            String Raison = new String(req.raw().getPart("Raison").getInputStream().readAllBytes());
            java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
            GomAttrEntity e = new GomAttrEntity();
            e.setEleveId(Integer.valueOf(Id_Eleve));
            e.setProfId(Integer.valueOf(req.session().attribute("id")));
            e.setNomProf((String)req.session().attribute("nom"));
            e.setGomId(Integer.valueOf(Id_Gom));
            e.setRaison(Raison);
            e.setDate(sqlDate);
            GomAttrCore.create(e);
            res.redirect("/eleves/goms");
            return "";

        });

        get("/eleves/goms/:id/delete", (req, res) -> {
            String n =  (String)req.session().attribute("id");
            if((n == null)||(Integer.valueOf(n) == -1)||(Integer.valueOf(n) == 0)){
                return "Permission Denied !";
            }
            else{
                String s = req.params(":id");
                GomAttrEntity g = new GomAttrEntity();
                g.setId(Integer.valueOf(s));
                GomAttrCore.delete(g);
                res.redirect("/eleves/goms");
                return "";
            }
        });

        post("/disconnect", (req, res) -> {
            req.session().attribute("id", null);
            req.session().attribute("nom", null);
            res.redirect("/login");
            return"";
        });
        
    }
}