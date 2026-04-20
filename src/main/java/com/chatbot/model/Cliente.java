package main.java.com.chatbot.model;

public class Cliente {
    private Cliente cliente;
    private String nome;
    private String telefone;

    Cliente(Cliente cliente, String nome, String telefone){
        this.cliente = cliente;
        this.nome = nome;
        this.telefone = telefone;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }
}