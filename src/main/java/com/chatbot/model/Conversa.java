package main.java.com.chatbot.model;

public class Conversa {

    private Integer idConversa;
    private Cliente cliente;

    public Conversa(Cliente cliente) {
        this.cliente = cliente;
    }

    public Conversa(Integer idConversa, Cliente cliente) {
        this.idConversa = idConversa;
        this.cliente = cliente;
    }

    public Integer getIdConversa() {
        return idConversa;
    }

    public Cliente getCliente() {
        return cliente;
    }
}