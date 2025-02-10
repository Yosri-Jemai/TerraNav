package tn.esprit.services;

import tn.esprit.entities.Client;
import tn.esprit.utils.MyDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ServiceClient implements IService<Client>{


    private Connection connection;
    public ServiceClient() {
        connection = MyDataBase.getInstance().getConnection();
    }
    @Override
    public void ajouter(Client client) throws SQLException {
        String sql = "INSERT INTO utilisateur (username, password, email, numTel, address, role, nom, prenom, cin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, client.getUsername());
        preparedStatement.setString(2, client.getPassword());
        preparedStatement.setString(3, client.getEmail());
        preparedStatement.setString(4, client.getNumTel());
        preparedStatement.setString(5, client.getAddress());
        preparedStatement.setString(6, client.getRole());
        preparedStatement.setString(7, client.getNom());
        preparedStatement.setString(8, client.getPrenom());
        preparedStatement.setString(9, client.getCin());

        preparedStatement.executeUpdate();
    }

    public Client read(int id) throws SQLException {
        Client client = new Client();
        String sql = "SELECT * FROM utilisateur WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            client.setId(resultSet.getInt("id"));
            client.setUsername(resultSet.getString("username"));
            client.setPassword(resultSet.getString("password"));
            client.setEmail(resultSet.getString("email"));
            client.setNumTel(resultSet.getString("numTel"));
            client.setAddress(resultSet.getString("address"));
            client.setRole(resultSet.getString("role"));
            client.setNom(resultSet.getString("nom"));
            client.setCin(resultSet.getString("cin"));
            client.setPrenom(resultSet.getString("prenom"));
        }
        return client;
    }
    public List<Client> afficher() throws SQLException {
        ServiceUser userService = new ServiceUser();
        return userService
                .afficher()
                .stream()
                .filter(e -> e instanceof Client)
                .map(client -> (Client) client)
                .toList();
    }
    public void modifier(Client client) throws SQLException {
        String sql = "UPDATE `utilisateur` SET `username`=?,`password`=?,`email`=?,`numTel`=?,`address`=?,`role`=? ,`nom`=?,`prenom`=?,`cin`=? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, client.getUsername());
        ps.setString(2, client.getPassword());
        ps.setString(3, client.getEmail());
        ps.setString(4, client.getNumTel());
        ps.setString(5, client.getAddress());
        ps.setString(6, client.getRole());
        ps.setString(7,client.getNom());
        ps.setString(8,client.getPrenom());
        ps.setString(9,client.getCin());
        ps.setInt(10, client.getId());
        ps.executeUpdate();
    }

    @Override
    public void supprimer(int id) throws SQLException {
        {
            Connection connection = MyDataBase.getInstance().getConnection();
            String sql = "DELETE FROM `utilisateur` WHERE id =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}

