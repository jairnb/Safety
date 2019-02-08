package safety.model.domain;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import safety.model.database.Database;

public class Evento {

    private int id_evento;
    private String descricao;
    private LocalDate dataevento;
    private int id_servico;
    private Servico servico;

    public Evento(String descricao, LocalDate dataevento, int id_servico) {
        this.descricao = descricao;
        this.dataevento = dataevento;
        this.id_servico = id_servico;
    }
    
      public int selecionarServico(Servico servico) {
        
          Connection cnn = Database.getConnection();
        String sql = "SELECT id_servico FROM servico_tbl where data_inicio like ?";
        try {

            PreparedStatement ps = cnn.prepareStatement(sql);

            ps.setDate(1, Date.valueOf(servico.getData_inicio()));
            
             ResultSet result = ps.executeQuery();

           while(result.next()) {

               // int serv = servico.setId_servico(result.getInt("id_servico"));
                

                //return funcionario;
            }
        } catch (SQLException ex) {

           // JOptionPane.showMessageDialog(null, "this's what does go wrong " + ex);
        }

        //return null;
        return 0;
    }
            

     

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
 

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataevento() {
        return dataevento;
    }

    public void setDataevento(LocalDate dataevento) {
        this.dataevento = dataevento;
    }

    public int getId_servico() {
        return id_servico;
    }

    public void setId_servico(int id_servico) {
        this.id_servico = id_servico;
    }
    
    
    

}
