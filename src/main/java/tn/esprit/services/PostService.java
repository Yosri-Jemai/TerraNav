package tn.esprit.services;


import tn.esprit.entities.Post;
import tn.esprit.utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostService implements IService<Post> {
    private Connection connection;
    public PostService()
    {
        connection= MyDataBase.getInstance().getConnection();
    }
    @Override
    public void ajouter(Post m) throws SQLException {

        String sql = "INSERT INTO post (id_user, statut, date, image, nbCommentaires, nbReactions) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, m.getIdUser());
        pst.setString(2, m.getStatut());
        pst.setTimestamp(3, new Timestamp(m.getDate().getTime()));
        pst.setString(4, m.getImage());
        pst.setInt(5, m.getNbCommentaires());
        pst.setInt(6, m.getNbReactions());

        pst.executeUpdate();
        System.out.println("Post ajouté avec succès");
    }


    @Override
    public void supprimer(int id) throws SQLException {
        String sql= "DELETE FROM `post` WHERE `id` = ?";
        PreparedStatement ps=connection.prepareStatement(sql);
        ps.setInt(1,id);
        ps.executeUpdate();
        System.out.println("Post supprimé avec succès");

    }


    @Override
    public void modifier(Post p) throws SQLException {
        String sql = "UPDATE post SET id_user = ?, statut = ?, date = ?, image = ?, nbCommentaires = ?, nbReactions = ? WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1,1);
            pstmt.setString(2, "mayarayayayayayyayayaya");
            pstmt.setTimestamp(3, new Timestamp(p.getDate().getTime()));
            pstmt.setString(4, p.getImage());
            pstmt.setInt(5, 20);
            pstmt.setInt(6, 30);
            pstmt.setInt(7, p.getId());

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("✅ Post mis à jour avec succès !");
            } else {
                System.out.println("⚠️ Aucun post trouvé avec cet ID.");
            }
        }
    }

    @Override
    public List<Post> afficher() throws SQLException {
        String sql = "SELECT * FROM post";
        Statement st=connection.createStatement();
        ResultSet res= st.executeQuery(sql);
        List<Post> posts = new ArrayList<>();
        while(res.next())
        {
            Post p = new Post();
            p.setId(res.getInt("id"));
            p.setStatut(res.getString("statut"));
            p.setDate(res.getDate("date"));
            p.setImage(res.getString("image"));
            p.setNbCommentaires(res.getInt("nbCommentaires"));
            p.setNbReactions(res.getInt("nbReactions"));
            p.setIdUser(res.getInt("id_user"));
            posts.add(p);
        }
        return posts;
    }



}
