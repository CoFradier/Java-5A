package Sokoban;

import java.sql.*;
import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Votre fonction Run
                // Vos information de connexion à une base de données
                String BDD = "test";
                String url = "jdbc:mysql://localhost:3306/" + BDD;
                String user = "root";
                String passwd = "Amcn2807";
                // L'essaie de connexion à votre base de donées
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(url, user, passwd);
                    Statement stm=conn.createStatement();
                    System.out.println("Connecter");
                    String query = "INSERT INTO utilisateur (`id`,`nom` , `prenom`) " + "VALUES ( 1,'Robert', 'Michel')";
        	        stm.executeUpdate(query);
                } catch (Exception e){
                    e.printStackTrace();
                    System.out.println("Erreur");
                    System.exit(0);
                }
                
             
            }
        });
    }

}

