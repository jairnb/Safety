package safety.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import safety.model.database.Database;
import safety.model.domain.Utilizador;

public class UtilizadorDAO {

    Connection cnn = Database.getConnection();
    PreparedStatement ps = null;
    ResultSet result = null;

    public Utilizador SelecionarUsuario(Utilizador utilizador) {

        String sql = "SELECT * FROM utilizador_tbl where nomeutilizador=? and senha=?";
        try {

            ps = cnn.prepareStatement(sql);
            ps.setString(1, utilizador.getNomeutilizador());
            ps.setString(2, utilizador.getSenha());

            result = ps.executeQuery();

            if (result.next()) {

                utilizador.setId_utilizador(result.getInt("id_utilizador"));
                utilizador.setTipo(result.getString("tipo"));
                utilizador.setEstado(result.getString("estado"));

                return utilizador;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "this's what does go wrong " + ex);
        }
        return null;
    }

    public List<Utilizador> ListarUtilizador() {

        String sql = "SELECT * FROM utilizador_tbl";
        List<Utilizador> utilizadores = new ArrayList<>();

        try {

            ps = cnn.prepareStatement(sql);
            result = ps.executeQuery();

            while (result.next()) {

                Utilizador utilizador = new Utilizador();

                utilizador.setId_utilizador(result.getInt("id_utilizador"));
                utilizador.setNomeutilizador(result.getString("nomeutilizador"));
                utilizador.setSenha(result.getString("senha"));
                utilizador.setTipo(result.getString("tipo"));
                utilizador.setEstado(result.getString("estado"));
                utilizador.setId_funcionario(result.getInt("id_funcionario"));

                utilizadores.add(utilizador);
            }
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "this's what does go wrong " + ex);
        }
        return utilizadores;
    }

    public boolean removerUtilizador(Utilizador utilizador) {
        String sql = "DELETE FROM utilizador_tbl WHERE id_utilizador=?";
        try {
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, utilizador.getId_utilizador());
            ps.execute();
            
            return true;
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "this's what does go wrong " + ex);
        }
        return false;
    }

    public boolean adicoanarUtilizador(Utilizador utilizador) {
        String sql = "INSERT INTO utilizador_tbl(nomeutilizador, senha, tipo,estado,id_funcionario) VALUES(?,?,?,?)";
        try {
            ps = cnn.prepareStatement(sql);

            ps.setString(1, utilizador.getNomeutilizador());
            ps.setString(2, utilizador.getSenha());
            ps.setString(3, utilizador.getTipo());
            ps.setString(4, utilizador.getEstado());
            ps.setInt(5, utilizador.getId_funcionario());

            ps.execute();

            return true;

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "this's what does go wrong " + ex);
        }
        return false;
    }

    public boolean editarUsuario(Utilizador utilizador) {
        String sql = "UPDATE utilizador SET nomeutilizador=?, senha=?, tipo=?, estado=?,id_funcionario=? WHERE id_utilizador=?";
        try {
            ps = cnn.prepareStatement(sql);

            
            ps.setString(1, utilizador.getNomeutilizador());
            ps.setString(2, utilizador.getSenha());
            ps.setString(3, utilizador.getTipo());
            ps.setString(4, utilizador.getEstado());
            ps.setInt(5, utilizador.getId_funcionario());
            ps.setInt(6, utilizador.getId_utilizador());

            ps.execute();
            
            
            return true;
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "this's what does go wrong " + ex);
        }
        return false;
    }

    public Utilizador pesquisarUtilizador(Utilizador utilizador) {
        
        String sql = "SELECT * FROM utilizador where id_utilizador=? or nomeutilizador=? or tipo = ? or estado=? or id_funcionario=?";
        
        Utilizador utilizadorRetorno = new Utilizador();
        
        try {
            ps = cnn.prepareStatement(sql);
           ps.setInt(1, utilizador.getId_utilizador());

           result = ps.executeQuery();
            if (result.next()) {
                
                utilizador.setId_utilizador(result.getInt("id_utilizador"));                
                utilizador.setNomeutilizador(result.getString("nomeutilizador"));               
                utilizador.setSenha(result.getString("senha"));
                utilizador.setTipo(result.getString("tipo"));
                utilizador.setEstado(result.getString("estado"));
                utilizador.setId_funcionario(result.getInt("id_funcionario"));
                
                
                utilizadorRetorno = utilizador;
            }
        } catch (SQLException ex) {
            
             JOptionPane.showMessageDialog(null, "this's what does go wrong " + ex);
        }
        return utilizadorRetorno;

    }
}


