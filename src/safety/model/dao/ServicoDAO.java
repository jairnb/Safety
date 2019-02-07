package safety.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import safety.model.database.Database;
import safety.model.domain.Servico;

public class ServicoDAO {

    Connection cnn = Database.getConnection();
    PreparedStatement ps = null;
    ResultSet result = null;

   
    public List<Servico> listarServico() {

        String sql = "SELECT * FROM servico_tbl";
        List<Servico> servicos = new ArrayList<>();

        try {

            ps = cnn.prepareStatement(sql);
            result = ps.executeQuery();

            while (result.next()) {

                Servico servico = new Servico();

                servico.setId_servico(result.getInt("id_servico"));
                servico.setData_inicio(result.getDate("data_inicio").toLocalDate());
                servico.setDescricao(result.getString("descricao"));
                servico.setData_termino(result.getDate("data_termino").toLocalDate());
                servico.setCusto(result.getFloat("custo"));
                servico.setPeriodo(result.getString("periodo"));
                servico.setId_cliente(result.getInt("id_cliente"));

                servicos.add( servico);
            }
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "this's what does go wrong " + ex);
        }
        return servicos;
    }

    public boolean removerServico(Servico servico) {
        String sql = "DELETE FROM servico_tbl WHERE id_servico=?";
        try {
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, servico.getId_servico());
            ps.execute();

            return true;

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "this's what does go wrong " + ex);
        }
        return false;
    }

    public boolean adicoanarServico(Servico servico) {
        String sql = "INSERT INTO servico_tbl(data_inicio,descricao,data_termino,custo,periodo,id_cliente) VALUES(?,?,?,?,?,?)";
        try {
            ps = cnn.prepareStatement(sql);

            ps.setDate(1, Date.valueOf(servico.getData_inicio()));
            ps.setString(2, servico.getDescricao());
            ps.setDate(3, Date.valueOf(servico.getData_termino()));
            ps.setFloat(4, servico.getCusto());
            ps.setString(5, servico.getPeriodo());
            ps.setInt(6, servico.getId_cliente());

            ps.execute();

            return true;

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "this's what does go wrong " + ex);
        }
        return false;
    }

    public boolean editarServico(Servico servico) {
        String sql = "UPDATE servico_tbl SET data_inicio=?,descricao=?,data_termino=?,custo=?,periodo=?,id_cliente=? WHERE id_servico=?";
        try {
            ps = cnn.prepareStatement(sql);

            ps.setDate(1, Date.valueOf(servico.getData_inicio()));
            ps.setString(2, servico.getDescricao());
            ps.setDate(3, Date.valueOf(servico.getData_termino()));
            ps.setFloat(4, servico.getCusto());
            ps.setString(5, servico.getPeriodo());
            ps.setInt(6, servico.getId_cliente());
            ps.setInt(7, servico.getId_servico());

            ps.execute();

            return true;

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "this's what does go wrong " + ex);
        }
        return false;
    }

    public Servico pesquisarServico(Servico servico) {

        String sql = "SELECT * FROM servico where id_servico=? or data_inicio=? or data_termino = ?";

        Servico servicoRetorno = new Servico();

        try {
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, servico.getId_servico());
            ps.setDate(2, Date.valueOf(servico.getData_inicio()));
            ps.setDate(3, Date.valueOf(servico.getData_termino()));

            result = ps.executeQuery();

            if (result.next()) {

                servico.setId_servico(result.getInt("id_servico"));
                servico.setData_inicio(result.getDate("data_inicio").toLocalDate());
                servico.setDescricao(result.getString("descricao"));
                servico.setData_termino(result.getDate("data_termino").toLocalDate());
                servico.setCusto(result.getFloat("custo"));
                servico.setPeriodo(result.getString("periodo"));
                servico.setId_cliente(result.getInt("id_cliente"));

                servicoRetorno = servico;
            }
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "this's what does go wrong " + ex);
        }
        return servicoRetorno;

    }

}
