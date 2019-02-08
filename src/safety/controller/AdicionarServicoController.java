package safety.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import safety.model.dao.ClienteDAO;
import safety.model.dao.FuncionarioDAO;
import safety.model.dao.ServicoDAO;
import safety.model.database.Database;
import safety.model.domain.Cliente;
import safety.model.domain.Endereco;
import safety.model.domain.Funcionario;
import safety.model.domain.Servico;

public class AdicionarServicoController implements Initializable {

    @FXML
    private JFXComboBox<Cliente> ComBoxcliente;

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
    private TableColumn<Funcionario, String> tblviewAgcolunsobrenome;

    @FXML
    private TableColumn<Funcionario, Integer> tblviewAgcoluntelefone;

    @FXML
    private TableColumn<Funcionario, String> tblviewAgcoluncidade;

    @FXML
    private TableColumn<Funcionario, Boolean> tblviewAgColunSelecionar;

    @FXML
    private JFXTextField txtIlha;

    @FXML
    private JFXTextField txtCidade;

    @FXML
    private JFXTextField txtZona;

    @FXML
    private JFXComboBox<String> ComBoxturno;

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
    private ObservableList<Cliente> listacliente;
    private ObservableList<String> listaturno;
    FuncionarioDAO funciodao = new FuncionarioDAO();
    ClienteDAO clientedao = new ClienteDAO();
    ServicoDAO servicodao = new ServicoDAO();
    Cliente cliente;
    //Servico selectedservico = new Servico();
    //String string[]={"Full time","Diurno","Noturno"};

    @FXML
    public void exgetClickSalvar(ActionEvent event) {
        

        Servico pegaServico = new Servico(datepkrDatain.getValue(),txtareaDescricao.getText(),
                datepkrDatater.getValue() ,Float.valueOf(txtCusto.getText()),ComBoxperiodo.getSelectionModel().getSelectedItem(),
                ComBoxcliente.getSelectionModel().getSelectedItem());
        
        boolean bl = servicodao.adicoanarServico(pegaServico);
        // pegaServico.getCheckbox()?"true":"false";
        
        if(bl == true){
            
            
            
        }
        
        
        
       // Endereco endereco = new Endereco(txtIlha.getText(),txtCidade.getText(),txtZona.getText(),);

        ComBoxcliente.getSelectionModel().getSelectedItem();
        
        ComBoxperiodo.getSelectionModel().getSelectedItem();
        Integer.valueOf(txtCusto.getText());
        txtIlha.getText();
        txtCidade.getText();
        txtZona.getText();
        ComBoxturno.getSelectionModel().getSelectedItem();
        
        Date.valueOf(datepkrDatater.getValue());
        

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        prencherPeriodoCombox();
        prencherTurnoCombox();
        prencherClienteCombox();
        prenxerTabela();
        
   
        

    }

    public void prenxerTabela() {

        tblviewAgColunNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tblviewAgcolunsobrenome.setCellValueFactory(new PropertyValueFactory<>("sobrenome"));
        tblviewAgcoluntelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        tblviewAgcoluncidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
        //tblviewAgColunSelecionar.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tblviewAgColunSelecionar.setCellValueFactory(new PropertyValueFactory<>("selected"));

        tblviewAgColunSelecionar.setCellFactory(CheckBoxTableCell.forTableColumn(tblviewAgColunSelecionar));
        //colunDescricao.setCellFactory(TextFieldTableCell.forTableColumn());

        tblviewAgente.setItems(loadTableAgente());

    }

    public ObservableList<Funcionario> loadTableAgente() {

        return FXCollections.observableArrayList(funciodao.listarAgentes());
    }

    public void prencherPeriodoCombox() {

        listaperiodo = FXCollections.observableArrayList();
        listaperiodo.add("Full time");
        listaperiodo.add("Diurno");
        listaperiodo.add("Noturno");

        ComBoxperiodo.setItems(listaperiodo);

    }

    public void prencherClienteCombox() {

        listacliente = FXCollections.observableArrayList();
        listaperiodo = FXCollections.observableArrayList();
        Cliente.prencherComboxCliente(Database.getConnection(), listacliente);

        ComBoxcliente.setItems(listacliente);

    }

    public void prencherTurnoCombox() {

        listaturno = FXCollections.observableArrayList();
        listaturno.add("0-8");
        listaturno.add("8-16");
        listaturno.add("16-24");

        ComBoxturno.setItems(listaturno);

    }

    public void getClickSalvar() {

        btnCancelar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                ServicosController.stage.close();
                  Servico pegaServico = new Servico(datepkrDatain.getValue(),txtareaDescricao.getText(),
                datepkrDatater.getValue() ,Float.valueOf(txtCusto.getText()),ComBoxperiodo.getSelectionModel().getSelectedItem(),
                ComBoxcliente.getSelectionModel().getSelectedItem());
        
        boolean bl = servicodao.adicoanarServico(pegaServico);
        // pegaServico.getCheckbox()?"true":"false";
        
        if(bl == true){
            
            
            
        }

            }
        });
    }
    public void getClickCancelar() {

        btnCancelar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                ServicosController.stage.close();

            }
        });
    }

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

