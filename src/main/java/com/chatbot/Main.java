package main.java.com.chatbot;

import java.sql.Connection;
import java.sql.SQLException;
import main.java.com.chatbot.config.Conexao;
import main.java.com.chatbot.service.ClienteService;
import main.java.com.chatbot.view.View;
import main.java.com.chatbot.view.ViewCliente;

public class Main {

    public static void main(String[] args) {

        View view = new View();
        ViewCliente viewCliente = new ViewCliente();
        ClienteService clienteService = new ClienteService();

        Integer input, id;
        String nome, telefone;
        boolean flag = false, existeCliente;

        try(Connection conn = Conexao.conectar()) {

            while (!flag) {

                input = Integer.parseInt(view.readString(viewCliente.menuCliente()));

                switch (input) {

                    // Inserir clientes
                    case 1 -> {
                        nome = view.readString(viewCliente.digitarNome());
                        telefone = view.readString(viewCliente.digitarTelefone());
                        view.showM(clienteService.serviceCadastrarCliente(nome, telefone));
                    }

                    // Atualizar clientes pelo ID
                    case 2 -> {

                        id = Integer.parseInt(view.readString(viewCliente.digitarId()));
                        existeCliente = clienteService.isCadastro(id);
                        view.showM(existeCliente ? "Cliente encontrado!" : "Cliente não encontrado!");
                        if (existeCliente == true) {
                            nome = view.readString(viewCliente.digitarNome());
                            telefone = view.readString(viewCliente.digitarTelefone());
                            view.showM(clienteService.serviceAtualizarCliente(id, nome, telefone));
                        }
                    }

                    // Deletar clientes pelo ID
                    case 3 -> {
                        id = Integer.parseInt(view.readString(viewCliente.digitarId()));
                        existeCliente = clienteService.isCadastro(id);
                        view.showM(existeCliente ? "Cliente encontrado!" : "Cliente não encontrado!");
                        if (existeCliente == true) {
                            view.readString(clienteService.serviceDeletarCliente(id));
                        }
                    }

                    // Listar clientes
                    case 4 -> {
                        view.escolherCliente(clienteService.serviceListarCliente());
                    }

                    // Deletar tudo (apenas para reiniciar o ID do banco de dados)
                    case 5 -> {
                        view.showM(clienteService.serviceDeletarTudo());
                    }

                    case 6 -> {

                    }

                    case 0 -> {
                        flag = true;
                    }

                    default -> {
                        view.showM("Digite algumas das opções.");
                        return;
                    }
                }
            }
        } catch (SQLException e) {
            view.showM("Erro: "+e.getMessage());
            e.printStackTrace();
        }
    }
}
