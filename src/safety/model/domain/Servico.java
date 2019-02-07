package safety.model.domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import javafx.collections.ObservableList;

public class Servico {

    //todos os atributos da classe servico
    private int id_servico;
    private LocalDate data_inicio;
    private String descricao;
    private LocalDate data_termino;
    private float custo;
    private String periodo;
    private int id_cliente;
    private boolean selected ;

    public Servico() {
        
    } 

   
    
    //inicializando as variaveis que permitem o acesso e as informacao da base de dados
      static PreparedStatement ps = null;
      static ResultSet rs = null;
        
    
    //overide o metodo tostring para preencher o comboboxPeriodo 
    
    @Override
    public String toString(){
               
        return periodo;
        
    }
    public static void geralInfoPeriodo(ObservableList<Servico> olperiodo){
       
     final String[] string = {"fulltime","noturno","diurno"};
    
   
    //ObservableList<Servico> obs = FXCollections.observableArrayList(string) ;
    //olperiodo = obs;
        
    }
    
       public boolean isSelected() {
        return selected;
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

}
