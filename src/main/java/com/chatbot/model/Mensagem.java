package main.java.com.chatbot.model;

import java.time.LocalDateTime;

public class Mensagem {

    private Integer idMensagem;
    private Conversa conversa;
    private String texto;
    private String tipo;
    private LocalDateTime dataHora;

    public Mensagem(Conversa conversa, String texto, String tipo) {
        this.conversa = conversa;
        this.texto = texto;
        this.tipo = tipo;
        this.dataHora = LocalDateTime.now();
    }

    public Mensagem(Integer idMensagem, Conversa conversa, String texto, String tipo, LocalDateTime dataHora) {
        this.idMensagem = idMensagem;
        this.conversa = conversa;
        this.texto = texto;
        this.tipo = tipo;
        this.dataHora = dataHora;
    }

    public void setConversa(Conversa conversa) {
        this.conversa = conversa;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public void setIdMensagem(Integer idMensagem) {
        this.idMensagem = idMensagem;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getIdMensagem() {
        return idMensagem;
    }

    public Conversa getConversa() {
        return conversa;
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