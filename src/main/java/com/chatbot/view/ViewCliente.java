package main.java.com.chatbot.view;

public class ViewCliente {

    // Clientes
    public String menuCliente() {
        return """
                ╔═══════════════════════════════════╗
                ║      MENU DO ADMINISTRADOR        ║
                ╠═══════════════════════════════════╣
                ║ 1  - Cadastrar cliente            ║
                ║ 2  - Atualizar cliente            ║
                ║ 3  - Deletar cliente              ║
                ║ 4  - Listar clientes              ║
                ║ 5  - Deletar todos os clientes    ║
                ║ 6  - Iniciar conversa             ║
                ║ 11 - Verificar todas as conversas ║
                ║ 0  - Sair                         ║
                ╚═══════════════════════════════════╝
                """;
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
