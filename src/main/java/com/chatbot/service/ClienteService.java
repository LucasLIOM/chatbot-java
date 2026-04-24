package main.java.com.chatbot.service;

import java.util.List;
import main.java.com.chatbot.dao.ClienteDAO;
import main.java.com.chatbot.model.Cliente;

public class ClienteService {

    private ClienteDAO clienteDAO = new ClienteDAO();

    public String serviceCadastrarCliente(String nome, String telefone) {

        if (nome == null || nome.trim().isEmpty()) {
            return "Nome não pode está em branco!";
        }

        if (nome.length() < 3) {
            return "Nome precisa ter pelo menos 3 caracteres!";
        }

        if (telefone == null || telefone.trim().isEmpty()) {
            return "Telefone não pode ter espaços e nem ficar em branco!";
        }

        if (telefone.length() > 11 || telefone.length() < 10) {
            return "Número de telefone precisa ter 11 dígitos!";
        }

        clienteDAO.inserirCliente(new Cliente(nome, telefone));
        return "Cliente cadastrado com sucesso!";
    }

    public String serviceAtualizarCliente(int id, String nome, String telefone) {
        if (id <= 0) {
            return "Dígito do ID não pode ser 0.";
        }
        if (nome == null || nome.trim().isEmpty()) {
            return "Nome vazio";
        }
        clienteDAO.atualizarCliente(new Cliente(nome, telefone));
        return "Cliente atualizado com sucesso!";
    }

    public String serviceDeletarCliente(int id) {

        if (id <= 0) {
            return "Dígito do ID não pode ser 0.";
        }
        clienteDAO.deletarCliente(id);
        return "Cliente com ID " + id + " deletado com sucesso!";

    }

    public List<Cliente> serviceListarCliente() {
        return clienteDAO.listarCliente();
    }

    public String serviceDeletarTudo() {
        clienteDAO.deletarTodos();
        return "Todos os clientes deletados.";

    }
}
