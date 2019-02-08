package safety.model.domain;

public class Prestar {

    private int id_funcionario;
    private int id_servico;
    private Funcionario funcionario;
    private Servico servico;
    private String turno;

    public Prestar(int id_funcionario, int id_servico, String turno) {
        this.id_funcionario = id_funcionario;
        this.id_servico = id_servico;
        this.turno = turno;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

 
    
    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public int getId_servico() {
        return id_servico;
    }

    public void setId_servico(int id_servico) {
        this.id_servico = id_servico;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
     @Override
    public String toString(){
               
        return turno;
        
    }
    

}
