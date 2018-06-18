package ua.danit.dao;

import ua.danit.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LikedDAO {
     public void add(Users user) {
        String sql = "INSERT INTO liked_leichenko(client_name, client_id, client_url) VALUES(?,?,?)";
        ConnectionToDB connectionToDB = new ConnectionToDB();
        try (Connection connection = connectionToDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getName());
            statement.setInt(2, user.getId());
            statement.setString(3, user.getUrl());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Users> getUsers(){
        List<Users> userList = new ArrayList<>();
        String sql = "SELECT * FROM liked_leichenko";
        ConnectionToDB connectionToDB = new ConnectionToDB();
        try (Connection connection = connectionToDB.getConnection();
             PreparedStatement statement  = connection.prepareStatement(sql);
             ResultSet rSet = statement.executeQuery()){
            while ( rSet.next() ){
                Users user = new Users();
                user.setId(rSet.getInt("client_id"));
                user.setName(rSet.getString("client_name"));
                user.setUrl(rSet.getString("client_url"));
                userList.add(user);

            }
            return userList;
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        return null;
    }
}
