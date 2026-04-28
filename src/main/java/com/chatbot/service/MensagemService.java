package main.java.com.chatbot.service;

import main.java.com.chatbot.dao.MensagemDAO;
import main.java.com.chatbot.model.Conversa;

public class MensagemService {

    private final ConversaService conversaService = new ConversaService();
    private final MensagemDAO mensagemDAO = new MensagemDAO();

    // Enviar as mensagens, guarda os dados e então cria de acordo com os parametros abaixo
    public void enviarMensagem(int idCliente, String texto, String tipo) {

        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException("Mensagem vazia.");
        }

        if (!tipo.equalsIgnoreCase("cliente") && !tipo.equalsIgnoreCase("bot")) {
            throw new IllegalArgumentException("Tipo inválido.");
        }

        Conversa conversa = conversaService.buscarOuCriar(idCliente);

        mensagemDAO.criarMensagem(conversa, texto, tipo);
    }
}