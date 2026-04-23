package main.java.com.chatbot;

import java.sql.Connection;
import java.util.Scanner;
import main.java.com.chatbot.config.Conexao;
import main.java.com.chatbot.service.ClienteService;
import main.java.com.chatbot.service.MainService;

public class Main {

    public static void main(String[] args) {

        MainService mainService = new MainService();
        ClienteService clienteService = new ClienteService();

        Scanner sc = new Scanner(System.in);
        String nome = "";
        String telefone = "";
        int id = 0;
        boolean flag = false;

        try (Connection conn = Conexao.conectar()) {

            while (!flag) {

                System.out.println(mainService.menuCliente());
                int input = sc.nextInt();
                sc.nextLine();

                switch (input) {

                    case 1:
                        System.out.println(mainService.digitarNome());
                        nome = sc.nextLine();
                        System.out.println(mainService.digitarTelefone());
                        telefone = sc.nextLine();
                        System.out.println(clienteService.serviceCadastrarCliente(nome, telefone));
                        break;

                    // Case 2 -> Arrumar.
                    case 2:
                        // System.out.println(mainService.digitarId());
                        // String entradaId = sc.nextLine();
                        break;

                    case 3:
                        System.out.println(mainService.digitarId());
                        id = sc.nextInt();
                        System.out.println(clienteService.serviceDeletarCliente(id));
                        break;

                    case 4:
                        System.out.println(clienteService.serviceListarCliente());
                        break;

                    case 5:
                        System.out.printf(clienteService.serviceDeletarTudo());
                        break;

                    case 0:
                    break;

                    default:
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }

    // Verifica se o que o usuário digitou é algo vazio
    static boolean verificaInput(String mensagem) {
        if (mensagem == null || mensagem.isEmpty()) {
            return false;
        }
        return true;
    }
}
