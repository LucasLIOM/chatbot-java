package main.java.com.chatbot.service;

public class MainService {

    // Clientes
    public String menuCliente() {
        return "╔═══════════════════════════════════╗\n" +
                "║      MENU DO ADMINISTRADOR        ║\n" +
                "╠═══════════════════════════════════╣\n" +
                "║ 1  - Cadastrar cliente            ║\n" +
                "║ 2  - Atualizar cliente            ║\n" +
                "║ 3  - Deletar cliente              ║\n" +
                "║ 4  - Listar clientes              ║\n" +
                "║ 5  - Deletar todos os clientes    ║\n" +
                "║ 6  - Iniciar conversa             ║\n" +
                "║ 11 - Verificar todas as conversas ║\n" +
                "║ 0  - Sair                         ║\n" +
                "╚═══════════════════════════════════╝";
    }

    public String digitarNome() {
        return "Nome do cliente:";
    }

    public String digitarTelefone() {
        return "Telefone do cliente:";
    }

    public String digitarId() {
        return "Id do cliente:";
    }
}
