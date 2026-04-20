package main.java.com.chatbot.model;

public class Conversa {

    private Integer idConversa;
    private Empresa empresa;
    private Cliente cliente;

    public Conversa(Empresa empresa, Cliente cliente) {
        this.empresa = empresa;
        this.cliente = cliente;
    }

    public Conversa(Integer idConversa, Empresa empresa, Cliente cliente) {
        this.idConversa = idConversa;
        this.empresa = empresa;
        this.cliente = cliente;
    }

    public Integer getIdConversa() {
        return idConversa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public Cliente getCliente() {
        return cliente;
    }
}