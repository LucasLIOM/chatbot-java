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
        String querySql = "INSERT INTO mensagem (id_conversa, texto, tipo, data_hora) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(querySql)) {

            stmt.setInt(1, conversa.getIdConversa());
            stmt.setString(2, texto);
            stmt.setString(3, tipo);
            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

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
                    boolean confereDataHora = (rs.getTimestamp("data_hora") == null);
                    if(confereDataHora){ 
                        break;
                    }
                    System.out.println("Confere data e hora:" + rs.getTimestamp("data_hora"));

                    lista.add(new Mensagem(
                            rs.getInt("id_mensagem"),
                            rs.getInt("id_conversa"),
                            rs.getString("texto"),
                            rs.getString("tipo"),
                            rs.getTimestamp("data_hora").toLocalDateTime()
                    ));
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
