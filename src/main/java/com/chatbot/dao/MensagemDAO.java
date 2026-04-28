package main.java.com.chatbot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import main.java.com.chatbot.config.Conexao;
import main.java.com.chatbot.model.Conversa;
import main.java.com.chatbot.model.Mensagem;

public class MensagemDAO {

    public int criarMensagem(Conversa conversa, String texto, String tipo) {

        // Mesmo principio usado no metodo "criarConversa()", só que caso a conversa for null significa que ela ainda não foi criada
        if (conversa == null || conversa.getIdConversa() == null || conversa.getIdConversa() <= 0) {
            throw new IllegalArgumentException("Conversa inválida");
        }

        // Insere os parametros da conversa no banco
        String querySql = "INSERT INTO mensagem (id_conversa, texto, tipo, data_hora) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(querySql)) {

            stmt.setInt(1, conversa.getIdConversa());
            stmt.setString(2, texto);
            stmt.setString(3, tipo);
            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));

            stmt.executeUpdate();
            return 1;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

    // Lista as mensagens
    public List<Mensagem> listarMensagens(int idConversa) {

        List<Mensagem> lista = new ArrayList<>();

        String querySql = """
                    SELECT id_mensagem, id_conversa, texto, tipo, data_hora
                    FROM mensagem
                    WHERE id_conversa = ?
                    ORDER BY data_hora
                """;

        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(querySql)) {

            stmt.setInt(1, idConversa);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Arrumar !!!
                if (rs.getTimestamp("data_hora") == null) {
                    continue;
                }
                System.out.println("Confere data e hora:" + rs.getTimestamp("data_hora"));

                lista.add(new Mensagem(
                        rs.getInt("id_mensagem"),
                        rs.getInt("id_conversa"),
                        rs.getString("texto"),
                        rs.getString("tipo"),
                        rs.getTimestamp("data_hora").toLocalDateTime()));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
