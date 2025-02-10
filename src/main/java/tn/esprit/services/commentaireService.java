package tn.esprit.services;


import tn.esprit.entities.commentaire;
import tn.esprit.utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class commentaireService implements IService<commentaire> {
    private Connection connection;

    public commentaireService() {
        connection = MyDataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(commentaire c) throws SQLException {
        String sql = "INSERT INTO commentaire (id_post, id_user, date, contenu) VALUES (?, ?, ?, ?)";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, c.getId_post());
        pst.setInt(2, c.getId_user());
        pst.setTimestamp(3, new Timestamp(c.getDate().getTime()));
        pst.setString(4, c.getContenu());
        pst.executeUpdate();
        System.out.println("Commentaire ajouté avec succès");
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String sql = "DELETE FROM commentaire WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("Commentaire supprimé avec succès");
    }


    @Override
    public void modifier(commentaire c) throws SQLException {
        String sql = "UPDATE commentaire SET id_post = ?, id_user = ?, date = ?, contenu = ? WHERE id = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, c.getId_post());
        pst.setInt(2, c.getId_user());
        pst.setTimestamp(3, new Timestamp(c.getDate().getTime()));
        pst.setString(4, c.getContenu());
        pst.setInt(5, c.getId());
        int rowsUpdated = pst.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Commentaire mis à jour avec succès");
        } else {
            System.out.println("Aucun commentaire trouvé avec cet ID");
        }
    }

    @Override
    public List<commentaire> afficher() throws SQLException {
        String sql = "SELECT * FROM commentaire";
        Statement st = connection.createStatement();
        ResultSet res = st.executeQuery(sql);
        List<commentaire> commentaires = new ArrayList<>();
        while (res.next()) {
            commentaire c = new commentaire();
            c.setId(res.getInt("id"));
            c.setId_post(res.getInt("id_post"));
            c.setId_user(res.getInt("id_user"));
            c.setDate(res.getDate("date"));
            c.setContenu(res.getString("contenu"));
            commentaires.add(c);
        }
        return commentaires;
    }

}
