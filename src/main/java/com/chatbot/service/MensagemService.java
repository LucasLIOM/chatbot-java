package main.java.com.chatbot.service;

import java.util.ArrayList;
import java.util.List;
import main.java.com.chatbot.dao.ConversaDAO;
import main.java.com.chatbot.dao.MensagemDAO;
import main.java.com.chatbot.model.Cliente;
import main.java.com.chatbot.model.Conversa;
import main.java.com.chatbot.model.Mensagem;

public class MensagemService {

    public String enviarMensage(int idCliente, String texto, String tipo) {

        if (idCliente <= 0) {
            return "ID do cliente inválido!";
        }

        if (texto == null || texto.isEmpty()) {
            return "Texto não pode ficar vazio!";
        }

        if (texto.length() > 400) {
            return "Texto máximo: 400 caracteres.";
        }

        ConversaDAO conversaDAO = new ConversaDAO();
        MensagemDAO mensagemDAO = new MensagemDAO();

        String typePessoa = tipo.equalsIgnoreCase("cliente") ? "cliente" : "bot";

        Conversa conversa = conversaDAO.buscarConversa(idCliente);

        if (conversa == null) {
            int id = conversaDAO.criarConversa(idCliente);
            conversa = new Conversa(id, null, null);
        }

        mensagemDAO.criarMensagem(conversa, texto, typePessoa);

        return "Nova mensagem criada!";
    }

    public List<Mensagem> buscarHistorico(Cliente cliente) {

        ConversaDAO conversaDAO = new ConversaDAO();
        MensagemDAO mensagemDAO = new MensagemDAO();

        Conversa conversa = conversaDAO.buscarConversa(cliente.getIdCliente());

        if (conversa == null) {
            return new ArrayList<>();
        }

        return mensagemDAO.listarMensagems(conversa.getIdConversa());
    }
}
