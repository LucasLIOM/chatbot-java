package main.java.com.chatbot.service;

import java.util.List;
import main.java.com.chatbot.dao.ConversaDAO;
import main.java.com.chatbot.model.Conversa;

public class ConversaService {

    private final ConversaDAO conversaDAO = new ConversaDAO();
    private final ClienteService clienteService = new ClienteService();

    public Conversa buscarOuCriar(int idCliente) {
        clienteService.validarCliente(idCliente);

        Conversa conversa = conversaDAO.buscarConversaPorId(idCliente);

        if (conversa == null) {
            int id = conversaDAO.criarConversa(idCliente);
            return new Conversa(id, null, null);
        }

        return conversa;
    }

    public List<Conversa> listar() {
        return conversaDAO.listarConversa();
    }
}