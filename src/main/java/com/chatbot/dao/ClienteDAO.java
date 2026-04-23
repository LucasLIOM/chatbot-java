package main.java.com.chatbot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import main.java.com.chatbot.config.Conexao;
import main.java.com.chatbot.model.Cliente;

public class ClienteDAO {

    // Anotações para lembrar:
    // Criação de um método para inserir clientes na tabela "chatbot" no sql
    public void inserirCliente(Cliente cliente) {

        // Cria uma variavel que tem um código sql de INSERT, primeiro os atributos
        // (nome, telefone)
        // e em seguida os valores com interrogação, que seram "settados" no execQuery
        // abaixo
        String querySql = "INSERT INTO cliente (nome, telefone) VALUES (?, ?)";

        // Tudo o que for JDBC (prepareStatement, executeQuery) precisa ter o try catch
        // para
        // tratamentos de exceção, caso de erro ele evita que a aplicação perca a
        // conexão com o banco de dados
        // e evita do banco guardar informações erradas no processo.
        try (Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(querySql)) {

            // Executando as querys da variavel querySql, pega a posição (indice) e insere o
            // atributo que
            // foi definido no banco de dados:
            // INSERT INTO cliente (nome, telefone) VALUES ("Lucas" "47987654321")
            // execQuery(indice 1 = nome, indice 2 = telefone)
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Cliente> listarCliente() {
        String querySql = "SELECT * FROM cliente";

        List<Cliente> lista = new ArrayList<>();

        try (Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(querySql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nome"),
                        rs.getString("telefone"));

                lista.add(cliente);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return lista;
    }

    public void atualizarCliente(Cliente cliente) {
        String querySql = "UPDATE cliente SET nome = ?, telefone = ? WHERE id_cliente = ?";

        try (Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(querySql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setInt(3, cliente.getIdCliente());

            stmt.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void deletarCliente(int id) {
        String querySql = "DELETE FROM cliente WHERE id_cliente = ?";

        try (Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(querySql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void deletarTodos() {
        String querySql = "DELETE FROM cliente";

        try (Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(querySql)) {
            stmt.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
