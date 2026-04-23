package main.java.com.chatbot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import main.java.com.chatbot.config.Conexao;

public class ConversaDAO {

    public int criarConversa(int idCliente) {
        String querySql = "INSERT INTO conversa (id_cliente, data_inicio) VALUES (?, NOW())";

        try (Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(querySql)) {

            stmt.setInt(1, idCliente);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }
}
