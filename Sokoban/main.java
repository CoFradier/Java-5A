package Sokoban;

import java.sql.*;
import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
            public void run() {
            	String nom = "alex";
            	int niv = 1;
            	int compteur = 230;
                // Votre fonction Run
                // Vos information de connexion à une base de données
                String BDD = "test";
                String url = "jdbc:mysql://localhost:3306/" + BDD;
                String user = "root";
                String passwd = "";
                // L'essaie de connexion à votre base de donées
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(url, user, passwd);
                    Statement stm=conn.createStatement();
                    System.out.println("Connecter");
                    String query = "INSERT INTO resultat (`Pseudo`,`Niveau`, `NbCoups`) " + "VALUES ('nom',1,2)";
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

