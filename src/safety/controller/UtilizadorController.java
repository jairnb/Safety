/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safety.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static safety.controller.ServicosController.stage;
import safety.model.dao.UtilizadorDAO;
import safety.model.domain.Utilizador;

/**
 * FXML Controller class
 *
 * @author Leonel Rodriguez
 */
public class UtilizadorController implements Initializable {
    
    @FXML
    private JFXButton btnUser;
    @FXML
    private TableView<Utilizador> tblview;

       @FXML
    private TableColumn<Utilizador, String> tabNome;

    @FXML
    private TableColumn<Utilizador, String> tabTipo;

    @FXML
    private TableColumn<Utilizador, String> tabEstado;

    @FXML
    private TableColumn<Utilizador, String> tabSenha;
    
    
    
     UtilizadorDAO utdao = new UtilizadorDAO();
    //Servico seda = new Servico();
    public static Stage stage = null;
    private static Utilizador utilizador ;
    ObservableList<Utilizador> lista ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        prenxerTabela();
    }   
    
    
    
    public void prenxerTabela() {
        
        tabNome.setCellValueFactory(new PropertyValueFactory<>("nomeutilizador"));
       tabTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
       tabEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        tabSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));
        
        
      

        tblview.setItems(loadTable());
        getClickAddUser();
        

    }
    public ObservableList<Utilizador> loadTable() {

        return FXCollections.observableArrayList(utdao.ListarUtilizador());
    }

    public void getSelectRow() {
        
      utilizador = tblview.getSelectionModel().getSelectedItem();
            

    }
    
    
    
    public void getClickAddUser(){
        
         btnUser.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                try {
                    
                    Parent root = FXMLLoader.load(getClass().getResource("/safety/view/AdicionarUtilizador.fxml"));
                    Scene sc = new Scene(root);
                    Stage stag = new Stage();
                    stag.setScene(sc);
                    stag.setResizable(false);
                    stag.setAlwaysOnTop(true);
                    //this.stage = stage;
                    stage = stag;
                    stage.show();

                } catch (IOException ex) {

                }

            }
        });

    }

    
}
