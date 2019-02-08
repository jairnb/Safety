
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
import safety.model.domain.Cliente;
import safety.model.domain.Funcionario;
import safety.model.domain.Servico;
import safety.model.domain.Utilizador;


public class ClienteDAO {
    
    Connection cnn = Database.getConnection();
    PreparedStatement ps = null;
    ResultSet result = null;
    FuncionarioDAO funcionarioDAO;
    
    public List<Cliente> listarCliente() {

        String sql = "SELECT * FROM cliente_tbl";
        List<Cliente> clientes = new ArrayList<>();
        funcionarioDAO = new FuncionarioDAO();

        try {

            ps = cnn.prepareStatement(sql);
            result = ps.executeQuery();

            while (result.next()) {
                Funcionario funcionario = new Funcionario();
                Cliente cliente = new Cliente();
                
                cliente.setId_cliente(result.getInt("id_cliente"));
                cliente.setNome(result.getString("nome"));
                cliente.setSobrenome(result.getString("sobrenome"));
                cliente.setTelefone(result.getInt("telefone"));
                cliente.setNif(result.getInt("nif"));
                cliente.setEmail(result.getString("email"));
                
                funcionario.setId_funcionario(result.getInt("id_funcionario"));
                funcionario = funcionarioDAO.selecionarFuncionario(funcionario);
                
                cliente.setFuncionario(funcionario);

                clientes.add( cliente);
            }
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "this's what does go wrong " + ex);
        }
        return clientes;
    }
    
    public int pegarIdCliente(Connection conn) {

        String sql = "SELECT id_cliente FROM cliente_tbl where nome like ? ";
        
        Cliente clientes = new Cliente();
        int resultado = 0;

        try {

            ps = conn.prepareStatement(sql);

            ps.setInt(6, clientes.getId_cliente());
            
            result = ps.executeQuery();
            resultado = result.getInt("id_cliente");
          
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "this's what does go wrong " + ex);
        }
        return resultado;
    }
    
    public Cliente selecionarCliente(Cliente cliente) {

        String sql = "SELECT * FROM cliente_tbl where id_cliente=?";
        try {

            ps = cnn.prepareStatement(sql);

            ps.setInt(1,cliente.getId_cliente());

            result = ps.executeQuery();

           while(result.next()) {

                cliente.setId_cliente(result.getInt("id_cliente"));
                cliente.setNome(result.getString("nome"));
                cliente.setSobrenome(result.getString("sobrenome"));
                cliente.setNif(result.getInt("nif"));
                cliente.setTelefone(result.getInt("telefone"));    
                cliente.setEmail(result.getString("email"));

                return cliente;
            }
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "this's what does go wrong " + ex);
        }

        return null;
    }

    
}
