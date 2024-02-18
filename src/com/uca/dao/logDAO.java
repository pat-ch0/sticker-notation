package com.uca.dao;
import com.uca.entity.ProfEntity;
import java.sql.*;
import java.util.ArrayList;

public class logDAO  extends _Generic<ProfEntity>{
    
    public ProfEntity verif(String u, String p){
        ProfEntity connected = new ProfEntity();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM profs WHERE profs.username = "+"'"+u+"'"+" AND profs.password = "+"'"+p+"'");
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                connected.setId(resultSet.getInt("id_prof"));
                connected.setNom(resultSet.getString("nom_prof"));
            }
            else{
                connected.setId(-1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connected;
    }

    @Override
    public ProfEntity create(ProfEntity obj) {
        return null;
    }

    @Override
    public void delete(ProfEntity obj) {
        //
    }

}
