package tn.esprit.services;

import tn.esprit.entities.Agence;
import tn.esprit.entities.Client;
import tn.esprit.entities.User;
import tn.esprit.utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceUser implements IService<User> {
    private Connection connection;

    public ServiceUser() {
        connection = MyDataBase.getInstance().getConnection();
    }


    @Override
    public void ajouter(User user) throws SQLException {
        String checkSql = "SELECT COUNT(*) FROM utilisateur WHERE username = ?";
        PreparedStatement checkStmt = connection.prepareStatement(checkSql);
        checkStmt.setString(1, user.getUsername());
        ResultSet rs = checkStmt.executeQuery();
        rs.next();
        if (rs.getInt(1) > 0) {
            System.out.println("Un utilisateur avec ce nom d'utilisateur existe déjà.");
            return; // Ne pas ajouter l'utilisateur si le nom est déjà pris
        }

        // Si l'utilisateur n'existe pas, créer un nouvel utilisateur
        String sql = "INSERT INTO utilisateur (username, password, email, numTel, address, role) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getNumTel());
        preparedStatement.setString(5, user.getAddress());
        preparedStatement.setString(6, user.getRole());
        preparedStatement.executeUpdate();

    }



    public User read(int id) throws SQLException {
        User user = new User();
        String sql = "SELECT * FROM utilisateur WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setNumTel(resultSet.getString("numTel"));
            user.setAddress(resultSet.getString("address"));
            user.setRole(resultSet.getString("role"));
        }
        return user;
    }
   @Override
    public List<User> afficher() throws SQLException {
        List<User> personnes = new ArrayList<>();
        String sql = " SELECT * FROM `utilisateur` ";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            switch (rs.getString("role")) {
                case "admin":
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setEmail(rs.getString("email"));
                    user.setRole(rs.getString("role"));
                    personnes.add(user);
                    break;
                case "agence":
                    Agence agence = new Agence();
                    agence.setId(rs.getInt("id"));
                    agence.setUsername(rs.getString("username"));
                    agence.setPassword(rs.getString("password"));
                    agence.setEmail(rs.getString("email"));
                    agence.setNumTel(rs.getString("numTel"));
                    agence.setAddress(rs.getString("address"));
                    agence.setRole(rs.getString("role"));
                    agence.setNomAgence(rs.getString("nomAgence"));
                    personnes.add(agence);
                    break;
                case "client":
                    Client client = new Client();
                    client.setId(rs.getInt("id"));
                    client.setUsername(rs.getString("username"));
                    client.setPassword(rs.getString("password"));
                    client.setEmail(rs.getString("email"));
                    client.setNumTel(rs.getString("numTel"));
                    client.setAddress(rs.getString("address"));
                    client.setRole(rs.getString("role"));
                    client.setNom(rs.getString("nom"));
                    client.setPrenom(rs.getString("prenom"));
                    client.setCin(rs.getString("cin"));
                    personnes.add(client);
                    break;
                default:
                    break;
            }

        }
        return personnes;
    }

    @Override
    public void modifier(User user) throws SQLException {
        String sql = "UPDATE utilisateur SET username = ?, password = ?, email = ?, numTel = ?, address = ?, role = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getNumTel());
        ps.setString(5, user.getAddress());
        ps.setString(6, user.getRole());
        ps.setInt(7, user.getId());  // Utilisation de l'ID pour la mise à jour
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
