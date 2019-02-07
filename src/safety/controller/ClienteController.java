
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
    
}
