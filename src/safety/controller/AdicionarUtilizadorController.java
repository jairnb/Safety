/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safety.controller;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import safety.model.dao.FuncionarioDAO;
import safety.model.domain.Funcionario;
import safety.model.domain.Utilizador;

/**
 *
 * @author Leonel Rodriguez
 */
public class AdicionarUtilizadorController implements Initializable{
    
    
    @FXML
    private AnchorPane AnchorAddUser;

    @FXML
    private TableView<Funcionario> tablview;

    @FXML
    private TableColumn<Funcionario, Integer> tabID;

    @FXML
    private TableColumn<Funcionario, String> tabNome;
    
       @FXML
    private JFXTextField textFieldSenha;
        @FXML
    private TableColumn<Funcionario, String> tabSobrenome;

    @FXML
    private JFXTextField txtFieldConSenha;

    @FXML
    private ComboBox<String> comboBoxTipo;
    
    FuncionarioDAO fundao = new FuncionarioDAO();
    public static Stage stage = null;
    private static Funcionario funcionario ;
    ObservableList<String> lista ;
    
    ArrayList<String> tipo = new ArrayList<>();
    
    
      @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        prenxerTabela();
        carregarTipo();
    }  
    
    
    public void prenxerTabela() {
        
        tabNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tabID.setCellValueFactory(new PropertyValueFactory<>("id_funcionario"));
        tabSobrenome.setCellValueFactory(new PropertyValueFactory<>("sobrenome"));
       
        
      

        tablview.setItems(loadTable());
       
        

    }
    public ObservableList<Funcionario> loadTable() {

        return FXCollections.observableArrayList(fundao.listarFuncionario());
    }

    public void getSelectRow() {
        
      funcionario = tablview.getSelectionModel().getSelectedItem();
            

    }
    
    public void carregarTipo(){
        
        tipo.add("Administrador");
        tipo.add("Agente");
        tipo.add("Secretária");
        
        lista = FXCollections.observableArrayList(tipo);
        
        comboBoxTipo.setItems(lista);
        
   }
}
