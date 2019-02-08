package safety.model.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

public class Cliente {

//todos os atributos da classe cliente    
    private int id_cliente;
    private String nome;
    private String sobrenome;
    private int nif;
    private int telefone;
    private String email;
    private Funcionario funcionario;

//todos os metos geters e seters da classe cliente
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {

        return nome;

    }

    public static void prencherComboxCliente(Connection conect, ObservableList<Cliente> listarcliente) {

        PreparedStatement ps = null;
        ResultSet result = null;

        String sql = "select nome,id_cliente from cliente_tbl";

        try {
            ps = conect.prepareStatement(sql);
            result = ps.executeQuery();
            Cliente cliente = new Cliente();

            while (result.next()) {

                cliente.setNome(result.getString("nome"));
                cliente.setId_cliente(result.getInt("id_cliente"));
                listarcliente.add(cliente);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "this's what does go wrong " + ex);
        }

    }

}
