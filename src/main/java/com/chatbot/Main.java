package main.java.com.chatbot;

import main.java.com.chatbot.bot.BotService;
import main.java.com.chatbot.dao.MensagemDAO;
import main.java.com.chatbot.service.ClienteService;
import main.java.com.chatbot.service.ConversaService;
import main.java.com.chatbot.service.MensagemService;
import main.java.com.chatbot.view.View;
import main.java.com.chatbot.view.ViewCliente;

public class Main {

    public static void main(String[] args) {

        View view = new View();
        ViewCliente viewCliente = new ViewCliente();

        ClienteService clienteService = new ClienteService();
        MensagemService mensagemService = new MensagemService();
        ConversaService conversaService = new ConversaService();
        BotService botService = new BotService();

        boolean flag = false;

        while (!flag) {

            try {
                int opcao = Integer.parseInt(view.readString(viewCliente.menuCliente()));

                switch (opcao) {

                    case 1 -> {
                        String nome = view.readString(viewCliente.digitarNome());
                        String telefone = view.readString(viewCliente.digitarTelefone());
                        view.showM(clienteService.inserirCliente(nome, telefone));
                    }

                    case 2 -> {
                        int id = Integer.parseInt(view.readString(viewCliente.digitarId()));
                        String nome = view.readString(viewCliente.digitarNome());
                        String telefone = view.readString(viewCliente.digitarTelefone());
                        view.showM(clienteService.atualizarCliente(id, nome, telefone));
                    }

                    case 3 -> {
                        int id = Integer.parseInt(view.readString(viewCliente.digitarId()));
                        view.showM(clienteService.deletarCliente(id));
                    }

                    case 4 -> {
                        view.showM(clienteService.listarClientes().toString());
                    }

                    case 5 -> {
                        view.showM(clienteService.deletarTudo());
                    }

                    case 6 -> {
                        int id = Integer.parseInt(view.readString(viewCliente.digitarId()));

                        while (true) {
                            String texto = view.readString(viewCliente.digitarTexto());

                            if (texto == null || texto.equalsIgnoreCase("sair")) {
                                break;
                            }

                            mensagemService.enviarMensagem(id, texto, "cliente");

                            String resposta = botService.respostaBot(texto);

                            mensagemService.enviarMensagem(id, resposta, "bot");

                            view.showM("🤖 Bot: " + resposta);
                        }
                    }
                    case 7 -> {
                        var conversas = conversaService.listar();
                        MensagemDAO mensagemDAO = new MensagemDAO();

                        if (conversas.isEmpty()) {
                            view.showM("Nenhuma conversa encontrada.");
                        } else {

                            StringBuilder sb = new StringBuilder();

                            for (var c : conversas) {

                                sb.append("=================================\n");
                                sb.append("Conversa ID: ").append(c.getIdConversa()).append("\n");
                                sb.append("Cliente: ").append(c.getCliente().getNome()).append("\n\n");

                                var mensagens = mensagemDAO.listarMensagens(c.getIdConversa());

                                if (mensagens.isEmpty()) {
                                    sb.append("Sem mensagens.\n");
                                } else {
                                    for (var m : mensagens) {
                                        sb.append(m.getTipo().toUpperCase())
                                                .append(": ")
                                                .append(m.getTexto())
                                                .append("\n");
                                    }
                                }

                                sb.append("\n");
                            }

                            view.showM(sb.toString());
                        }
                    }
                    case 0 ->
                        flag = true;

                    default ->
                        view.showM("Opção inválida.");
                }

            } catch (Exception e) {
                view.showM("Erro: " + e.getMessage());
            }
        }
    }
}
