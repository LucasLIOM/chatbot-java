package main.java.com.chatbot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import main.java.com.chatbot.config.Conexao;
import main.java.com.chatbot.model.Cliente;

public class MensagemDAO {

    public int criarMensagem(Cliente cliente, String texto, String tipo) {
        String querySql = "INSERT INTO mensagem (id_cliente, texto, tipo) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(querySql)) {

            
            stmt.setInt(1, cliente.getIdCliente());
            stmt.setString(2, texto);
            stmt.setString(3, tipo);
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
