package main.java.com.chatbot;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver carregado!");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado!");
            e.printStackTrace();
        }


        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/chatbot",
                "root",
                ""
            );
  
            System.out.println("Conectado com sucesso: "+conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
