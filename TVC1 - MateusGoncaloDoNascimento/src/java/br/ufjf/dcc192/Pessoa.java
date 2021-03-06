package br.ufjf.dcc192;

public class Pessoa {
    private Integer id;
    private String nome;
    private String disponibilidade;
    private Integer qtddDias;
    private String qualificacao;
    private String login;
    private String senha;
    private String email;
    
    public Pessoa(Integer id, String nome, String disponibilidade, Integer qtddDias, String login, String senha, String email) {
        this.id = id;
        this.nome = nome;
        this.disponibilidade = disponibilidade;
        this.qtddDias = qtddDias;
        this.qualificacao = "Erro";
        this.login = login;
        this.senha = senha;
        this.email = email;
    }

    Pessoa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getQtddDias() {
        return qtddDias;
    }

    public void setQtddDias(Integer qtddDias) {
        this.qtddDias = qtddDias;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getQualificacao() {
        return qualificacao;
    }

    public void setQualificacao(String qualificacao) {
        this.qualificacao = qualificacao;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
