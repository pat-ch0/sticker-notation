package com.uca.dao;
import com.uca.entity.GomAttrEntity;
import java.sql.*;
import java.util.ArrayList;

public class GomAttrDAO extends _Generic<GomAttrEntity>{
    public ArrayList<GomAttrEntity> getAllGomE(String id_eleve) {
        ArrayList<GomAttrEntity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT id_gomatt, nom_prof, nom_eleve, prenom_eleve, date, gomatt.raison, couleur, desc FROM gomatt INNER JOIN eleves ON gomatt.id_eleve = eleves.id_eleve INNER JOIN profs ON gomatt.id_prof = profs.id_prof INNER JOIN goms ON gomatt.id_gom = goms.id_gom  WHERE gomatt.id_eleve = " + id_eleve + " ;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                GomAttrEntity entity = new GomAttrEntity();
                entity.setId(resultSet.getInt("id_gomatt"));
                entity.setNomEleve(resultSet.getString("nom_eleve"));
                entity.setNomProf(resultSet.getString("nom_prof"));
                entity.setPrenomEleve(resultSet.getString("prenom_eleve"));
                entity.setDesc(resultSet.getString("desc"));
                entity.setCouleur(resultSet.getString("couleur"));
                entity.setRaison(resultSet.getString("raison"));
                entity.setDate(resultSet.getDate("date"));
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    public ArrayList<GomAttrEntity> getAllGomE() {
        ArrayList<GomAttrEntity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT id_gomatt, nom_prof, nom_eleve, prenom_eleve, date, gomatt.raison, couleur, desc FROM gomatt INNER JOIN eleves ON gomatt.id_eleve = eleves.id_eleve INNER JOIN profs ON gomatt.id_prof = profs.id_prof INNER JOIN goms ON gomatt.id_gom = goms.id_gom ORDER BY gomatt.id_eleve; ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                GomAttrEntity entity = new GomAttrEntity();
                entity.setId(resultSet.getInt("id_gomatt"));
                entity.setNomEleve(resultSet.getString("nom_eleve"));
                entity.setNomProf(resultSet.getString("nom_prof"));
                entity.setPrenomEleve(resultSet.getString("prenom_eleve"));
                entity.setDesc(resultSet.getString("desc"));
                entity.setCouleur(resultSet.getString("couleur"));
                entity.setRaison(resultSet.getString("raison"));
                entity.setDate(resultSet.getDate("date"));
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public GomAttrEntity create(GomAttrEntity obj) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT INTO gomatt (id_eleve, id_prof, id_gom, date, raison) VALUES (?,?,?,?,?);");
            preparedStatement.setInt(1, obj.getEleveId());
            preparedStatement.setInt(2, obj.getProfId());
            preparedStatement.setInt(3, obj.getGomId());
            preparedStatement.setDate(4, obj.getDate());
            preparedStatement.setString(5, obj.getRaison());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(GomAttrEntity obj) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("DELETE FROM gomatt WHERE id_gomatt = " + String.valueOf(obj.getId()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
