package safety.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import safety.model.database.Database;
import safety.model.domain.Funcionario;
import safety.model.domain.Servico;

public class AdicionarServicoController implements Initializable {

    @FXML
    private JFXComboBox<Funcionario> ComBoxcliente;

    @FXML
    private TextArea txtareaDescricao;

    @FXML
    private JFXComboBox<String> ComBoxperiodo;
    @FXML
    private JFXTextField txtCusto;

    @FXML
    private TableView<Funcionario> tblviewAgente;

    @FXML
    private TableColumn<Funcionario, String> tblviewAgColunNome;

    @FXML
    private TableColumn<Funcionario, String> tblviewAgColunSelecionar;

    @FXML
    private JFXTextField txtIlha;

    @FXML
    private JFXTextField txtCidade;

    @FXML
    private JFXTextField txtZona;

    @FXML
    private JFXComboBox<Funcionario> ComBoxturno;

    @FXML
    private DatePicker datepkrDatain;

    @FXML
    private DatePicker datepkrDatater;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnCancelar;

    ////////////////////////////////////////////////////////
    private ObservableList<String> listaperiodo;
    Servico selectedservico = new Servico();
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
      
       
   // }
    //public void initData(Servico servico){
        
        listaperiodo = FXCollections.observableArrayList();
        Servico.geralInfoPeriodo( listaperiodo);
        //selectedservico=servico;
        //txtareaDescricao.setText(selectedservico.getDescricao());
        ComBoxperiodo.setItems(listaperiodo);
        
        //listaperiodo.add(selectedservico);
        
        
        
        
    }

    public void getClickCancelar() {

        btnCancelar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                ServicosController.stage.close();

            }
        });
    }
    
    public void getClickSalvar(){
        
          btnSalvar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                
                
               
                }

            }
        );
        
        
    }
    /*aqui sim e para quando quero exibir valores no combox para criar um servico
    public void initData(Servico servico){
        
        listaperiodo = FXCollections.observableArrayList();        
        selectedservico=servico;
        txtareaDescricao.setText(selectedservico.getDescricao());
        ComBoxperiodo.setItems(listaperiodo);
        
        listaperiodo.add(selectedservico);                
        }
     //public void initData(Servico servico){
        
        listaperiodo = FXCollections.observableArrayList();
        Servico.geralInfoPeriodo(Database.getConnection(), listaperiodo);
        //selectedservico=servico;
        //txtareaDescricao.setText(selectedservico.getDescricao());
        ComBoxperiodo.setItems(listaperiodo);
        
        //listaperiodo.add(selectedservico);
        
        
        
        
    }
       
    */
    
   

}
