/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tes;

/**
 *
 * @author salam
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnexion {
   public static void main(String[] args) {
    System.out.println("Début de la connexion...");
    String url = "jdbc:mysql://localhost:3306/db";
    String user = "root";
    String password = ""; // Change si nécessaire

    try {
        // Charger le driver
        System.out.println("Chargement du driver...");
        Class.forName("com.mysql.jdbc.Driver");

        // Établir la connexion
        System.out.println("Établissement de la connexion...");
        Connection cn = DriverManager.getConnection(url, user, password);
        System.out.println("Connexion réussie !");
        
        // Fermer la connexion
        cn.close();
    } catch (SQLException e) {
        System.out.println("Erreur de connexion : " + e.getMessage());
    } catch (ClassNotFoundException e) {
        System.out.println("Driver non trouvé : " + e.getMessage());
    }
}

}
