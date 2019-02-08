/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safety.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import safety.model.dao.FuncionarioDAO;
import safety.model.domain.Funcionario;

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
    
    FuncionarioDAO fundao = new FuncionarioDAO();
    public static Stage stage = null;
    private static Funcionario funcionario ;
    ObservableList<Funcionario> lista ;
    
    
      @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        prenxerTabela();
    }  
    
    
    public void prenxerTabela() {
        
        tabNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tabID.setCellValueFactory(new PropertyValueFactory<>("id_funcionario"));
       
        
      

        tablview.setItems(loadTable());
       
        

    }
    public ObservableList<Funcionario> loadTable() {

        return FXCollections.observableArrayList(fundao.listarFuncionario());
    }

    public void getSelectRow() {
        
      funcionario = tablview.getSelectionModel().getSelectedItem();
            

    }
}
