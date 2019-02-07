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
import safety.model.domain.Funcionario;

public class FuncionarioDAO {

    Connection cnn = Database.getConnection();
    PreparedStatement ps = null;
    ResultSet result = null;

   /* public Funcionario selecionarFuncionario(Funcionario funcionario) {

        String sql = "SELECT * FROM funcionario_tbl where id_funcionario=?";
        try {

            ps = cnn.prepareStatement(sql);

            ps.setInt(1, funcionario.getId_funcionario());

            result = ps.executeQuery();

            if (result.next()) {

                funcionario.setId_funcionario(result.getInt("id_funcionario"));
                funcionario.setNome(result.getString("nome"));
                funcionario.setSobrenome(result.getString("sobrenome"));
                funcionario.setTelefone(result.getInt("telefone"));
                funcionario.setEmail(result.getString("email"));
                funcionario.setCidade(result.getString("cidade"));
                funcionario.setData_nasc(result.getDate("data_nasc").toLocalDate());

                return funcionario;
            }
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "this's what does go wrong " + ex);
        }

        return null;
    }*/

    public List<Funcionario> listarFuncionario() {

        String sql = "SELECT * FROM funcionario_tbl";
        List<Funcionario> funcionarios = new ArrayList<>();

        try {

            ps = cnn.prepareStatement(sql);
            result = ps.executeQuery();

            while (result.next()) {

                Funcionario funcionario = new Funcionario();

                funcionario.setId_funcionario(result.getInt("id_funcionario"));
                funcionario.setNome(result.getString("nome"));
                funcionario.setSobrenome(result.getString("sobrenome"));
                funcionario.setTelefone(result.getInt("telefone"));
                funcionario.setEmail(result.getString("email"));
                funcionario.setCidade(result.getString("cidade"));
                funcionario.setData_nasc(result.getDate("data_nasc").toLocalDate());
                funcionario.setZona(result.getString("zona"));

                funcionarios.add(funcionario);

            }
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "this's what does go wrong " + ex);
        }
        return funcionarios;
    }

    public boolean removerFuncionario(Funcionario funcionario) {

        String sql = "DELETE FROM funcionario_tbl WHERE id_funcionario=?";
        try {
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, funcionario.getId_funcionario());
            ps.execute();

            return true;

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "this's what does go wrong " + ex);
        }
        return false;
    }

    public boolean adicoanarFuncionario(Funcionario funcionario) {

        String sql = "INSERT INTO funcionario_tbl(nome,sobrenome, telefone,email,cidade,data_nasc,zona) VALUES(?,?,?,?,?,?,?)";
        try {
            ps = cnn.prepareStatement(sql);

            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getSobrenome());
            ps.setInt(3, funcionario.getTelefone());
            ps.setString(4, funcionario.getEmail());
            ps.setString(5, funcionario.getCidade());
            ps.setDate(6, Date.valueOf(funcionario.getData_nasc()));
            ps.setString(7, funcionario.getZona());

            ps.execute();

            return true;

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "this's what does go wrong " + ex);
        }
        return false;
    }

    public boolean editarFuncionario(Funcionario funcionario) {

        String sql = "UPDATE funcionario_tbl SET nome=?,sobrenome=?, telefone=?,email=?,cidade=?,data_nasc=?,zona=? WHERE id_funcionario=?";

        try {

            ps = cnn.prepareStatement(sql);

            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getSobrenome());
            ps.setInt(3, funcionario.getTelefone());
            ps.setString(4, funcionario.getEmail());
            ps.setString(5, funcionario.getCidade());
            ps.setDate(6, Date.valueOf(funcionario.getData_nasc()));
            ps.setString(7, funcionario.getZona());
            ps.setInt(8, funcionario.getId_funcionario());

            ps.execute();

            return true;

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "this's what does go wrong " + ex);
        }
        return false;
    }

    public Funcionario pesquisarFuncionario(Funcionario funcionario) {

        String sql = "SELECT * FROM funcionario where id_funcionario=? or nome=? or sobrenome=? ";

        Funcionario funcionarioRetorno = new Funcionario();

        try {
            
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, funcionario.getId_funcionario());
            ps.setString(2, funcionario.getNome());
            ps.setString(3, funcionario.getSobrenome());
         

            result = ps.executeQuery();
            
            if (result.next()) {

                funcionario.setId_funcionario(result.getInt("id_funcionario"));
                funcionario.setNome(result.getString("nome"));
                funcionario.setSobrenome(result.getString("sobrenome"));
                funcionario.setTelefone(result.getInt("telefone"));
                funcionario.setEmail(result.getString("email"));
                funcionario.setCidade(result.getString("cidade"));
                funcionario.setData_nasc(result.getDate("data_nasc").toLocalDate());
                funcionario.setZona(result.getString("zona"));

                funcionarioRetorno = funcionario;
            }
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "this's what does go wrong " + ex);
        }
        return funcionarioRetorno;

    }
}
