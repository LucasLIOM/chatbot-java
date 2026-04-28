package main.java.com.chatbot.service;

import java.util.List;
import main.java.com.chatbot.dao.ClienteDAO;
import main.java.com.chatbot.model.Cliente;

public class ClienteService {

    private final ClienteDAO clienteDAO = new ClienteDAO();

    // O service para fazer validações com if
    public void validarCliente(int idCliente) {
        if (idCliente <= 0) {
            throw new IllegalArgumentException("ID inválido.");
        }

        if (!clienteDAO.buscarCliente(idCliente)) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }
    }

    public String inserirCliente(String nome, String telefone) {
        if (nome == null || nome.trim().isEmpty()) {
            return "Nome inválido.";
        }

        clienteDAO.inserirCliente(new Cliente(nome, telefone));
        return "Cliente cadastrado com sucesso!";
    }

    public String atualizarCliente(int id, String nome, String telefone) {
        validarCliente(id);

        clienteDAO.atualizarCliente(id, nome, telefone);
        return "Cliente atualizado com sucesso!";
    }

    public String deletarCliente(int id) {
        validarCliente(id);

        clienteDAO.deletarCliente(id);
        return "Cliente deletado com sucesso!";
    }

    public List<Cliente> listarClientes() {
        return clienteDAO.listarCliente();
    }

    public String deletarTudo() {
        clienteDAO.deletarTodos();
        return "Todos os clientes deletados.";
    }

    public boolean existe(int id) {
        return clienteDAO.buscarCliente(id);
    }
}