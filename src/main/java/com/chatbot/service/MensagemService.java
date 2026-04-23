package main.java.com.chatbot.service;

import java.util.ArrayList;
import java.util.List;

import main.java.com.chatbot.dao.ConversaDAO;
import main.java.com.chatbot.dao.MensagemDAO;
import main.java.com.chatbot.model.Cliente;
import main.java.com.chatbot.model.Conversa;
import main.java.com.chatbot.model.Mensagem;

public class MensagemService {
    public void enviarMensagem(Cliente cliente, String texto, String tipo) {

        ConversaDAO conversaDAO = new ConversaDAO();
        MensagemDAO mensagemDAO = new MensagemDAO();

        Conversa conversa = conversaDAO.buscarConversa(cliente.getIdCliente());

        if (conversa == null) {
            int id = conversaDAO.criarConversa(cliente);
            conversa = new Conversa(id, cliente, null);
        }

        mensagemDAO.criarMensagem(conversa, texto, tipo);
    }

    public List<Mensagem> buscarHistorico(Cliente cliente) {

        ConversaDAO conversaDAO = new ConversaDAO();
        MensagemDAO mensagemDAO = new MensagemDAO();

        Conversa conversa = conversaDAO.buscarConversa(cliente.getIdCliente());

        if (conversa == null)
            return new ArrayList<>();

        return mensagemDAO.listarMensagems(conversa.getIdConversa());
    }
}
