package safety.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import safety.model.dao.ServicoDAO;
import safety.model.domain.Servico;

public class ServicosController implements Initializable {

    @FXML
    private TableView<Servico> tableview;

    @FXML
    private TableColumn<Servico, LocalDate> colunDTinicio;

    @FXML
    private TableColumn<Servico, LocalDate> colunDTtermino;

    @FXML
    private TableColumn<Servico, String> colunDescricao;

    @FXML
    private TableColumn<Servico, Float> colunCusto;

    @FXML
    private TableColumn<Servico, String> colunPeriodo;

    @FXML
    private TableColumn<Servico, Boolean> colunElim;

    @FXML
    private TextField campopesquisar;

    @FXML
    private JFXButton btnaddservico;

    @FXML
    private JFXButton btneditar;

    @FXML
    private JFXButton btneliminar;

    @FXML
    private JFXButton btndetalhes;

    /*@FXML
    private TableColumn<Servico, Button> colunEdit;*/
    //classe servicodao que contem os metodos de acesso a base de dados
    ServicoDAO sedao = new ServicoDAO();
    //Servico seda = new Servico();
    public static Stage stage = null;
    private static Servico servicos;
    ObservableList<Servico> lista;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        prenxerTabela();

    }

    public void prenxerTabela() {

        colunDTinicio.setCellValueFactory(new PropertyValueFactory<>("data_inicio"));
        colunDTtermino.setCellValueFactory(new PropertyValueFactory<>("data_termino"));
        colunCusto.setCellValueFactory(new PropertyValueFactory<>("custo"));
        colunPeriodo.setCellValueFactory(new PropertyValueFactory<>("periodo"));
        colunDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colunElim.setCellValueFactory(new PropertyValueFactory<>("selected"));

        colunElim.setCellFactory(CheckBoxTableCell.forTableColumn(colunElim));
        colunDescricao.setCellFactory(TextFieldTableCell.forTableColumn());

        tableview.setItems(loadTable());
        getSelectRow();
        getClickNovo();
        apagarChekBoxSelecionado();

    }

    public ObservableList<Servico> loadTable() {

        return FXCollections.observableArrayList(sedao.listarServico());
    }

    public void getSelectRow() {

        tableview.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Servico>() {
            @Override
            public void changed(ObservableValue<? extends Servico> observable,
                    Servico valorAnterior, Servico valorAtual) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                servicos = valorAtual;

                btneditar.setDisable(false);
                btneliminar.setDisable(false);
                btndetalhes.setDisable(false);
                

            }

        });

    }

    public void getClickNovo() {

        btnaddservico.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                try {

                    Parent root = FXMLLoader.load(getClass().getResource("/safety/view/AdicionarServico.fxml"));
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

    public void getClickDetail() {

        btndetalhes.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                try {

                    Parent root = FXMLLoader.load(getClass().getResource("/safety/view/AdicionarServico.fxml"));
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

    public void apagarChekBoxSelecionado() {

        btneliminar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                ObservableList<Servico> listaServicoToremove = FXCollections.observableArrayList();
                for (Servico sendo : loadTable()) {
                    if (sendo.getCheckbox() == true) {

                        listaServicoToremove.add(sendo);

                    }
                }
            }
            }); 
    }
}
