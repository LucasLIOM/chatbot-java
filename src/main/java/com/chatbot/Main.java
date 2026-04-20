package main.java.com.chatbot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/chatbot";
        String user = "root";
        String password = "MyLuk_04";



        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cliente");

            while (rs.next()) {
                System.out.println(rs.getString("nome"));
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }


       /* try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO cliente (nome, telefone) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, "Lucas");
            stmt.setString(2, "11999999999");

            stmt.executeUpdate();

            System.out.println("Cliente inserido!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } */
    }
}
