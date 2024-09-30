package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Test {

    public static void save(Site s) {
        // Information d'accès à la base de données
        String user = "root";
        String password = ""; 
        String url = "jdbc:mysql://localhost:3306/db";
        Connection cn = null;
        Statement st = null;

        try {
            // Étape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");

            // Étape 2 : Récupération de la connexion
            cn = DriverManager.getConnection(url, user, password);

            // Étape 3 : Création d'un Statement
            st = cn.createStatement();
            String req = "INSERT INTO site VALUES (NULL, '" + s.getNom() + "')";
            
            // Étape 4 : Exécution de la requête
            st.executeUpdate(req);
            System.out.println("Insertion réussie pour : " + s.getNom());
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver : " + ex.getMessage());
        } finally {
            try {
                // Étape 5 : Libérer les ressources de la mémoire
                if (st != null) {
                    st.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Impossible de libérer les ressources : " + ex.getMessage());
            }
        }
    } 
    
    public static void main(String[] args) {
        // Insertion des données (à ne pas exécuter si tu ne veux pas ajouter à la base)
        save(new Site("SAFI"));
        save(new Site("MARRAKECH"));
        save(new Site("EL JADIDA"));
    }
}
