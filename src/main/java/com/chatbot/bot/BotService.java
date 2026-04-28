package main.java.com.chatbot.bot;

public class BotService {

    public String respostaBot(String mensagemCliente) {

        // Lembrar: Adicionar + ideias e métodos 
        if (mensagemCliente == null || mensagemCliente.isEmpty()) {
            return "Não entendi sua mensagem.";
        }

        mensagemCliente = mensagemCliente.toLowerCase();

        if (mensagemCliente.contains("oi") || mensagemCliente.contains("Ola")) {
            return "Olá! Como posso te ajudar?";
        }

        if (mensagemCliente.contains("sobre")) {
            return "Somos um projeto para automatizar e facilitar o dia dia de pequenos empreendedores até grandes empresas!";
        }

        return "Desculpe, não entendi. Pode reformular?";
    }
}