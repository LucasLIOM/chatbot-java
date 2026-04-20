package main.java.com.chatbot.model;

import java.time.LocalDateTime;

public class Mensagem {

    private Integer idMensagem;
    private Cliente cliente;
    private String texto;
    private String tipo;
    private LocalDateTime dataHora;

    public Mensagem(Cliente cliente, String texto, String tipo) {
        this.cliente = cliente;
        this.texto = texto;
        this.tipo = tipo;
        this.dataHora = LocalDateTime.now();
    }

    public Mensagem(Integer idMensagem, Cliente cliente, String texto, String tipo, LocalDateTime dataHora) {
        this.idMensagem = idMensagem;
        this.cliente = cliente;
        this.texto = texto;
        this.tipo = tipo;
        this.dataHora = dataHora;
    }

    public Integer getIdMensagem() {
        return idMensagem;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getTexto() {
        return texto;
    }

    public String getTipo() {
        return tipo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}