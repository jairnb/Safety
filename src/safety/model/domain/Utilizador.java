package safety.model.domain;

public class Utilizador {

    private int id_utilizador;
    private String nomeutilizador;
    private String senha;
    private String tipo;
    private String estado;
    private int id_funcionario;

    public Utilizador(String nomeutilizador, String senha, String tipo, String estado, int id_funcionario) {
        this.nomeutilizador = nomeutilizador;
        this.senha = senha;
        this.tipo = tipo;
        this.estado = estado;
        this.id_funcionario = id_funcionario;
    }

    public Utilizador() {
    }
    
    

    

    

   

  

    public int getId_utilizador() {
        return id_utilizador;
    }

    public void setId_utilizador(int id_utilizador) {
        this.id_utilizador = id_utilizador;
    }

    public String getNomeutilizador() {
        return nomeutilizador;
    }

    public void setNomeutilizador(String nomeutilizador) {
        this.nomeutilizador = nomeutilizador;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    @Override
    public String toString() {
        return getTipo();
    }
    

}
