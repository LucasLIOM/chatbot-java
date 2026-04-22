package main.java.com.chatbot;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;
import main.java.com.chatbot.config.Conexao;
import main.java.com.chatbot.dao.ClienteDAO;
import main.java.com.chatbot.model.Cliente;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try (Connection conn = Conexao.conectar()) {
            ClienteDAO clienteDAO = new ClienteDAO(conn);
            
          /*   clienteDAO.deletarTodos();
            //Cliente cliente = new Cliente(nome, telefone);

            List<Cliente> clientes = clienteDAO.listarCliente();

            for (Cliente c : clientes) {
                System.out.println("ID: " + c.getIdCliente());
                System.out.println("Nome: " + c.getNome());
                System.out.println("Telefone: " + c.getTelefone());
                System.out.println("----------------------");
            }*/

        } catch (Exception e) {
        }

        sc.close();
    }
}
