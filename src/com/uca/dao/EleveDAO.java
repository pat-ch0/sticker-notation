package com.uca.dao;
import com.uca.entity.EleveEntity;

import java.sql.*;
import java.util.ArrayList;

public class EleveDAO extends _Generic<EleveEntity> {

    public ArrayList<EleveEntity> getAllEleves() {
        ArrayList<EleveEntity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM eleves ORDER BY id_eleve ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                EleveEntity entity = new EleveEntity();
                entity.setId(resultSet.getInt("id_eleve"));
                entity.setNom(resultSet.getString("nom_eleve"));
                entity.setPrenom(resultSet.getString("prenom_eleve"));
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    public EleveEntity modify(EleveEntity obj) {
        try {
            //PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE eleves SET nom_eleve = "+"'"+obj.getNom()+"'"+", prenom_eleve = "+"'"+obj.getPrenom()+"'"+" WHERE id_eleve = "+obj.getId()+" ;");
            PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE eleves SET nom_eleve = ? , prenom_eleve = ? WHERE id_eleve = ? ;");
            preparedStatement.setString(1, obj.getNom());
            preparedStatement.setString(2, obj.getPrenom());
            preparedStatement.setInt(3, obj.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public EleveEntity create(EleveEntity obj) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT INTO eleves (nom_eleve, prenom_eleve) VALUES (?,?);");
            preparedStatement.setString(1, obj.getNom());
            preparedStatement.setString(2, obj.getPrenom());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(EleveEntity obj) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("DELETE FROM gomatt WHERE id_eleve = " + String.valueOf(obj.getId()));
            preparedStatement.executeUpdate();
            preparedStatement = this.connect.prepareStatement("DELETE FROM eleves WHERE id_eleve = " + String.valueOf(obj.getId()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
