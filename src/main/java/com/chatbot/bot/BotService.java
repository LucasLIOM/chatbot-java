package main.java.com.chatbot.bot;

public class BotService {

    public String respostaBot(String mensagemCliente) {

        if (mensagemCliente == null || mensagemCliente.isEmpty()) {
            return "Não entendi sua mensagem.";
        }

        mensagemCliente = mensagemCliente.toLowerCase();

        if (mensagemCliente.contains("oi")) {
            return "Olá! Como posso te ajudar?";
        }

        if (mensagemCliente.contains("sobre")) {
            return "Somos um projeto para automatiza e facilitar o dia dia de pequenos empreendedores até grandes empresas!";
        }

        return "Desculpe, não entendi. Pode reformular?";
    }
}