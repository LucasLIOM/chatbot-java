package main.java.com.chatbot.model;

public class Cliente {

    private Integer idCliente;
    private String nome;
    private String telefone;

    // 🔹 Construtor para inserir (sem ID)
    public Cliente(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    // 🔹 Construtor completo (quando vem do banco)
    public Cliente(Integer idCliente, String nome, String telefone) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.telefone = telefone;
    }

    // 🔹 Getters e Setters
    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // 🔹 toString (útil pra debug)
    @Override
    public String toString() {
        return "Cliente{"
                + "idCliente=" + idCliente
                + ", nome='" + nome + '\''
                + ", telefone='" + telefone + '\''
                + '}';
    }
}
