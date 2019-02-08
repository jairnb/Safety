
package safety.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.swing.JOptionPane;
import safety.model.dao.ClienteDAO;
import safety.model.domain.Cliente;


public class ClienteController implements Initializable {

    @FXML
    private TableView<Cliente> clinetesTableView;
    @FXML
    private TableColumn<Cliente, String> nomeTableColumn;
    @FXML
    private TableColumn<Cliente, String> sobrenomeTableColumn;
    @FXML
    private TableColumn<Cliente, Integer> telefoneTableColumn;
    @FXML
    private TableColumn<Cliente, String> emailTableColumn;
    @FXML
    private TableColumn<Cliente, Integer> nifTableColumn;

    ClienteDAO clienteDAO = new ClienteDAO();
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        prenxerTabela();
        
        
    }    
    
    public void prenxerTabela() {        
        nomeTableColumn.setCellValueFactory(new PropertyValueFactory("nome"));
        sobrenomeTableColumn.setCellValueFactory(new PropertyValueFactory("sobrenome"));
        emailTableColumn.setCellValueFactory(new PropertyValueFactory("email"));
        telefoneTableColumn.setCellValueFactory(new PropertyValueFactory("telefone"));
        nifTableColumn.setCellValueFactory(new PropertyValueFactory("nif"));
        
        clinetesTableView.setItems(loadTable());
        
    }
    
    public ObservableList<Cliente> loadTable() {
        return FXCollections.observableArrayList(clienteDAO.listarCliente());
    }
     
    @FXML
    public void removerCliente(){
        Cliente cliente = clinetesTableView.getSelectionModel().getSelectedItem();
        
        if(cliente != null ){
            int selectedOption = JOptionPane.showConfirmDialog(null,"Tens certeza que queres remover?","Remover Cliente",JOptionPane.YES_NO_OPTION);
                if(selectedOption== JOptionPane.YES_OPTION){
                    clienteDAO.removerCliente(cliente);
                    prenxerTabela();                    
                }           
        }else {
           JOptionPane.showMessageDialog(null,"Selecionar Primeiro");
        }
    } 
     
    @FXML
    public void adicionarCliente() throws IOException{
        Cliente cliente = new Cliente();
        
        boolean botaoConfirmarClick = showCliente(cliente);
        if(botaoConfirmarClick){
            boolean sucesso = clienteDAO.adicoanarCliente(cliente);
            if(!sucesso){
                JOptionPane.showMessageDialog(null,"Não Possivel Concluir a operação");
            }else{
                JOptionPane.showMessageDialog(null,"Sucesso");
            }
            prenxerTabela();
        }
    }
    
    @FXML
    public void editarCliente() throws IOException{
        Cliente cliente = clinetesTableView.getSelectionModel().getSelectedItem();
        
        if(cliente != null){
            boolean botaoConfirmarClick = showCliente(cliente);
            if(botaoConfirmarClick){
                boolean sucesso = clienteDAO.editarCliente(cliente);
                if(!sucesso){
                    JOptionPane.showMessageDialog(null,"Nome existente");
                }
                prenxerTabela();
            }
        }else {
           JOptionPane.showMessageDialog(null,"Selecionar Primeiro");
        }        
    }
     
    public boolean showCliente(Cliente cliente) throws IOException{
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(AdicionarClienteController.class.getResource("/safety/view/AdicionarCliente.fxml"));
        AnchorPane pane = (AnchorPane) loader.load();
        
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cliente");
        dialogStage.setResizable(false);
        
        
        Scene scene = new Scene(pane);
        dialogStage.setScene(scene);
        
        AdicionarClienteController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setCliente(cliente);
        
        
        dialogStage.setAlwaysOnTop(true);
        dialogStage.showAndWait();
        return controller.isBotaoConfirmar();
    }
    
     
     
     
     
     
     
     
   
}
