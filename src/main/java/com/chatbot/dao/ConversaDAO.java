package main.java.com.chatbot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import main.java.com.chatbot.config.Conexao;
import main.java.com.chatbot.model.Cliente;
import main.java.com.chatbot.model.Conversa;

public class ConversaDAO {

    // Busca a conversa com o ID do cliente
    public Conversa buscarConversaPorId(int idCliente) {
        String querySql = "SELECT * FROM conversa WHERE id_cliente = ?";

        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(querySql)) {

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

    // Se o cliente cadastrado não tiver conversa (null) cria uma a partir das mensagens criadas
    public int criarConversa(int idCliente) {
        String querySql = "INSERT INTO conversa (id_cliente) VALUES (?)";

        try (Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(querySql, PreparedStatement.RETURN_GENERATED_KEYS)) {

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

    // Lista as conversas presentes
    public List<Conversa> listarConversa() {
        String querySql = """
                    SELECT c.id_conversa, c.id_cliente, cl.nome
                    FROM conversa c
                    JOIN cliente cl ON c.id_cliente = cl.id_cliente
                """;

        List<Conversa> lista = new ArrayList<>();

        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(querySql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nome"),
                        null);

                lista.add(new Conversa(
                        rs.getInt("id_conversa"),
                        cliente,
                        null));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista; // Retorna a lista de conversas
    }
}
