package main.java.com.chatbot.model;

public class Empresa {

    private Integer idEmpresa;
    private String nome;

    public Empresa(String nome) {
        this.nome = nome;
    }

    public Empresa(Integer idEmpresa, String nome) {
        this.idEmpresa = idEmpresa;
        this.nome = nome;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public String getNome() {
        return nome;
    }
}