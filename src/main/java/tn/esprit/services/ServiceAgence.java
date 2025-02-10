package tn.esprit.services;

import tn.esprit.entities.Agence;
import tn.esprit.utils.MyDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ServiceAgence implements IService<Agence> {
    private Connection connection;
    public ServiceAgence() {
        connection = MyDataBase.getInstance().getConnection();
    }
    @Override
    public void ajouter(Agence agence) throws SQLException {
        String sql = "INSERT INTO utilisateur (username, password,email,numTel,address,role,nomAgence) VALUES (?, ?, ?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, agence.getUsername());
        preparedStatement.setString(2, agence.getPassword());
        preparedStatement.setString(3, agence.getEmail());
        preparedStatement.setString(4, agence.getNumTel());
        preparedStatement.setString(5, agence.getAddress());
        preparedStatement.setString(6, agence.getRole());
        preparedStatement.setString(7, agence.getNomAgence());
        preparedStatement.executeUpdate();

    }


    public Agence read(int id) throws SQLException {
        Agence agence = new Agence();
        String sql = "SELECT * FROM utilisateur WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            agence.setId(resultSet.getInt("id"));
            agence.setUsername(resultSet.getString("username"));
            agence.setPassword(resultSet.getString("password"));
            agence.setEmail(resultSet.getString("email"));
            agence.setNumTel(resultSet.getString("numTel"));
            agence.setAddress(resultSet.getString("address"));
            agence.setRole(resultSet.getString("role"));
            agence.setNomAgence(resultSet.getString("nomAgence"));
        }
        return agence;
    }
    @Override
    public List<Agence> afficher() throws SQLException {
        ServiceUser ServiceUser  = new ServiceUser();
        return ServiceUser
                .afficher()
                .stream()
                .filter(e -> e instanceof Agence)
                .map(agence -> (Agence) agence)
                .toList();
    }

    @Override
    public void modifier(Agence agence) throws SQLException {
        String sql = "UPDATE `utilisateur` SET `username`=?,`password`=?,`email`=?,`numTel`=?,`address`=?,`role`=? ,`nomagence`=? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, agence.getUsername());
        ps.setString(2, agence.getPassword());
        ps.setString(3, agence.getEmail());
        ps.setString(4, agence.getNumTel());
        ps.setString(5, agence.getAddress());
        ps.setString(6, agence.getRole());
        ps.setString(7,agence.getNomAgence());
        ps.setInt(8, agence.getId());
        ps.executeUpdate();
    }

    @Override
    public void supprimer(int id) throws SQLException {
        Connection connection = MyDataBase.getInstance().getConnection();
        String sql = "DELETE FROM `utilisateur` WHERE id =?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}
