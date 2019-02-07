
package safety.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import safety.model.domain.Funcionario;


public class FuncionarioController implements Initializable {

    @FXML
    private TreeTableView<Funcionario> functable;

    @FXML
    private TreeTableColumn<Funcionario, String> colunNome;

    @FXML
    private TreeTableColumn<Funcionario, String> colunApelido;

    @FXML
    private TreeTableColumn<Funcionario, Integer> colunTelefone;

    @FXML
    private TreeTableColumn<Funcionario, String> colunEmail;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
    }    
    
}
