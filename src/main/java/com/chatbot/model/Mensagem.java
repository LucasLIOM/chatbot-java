package main.java.com.chatbot.model;

import java.time.LocalDateTime;

public class Mensagem {

    private Integer idMensagem;
    private Integer idConversa;
    private String texto;
    private String tipo;
    private LocalDateTime dataHora;

    public Mensagem(Integer idConversa, String texto, String tipo, LocalDateTime dataHora) {
        this.idConversa = idConversa;
        this.texto = texto;
        this.tipo = tipo;
        this.dataHora = dataHora;
    }

    public Mensagem(Integer idMensagem, Integer idConversa, String texto, String tipo, LocalDateTime dataHora) {
        this.idMensagem = idMensagem;
        this.idConversa = idConversa;
        this.texto = texto;
        this.tipo = tipo;
        this.dataHora = dataHora;
    }

    public void setIdConversa(Integer idConversa) {
        this.idConversa = idConversa;
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

    public Integer getIdConversa() {
        return idConversa;
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
