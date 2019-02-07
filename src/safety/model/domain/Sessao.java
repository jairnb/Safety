package safety.model.domain;

import java.time.LocalDate;

public class Sessao {

    private int id_sessao;
    private LocalDate datainiciosessao;
    private LocalDate datafimsessao;
    private String descricao;
    private int id_utilizador;

    public int getId_sessao() {
        return id_sessao;
    }

    public void setId_sessao(int id_sessao) {
        this.id_sessao = id_sessao;
    }

    public LocalDate getDatainiciosessao() {
        return datainiciosessao;
    }

    public void setDatainiciosessao(LocalDate datainiciosessao) {
        this.datainiciosessao = datainiciosessao;
    }

    public LocalDate getDatafimsessao() {
        return datafimsessao;
    }

    public void setDatafimsessao(LocalDate datafimsessao) {
        this.datafimsessao = datafimsessao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId_utilizador() {
        return id_utilizador;
    }

    public void setId_utilizador(int id_utilizador) {
        this.id_utilizador = id_utilizador;
    }
    
    

}
