package com.uca.dao;

import java.sql.*;
import java.util.Calendar;

public class _Initializer {

    public static void Init(){
        Connection connection = _Connector.getInstance();

        try {
            PreparedStatement statement;

            //Init articles table
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS eleves (id_eleve int primary key auto_increment, nom_eleve varchar(100), prenom_eleve varchar(100)); ");
            statement.executeUpdate();

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS goms (id_gom int primary key auto_increment, couleur text, desc text); ");
            statement.executeUpdate();

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS profs (id_prof int primary key auto_increment, nom_prof varchar(100), username varchar(20), password varchar(20));");
            statement.executeUpdate();

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS gomatt (id_gomatt int primary key auto_increment, id_eleve int REFERENCES eleves(id_eleve), id_prof int REFERENCES profs(id_prof), id_gom int REFERENCES goms(id_gom), date date, raison text);");
            statement.executeUpdate();

            //MDP
            
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO profs (nom_prof, username, password) VALUES ('Myrtille', 'Myrtille123', 'azer1234');");
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("INSERT INTO profs (nom_prof, username, password) VALUES ('Framboisier', 'Framboisier123', 'motdepasse');");
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("INSERT INTO eleves (nom_eleve, prenom_eleve) VALUES ('ABDUL-SALAM', 'Sami');");
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("INSERT INTO goms (couleur, desc) VALUES ('Rouge', 'Ceci est un test de description');");
            preparedStatement.executeUpdate();

            int year = 2022;
            int month = 5;
            int day = 9;
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, month - 1);
            cal.set(Calendar.DAY_OF_MONTH, day);
            java.sql.Date sqlDate = new java.sql.Date(cal.getTimeInMillis());

            preparedStatement = connection.prepareStatement("INSERT INTO gomatt (id_eleve, id_prof, id_gom, date, raison) VALUES (1, 1, 1, ?, 'Ceci est un test de raison.');");
            preparedStatement.setDate(1, sqlDate);
            preparedStatement.executeUpdate();

        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not create database !");
        }
    }
}
