package main.java.com.chatbot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import main.java.com.chatbot.config.Conexao;
import main.java.com.chatbot.model.Cliente;
import main.java.com.chatbot.model.Conversa;

public class ConversaDAO {

    public Conversa buscarConversa(int idCliente) {
        String querySql = "SELECT * FROM conversa WHERE id_cliente = ?";

        try (Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(querySql)) {

            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Conversa(
                        rs.getInt("id_conversa"),
                        new Cliente(idCliente, null, null),
                        null);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

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
