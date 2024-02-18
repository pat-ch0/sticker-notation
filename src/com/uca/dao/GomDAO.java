package com.uca.dao;
import com.uca.entity.GomEntity;
import java.sql.*;
import java.util.ArrayList;

public class GomDAO extends _Generic<GomEntity> {

    public ArrayList<GomEntity> getAllGoms() {
        ArrayList<GomEntity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM goms ORDER BY id_gom ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                GomEntity entity = new GomEntity();
                entity.setId(resultSet.getInt("id_gom"));
                entity.setCouleur(resultSet.getString("couleur"));
                entity.setDesc(resultSet.getString("desc"));
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    public GomEntity modify(GomEntity obj) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE goms SET couleur = ?, desc = ? WHERE id_gom = ? ;");
            preparedStatement.setString(1, obj.getCouleur());
            preparedStatement.setString(2, obj.getDesc());
            preparedStatement.setInt(3, obj.getId());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public GomEntity create(GomEntity obj) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT INTO goms (couleur, desc) VALUES (?,?);");
            preparedStatement.setString(1, obj.getCouleur());
            preparedStatement.setString(2, obj.getDesc());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(GomEntity obj) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("DELETE FROM gomatt WHERE id_gom = " + String.valueOf(obj.getId()));
            preparedStatement.executeUpdate();
            preparedStatement = this.connect.prepareStatement("DELETE FROM goms WHERE id_gom = " + String.valueOf(obj.getId()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

