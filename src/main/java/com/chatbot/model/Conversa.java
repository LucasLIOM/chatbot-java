package main.java.com.chatbot.model;

import java.util.List;

public class Conversa {

    private Integer idConversa;
    private Cliente cliente;
    private List<Mensagem> mensagem;

    public Conversa(Cliente cliente, List<Mensagem> mensagem) {
        this.cliente = cliente;
        this.mensagem = mensagem;
    }

    public Conversa(Integer idConversa, Cliente cliente, List<Mensagem> mensagem) {
        this.idConversa = idConversa;
        this.cliente = cliente;
        this.mensagem = mensagem;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setIdConversa(Integer idConversa) {
        this.idConversa = idConversa;
    }

    public void setMensagem(List<Mensagem> mensagem) {
        this.mensagem = mensagem;
    }

    public Integer getIdConversa() {
        return idConversa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Mensagem> getMensagem() {
        return mensagem;
    }
}