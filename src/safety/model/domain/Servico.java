package safety.model.domain;

import java.time.LocalDate;
import java.util.List;

public class Servico {

    //todos os atributos da classe servico
    private int id_servico;
    private LocalDate data_inicio;
    private String descricao;
    private LocalDate data_termino;
    private float custo;
    private String periodo;
    private int id_cliente;
    private Cliente cliente;
    private Endereco endereco;
    private Prestar prestar;
    private Evento eventos;
    private List<Funcionario> listadeagentes;
    private boolean selected ;
    //private CheckBox checkbox;

    public Servico() {
    }
    

    public Servico(LocalDate data_inicio, String descricao, LocalDate data_termino, float custo,String periodo,Cliente cliente) {
        this.data_inicio = data_inicio;
        this.descricao = descricao;
        this.data_termino = data_termino;
        this.custo = custo;
        this.periodo = periodo;
        this.cliente = cliente;
    }
    
    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Prestar getPrestar() {
        return prestar;
    }

    public void setPrestar(Prestar prestar) {
        this.prestar = prestar;
    }

    public Evento getEventos() {
        return eventos;
    }

    public void setEventos(Evento eventos) {
        this.eventos = eventos;
    }

    public List<Funcionario> getListadeagentes() {
        return listadeagentes;
    }

    public void setListadeagentes(List<Funcionario> listadeagentes) {
        this.listadeagentes = listadeagentes;
    }
 
    
    //overide o metodo tostring para preencher o comboboxPeriodo 
    @Override
    public String toString(){
               
        return periodo;
        
    }

    //todos os metos geters e seters da respetiva classe
    public int getId_servico() {
        return id_servico;
    }

    public void setId_servico(int id_servico) {
        this.id_servico = id_servico;
    }

    public LocalDate getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(LocalDate data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData_termino() {
        return data_termino;
    }

    public void setData_termino(LocalDate data_termino) {
        this.data_termino = data_termino;
    }

    public float getCusto() {
        return custo;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    
     public boolean getCheckbox() {
        return selected;
    }

    public void setCheckbox(boolean selected) {
        this.selected = selected;
    }
    
     
    public void detalharServico(){
        
    }

}
